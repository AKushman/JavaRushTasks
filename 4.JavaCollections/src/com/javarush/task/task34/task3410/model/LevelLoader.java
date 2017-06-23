package com.javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Set<Wall> walls = new HashSet<>();
        boxes.add(new Box(300, 300));
        homes.add(new Home(200, 200));
        walls.add(new Wall(250, 250));
        walls.add(new Wall(250, 260));
        walls.add(new Wall(250, 270));
        return new GameObjects(walls, boxes, homes, new Player(100, 100));
    }
}
