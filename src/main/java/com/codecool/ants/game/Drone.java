package com.codecool.ants.game;

import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Drone extends Ant {

    private Position position;
    private final Colony colony;
    private int matingTimeCounter = 0;

    public Drone(Position position, Colony colony) {
        this.position = position;
        this.colony = colony;
    }

    @Override
    public void move() {
        int x = this.position.getX();
        int y = this.position.getY();
        int xQ = colony.getCoordinatesOfQueen()[0];
        int yQ = colony.getCoordinatesOfQueen()[1];

        int distX = xQ - x;
        int distY = yQ - y;

        if(Math.abs(distX) <= 1 && Math.abs(distY) <= 1) {

                toMateOrNotToMate();

        } else {
            int newX = x < xQ ? x + 1 : x > xQ ? x - 1 : x;
            int newY = y < yQ ? y + 1 : y > yQ ? y - 1 : y;

            if(colony.isValidMovement(newX, newY)) {
                this.setPosition(colony.getPosition(newX, newY));
                colony.getPosition(x, y).setAnt(null);
                colony.getPosition(newX, newY).setAnt(this);
            }
        }
    }



    private void toMateOrNotToMate() {
        if(!Queen.getQueen().isInMood()){
            if(this.matingTimeCounter == 0) {
                System.out.println(":(");
                queenKickedMeAway();
            } else {
                matingTimeCounter--;
            }

        } else {
            System.out.println("HALLELUJAH");
            Queen.getQueen().setInMood(false);
            this.matingTimeCounter = 9;
        }
    }

    private void queenKickedMeAway(){
        int x = this.position.getX();
        int y = this.position.getY();
        int xQ = colony.getCoordinatesOfQueen()[0];
        int yQ = colony.getCoordinatesOfQueen()[1];

        Random random = new Random();
        int newX = xQ + random.nextInt(colony.getWidth()) - colony.getWidth()/2;
        int newY;
        if (newX == 0 || newX == colony.getWidth() - 1){
            newY = yQ + random.nextInt(colony.getWidth()) - colony.getWidth()/2;
        } else {
            newY = random.nextInt(colony.getWidth()) % 2 == 0 ? 0 : colony.getWidth() - 1;
        }

        this.setPosition(colony.getPosition(newX, newY));
        colony.getPosition(x, y).setAnt(null);
        colony.getPosition(newX, newY).setAnt(this);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
