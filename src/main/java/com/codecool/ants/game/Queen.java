package com.codecool.ants.game;

import java.util.Random;

public class Queen extends Ant {

    private static Queen QUEEN;
    private boolean inMood;
    private int changeMoodCounter;


    private Queen() {
        this.setInMood(true);
    }

    public static Queen getQueen(){
        if(QUEEN == null) {
            QUEEN = new Queen();
        }
        return QUEEN;
    }

    @Override
    public void move() {
        if(!isInMood()) {
            changeMoodCounter--;
            if (changeMoodCounter == 0){
                setInMood(true);
            }
        }
    }

    public boolean isInMood() {
        return inMood;
    }

    public void setInMood(boolean inMood) {
        this.inMood = inMood;
        Random random = new Random();
        changeMoodCounter = random.nextInt(50) + 50;

    }
}
