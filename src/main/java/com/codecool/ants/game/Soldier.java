package com.codecool.ants.game;

import com.codecool.ants.geometry.Position;

public class Soldier extends Ant {

    private Position position;

    public Soldier(Position position) {
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
