package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {

    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(int x, int y) {
        setX(this.getX() + x);
        setY(this.getY() + y);
    }

    @Override
    public void draw(Graphics graphics) {
        int cornerX = getX() - getWidth()/2;
        int cornerY = getY() - getHeight()/2;
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(cornerX, cornerY, getWidth(), getHeight());
    }
}
