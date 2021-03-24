package com.codecool.ants.geometry;

import com.codecool.ants.game.Ant;

public class Position {

    public final int x;
    public final int y;
    private Ant ant;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.ant = null;
    }

    public Ant getAnt() {
        return ant;
    }

    public void setAnt(Ant ant) {
        this.ant = ant;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}