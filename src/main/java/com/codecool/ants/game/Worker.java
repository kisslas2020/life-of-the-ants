package com.codecool.ants.game;

import com.codecool.ants.geometry.Position;

public class Worker extends Ant {

    private Position position;

    public Worker(Position position) {
        this.position = position;
    }

    @Override
    public void move() {

    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
