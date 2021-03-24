package com.codecool.ants.game;

import com.codecool.ants.geometry.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colony {

    private final int width;
    private final Position[][] colony;
    private List<Ant> antsOfColony = new ArrayList<>();
    private final int[] coordinatesOfQueen = new int[2];

    public Colony(int width) {
        this.width = width;
        colony = generateColony();
        colony[coordinatesOfQueen[0]][coordinatesOfQueen[1]].setAnt(Queen.getQueen());
        antsOfColony.add(Queen.getQueen());
    }

    private Position[][] generateColony() {
        Position[][] temp = new Position[width][width];
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < width; j++) {
                temp[i][j] = new Position(i, j);
            }
        }
        coordinatesOfQueen[0] = width / 2;
        coordinatesOfQueen[1] = width / 2;
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
            colony[x][y].setAnt(new Drone(colony[x][y], this));
            antsOfColony.add(colony[x][y].getAnt());
        }
        for (int i = 0; i < workers; i++) {
            int x, y;
            do {
                x = random.nextInt(width);
                y = random.nextInt(width);
            } while(colony[x][y].getAnt() != null);
            colony[x][y].setAnt(new Worker(colony[x][y], this));
            antsOfColony.add(colony[x][y].getAnt());
        }
        for (int i = 0; i < soldiers; i++) {
            int x, y;
            do {
                x = random.nextInt(width);
                y = random.nextInt(width);
            } while(colony[x][y].getAnt() != null);
            colony[x][y].setAnt(new Soldier(colony[x][y], this));
            antsOfColony.add(colony[x][y].getAnt());
        }
    }

    public void update(){

    }

    public boolean isValidMovement(int x, int y) {
        if (x < 0 || y < 0 || x == width || y == width){
            return false;
        }
        if (colony[x][y].getAnt() != null) {
            return false;
        }
        return true;
    }

    public int getWidth() {
        return width;
    }

    public Position getPosition(int x, int y) {
        return colony[x][y];
    }

    public int[] getCoordinatesOfQueen(){
        return coordinatesOfQueen;
    }

    public List<Ant> getAntsOfColony() {
        return List.copyOf(antsOfColony);
    }
}
