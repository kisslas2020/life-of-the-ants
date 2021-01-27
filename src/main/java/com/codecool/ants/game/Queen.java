package com.codecool.ants.game;

import com.codecool.ants.geometry.Position;

public class Queen extends Ant {

    private static Queen QUEEN;


    private Queen() {

    }

    public static Queen getQueen(){
        if(QUEEN == null) {
            QUEEN = new Queen();
        }
        return QUEEN;
    }

    @Override
    public void move() {

    }
}
