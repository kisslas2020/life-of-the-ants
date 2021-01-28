package com.codecool.ants.game;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Soldier extends Ant {

    private Position position;
    private final Colony colony;
    private int directionNumber;

    public Soldier(Position position, Colony colony) {
        this.position = position;
        this.colony = colony;
        directionNumber = setFirstDirection();
    }

    @Override
    public void move() {
        int x = this.position.getX();
        int y = this.position.getY();
        if (directionNumber == 0) {
            directionNumber = Direction.values().length - 1;
        } else {
            directionNumber--;
        }
        //directionNumber = directionNumber == Direction.values().length - 1 ? 0 : directionNumber++;
        Direction newDirection = Direction.values()[directionNumber];
        switch (newDirection){
            case NORTH:
                if(colony.isValidMovement(x - 1, y)) {
                    this.setPosition(colony.getPosition(x - 1, y));
                    colony.getPosition(x, y).setAnt(null);
                    colony.getPosition(x - 1, y).setAnt(this);
                }
                break;
            case EAST:
                if(colony.isValidMovement(x, y + 1)) {
                    this.setPosition(colony.getPosition(x, y + 1));
                    colony.getPosition(x, y).setAnt(null);
                    colony.getPosition(x, y + 1).setAnt(this);
                }
                break;
            case SOUTH:
                if(colony.isValidMovement(x + 1, y)) {
                    this.setPosition(colony.getPosition(x + 1, y));
                    colony.getPosition(x, y).setAnt(null);
                    colony.getPosition(x + 1, y).setAnt(this);
                }
                break;
            case WEST:
                if(colony.isValidMovement(x, y - 1)) {
                    this.setPosition(colony.getPosition(x, y - 1));
                    colony.getPosition(x, y).setAnt(null);
                    colony.getPosition(x, y - 1).setAnt(this);
                }
                break;
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    private int setFirstDirection(){
        Random random = new Random();
        return random.nextInt(Direction.values().length);
    }
}
