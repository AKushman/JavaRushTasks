package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int maxTile;
    int score;

    Stack<Tile[][]> previousStates = new Stack();
    Stack<Integer> previousScores = new Stack();

    private boolean isSaveNeeded = true;

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public Model() {
        resetGameTiles();
    }

    void resetGameTiles() {
        this.gameTiles = new Tile[][]{
                {new Tile(), new Tile(), new Tile(), new Tile()},
                {new Tile(), new Tile(), new Tile(), new Tile()},
                {new Tile(), new Tile(), new Tile(), new Tile()},
                {new Tile(), new Tile(), new Tile(), new Tile()},
        };
        addTile();
        addTile();
        score = 0;
        maxTile = 2;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (Tile[] rowOfTiles : gameTiles) {
            for (Tile tile : rowOfTiles) {
                if (tile.isEmpty())
                    emptyTiles.add(tile);
            }
        }
        return emptyTiles;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            Tile tile  = emptyTiles.get((int) (emptyTiles.size() * Math.random()));
            tile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].value == 0) {
                Tile tmp = tiles[i];
                for (int j = i; j < tiles.length; j++) {
                    if (tiles[j].value != 0) {
                        tiles[i] = tiles[j];
                        tiles[j] = tmp;
                        isChanged = true;
                        break;
                    }
                }
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (!tiles[i].isEmpty() && tiles[i].value != 2048 && tiles[i].value == tiles[i + 1].value) {
                tiles[i].value *= 2;
                score += tiles[i].value;
                tiles[i + 1].value = 0;
                isChanged = true;
                compressTiles(tiles);
                if (tiles[i].value > maxTile) {
                    maxTile = tiles[i].value;
                }
            }
        }
        return isChanged;
    }

    public void left() {
        if (isSaveNeeded)
            saveState(gameTiles);
        boolean isCompressed = false;
        boolean isMerged = false;
        for (Tile[] tiles : gameTiles) {
            isCompressed = compressTiles(tiles);
            isMerged =  mergeTiles(tiles);
        }
        if (isCompressed || isMerged)
            addTile();
        isSaveNeeded = true;
    }

    public void turn() {
        Tile[][] copy = gameTiles.clone();
        for (int x = 0; x < FIELD_WIDTH; x++) {
            Tile[] newRow = new Tile[FIELD_WIDTH];
            int i = 0;
            for (int y = FIELD_WIDTH; y > 0; y--) {
                newRow[i] = copy[y - 1][x];
                i++;
            }
            gameTiles[x] = newRow;
        }
    }

    public void down() {
        saveState(gameTiles);
        turn();
        left();
        turn();
        turn();
        turn();
    }

    public void right() {
        saveState(gameTiles);
        turn();
        turn();
        left();
        turn();
        turn();
    }

    public void up() {
        saveState(gameTiles);
        turn();
        turn();
        turn();
        left();
        turn();
    }

    public boolean canMove() {
        return (!getEmptyTiles().isEmpty() || canMerge());
    }

    private boolean canMerge() {
        boolean canMerge = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value || gameTiles[j][i].value == gameTiles[j + 1][i].value)
                    canMerge = true;
            }
        }
        return canMerge;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] newTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[y].length; x++) {
                newTiles[y][x] = new Tile(tiles[y][x].value);
            }
        }
        previousStates.push(newTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.empty() && !previousScores.empty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) Math.random() * 100) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                down();
                break;
            case 2:
                right();
                break;
            case 3:
                up();
                break;
        }
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::down));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.poll().getMove().move();
    }

    public boolean hasBoardChanged() {
        return countTotalWeigh(gameTiles) - countTotalWeigh(previousStates.peek()) != 0;
    }

    private int countTotalWeigh(Tile[][] tiles) {
        int total = 0;
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                total += tile.value;
            }
        }
        return total;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        int emptyTiles = -1;
        int sc = 0;
        if (hasBoardChanged()) {
            emptyTiles = getEmptyTiles().size();
            sc = score;
        }
        rollback();
        return new MoveEfficiency(emptyTiles, sc, move);
    }
}
