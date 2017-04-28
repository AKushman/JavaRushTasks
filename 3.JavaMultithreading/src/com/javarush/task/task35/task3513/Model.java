package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int maxTile;
    int score;

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
        boolean isCompressed = false;
        boolean isMerged = false;
        for (Tile[] tiles : gameTiles) {
            isCompressed = compressTiles(tiles);
            isMerged =  mergeTiles(tiles);
        }
        if (isCompressed || isMerged)
            addTile();
    }


}
