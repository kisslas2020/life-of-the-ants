package com.codecool.ants.game;

import com.codecool.ants.geometry.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colony {

    private final int width;
    private final Position[][] colony;

    public Colony(int width) {
        this.width = width;
        colony = generateColony();
        colony[width/2][width/2].setAnt(Queen.getQueen());

    }

    private Position[][] generateColony() {
        Position[][] temp = new Position[width][width];
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < width; j++) {
                temp[i][j] = new Position(i, j);
            }
        }
        return temp;
    }

    public void generateAnts(int drones, int workers, int soldiers) {
        Random random = new Random();
        for(int i = 0; i < drones; i++) {
            int x, y;
            do {
                x = random.nextInt(width);
                y = random.nextInt(width);
            } while(colony[x][y].getAnt() != null);
            colony[x][y].setAnt(new Drone(colony[x][y]));
        }
        for (int i = 0; i < workers; i++) {
            int x, y;
            do {
                x = random.nextInt(width);
                y = random.nextInt(width);
            } while(colony[x][y].getAnt() != null);
            colony[x][y].setAnt(new Worker(colony[x][y]));
        }
        for (int i = 0; i < soldiers; i++) {
            int x, y;
            do {
                x = random.nextInt(width);
                y = random.nextInt(width);
            } while(colony[x][y].getAnt() != null);
            colony[x][y].setAnt(new Soldier(colony[x][y]));
        }
    }

    public void update(){

    }

    public int getWidth() {
        return width;
    }

    public Position getPosition(int x, int y) {
        return colony[x][y];
    }
}
