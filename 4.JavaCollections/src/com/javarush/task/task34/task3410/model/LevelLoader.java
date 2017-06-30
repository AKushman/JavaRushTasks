package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class LevelLoader {
    static Path levels;
    static Map<Integer, GameObjects> levelMap;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        int levelToLoad = level % 60;
        if (levelToLoad == 0)
            levelToLoad = 60;
        if (levelMap == null)
            levelMap = loadLevels();
        return levelMap.get(levelToLoad);
    }

    private Map<Integer, GameObjects> loadLevels() {
        Map<Integer, GameObjects> levelMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))) {
            while (reader.ready()) {
                String s = reader.readLine();
                if (s.startsWith("*****")) {
                    Set<Wall> walls = new HashSet<>();
                    Set<Box> boxes = new HashSet<>();
                    Set<Home> homes = new HashSet<>();
                    Player player = null;
                    int level = Integer.parseInt(reader.readLine().split(" ")[1]);
                    reader.readLine();
                    int X = Integer.parseInt(reader.readLine().split(" ")[2]);
                    int Y = Integer.parseInt(reader.readLine().split(" ")[2]);
                    char[][] objectMap = new char[Y][X];
                    reader.readLine();
                    reader.readLine();
                    reader.readLine();
                    for (int i = 0; i < Y; i++) {
                        objectMap[i] = reader.readLine().toCharArray();
                    }
                    int cell_size =  Model.FIELD_CELL_SIZE;
                    int X0 = cell_size/2;
                    int Y0 = cell_size/2;
                    for (int j = 0; j < Y; j++) {
                        for (int i = 0; i < X; i++) {
                            switch (objectMap[j][i]) {
                                case 'X' :
                                    walls.add(new Wall(X0 + cell_size * i, Y0 + cell_size * j));
                                    break;
                                case '*' :
                                    boxes.add(new Box(X0 + cell_size * i, Y0 + cell_size * j));
                                    break;
                                case '.' :
                                    homes.add(new Home(X0 + cell_size * i, Y0 + cell_size * j));
                                    break;
                                case '&' :
                                    boxes.add(new Box(X0 + cell_size * i, Y0 + cell_size * j));
                                    homes.add(new Home(X0 + cell_size * i, Y0 + cell_size * j));
                                    break;
                                case '@' :
                                    player = new Player(X0 + cell_size * i, Y0 + cell_size * j);
                                    break;
                            }
                        }
                    }
                    levelMap.put(level, new GameObjects(walls, boxes, homes, player));
                    if (level == 60)
                        break;
                }
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("No file");
        } catch (IOException e) {
            System.out.println("IO Ex");
        }
        return levelMap;
    }

}
