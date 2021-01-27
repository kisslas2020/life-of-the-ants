package com.codecool.ants;

import com.codecool.ants.game.*;


public class Simulator {

    private static Colony colony;

    public static final String RED = "\033[0;31m";     // RED
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String BLUE = "\033[0;34m";    // BLUE


    public static void main(String[] args) {
        System.out.println("You can use `mvn package; java -jar target/ants-1.0.jar` to run this app from the console");
        colony = new Colony(20);
        colony.generateAnts(10,10,10);
        update();



    }



    public static void update() {
        display();
    }

    public static void display(){
        for(int i = 0; i < colony.getWidth(); i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < colony.getWidth(); j++) {
                if(colony.getPosition(i, j).getAnt() == null) {
                    sb.append(" . ");
                } else {
                    if(colony.getPosition(i, j).getAnt() instanceof Drone) {
                        sb.append(" D ");
                    }
                    if(colony.getPosition(i, j).getAnt() instanceof Worker) {
                        sb.append(" W ");
                    }
                    if(colony.getPosition(i, j).getAnt() instanceof Soldier) {
                        sb.append(" S ");
                    }
                    if(colony.getPosition(i, j).getAnt() instanceof Queen) {
                        sb.append(Simulator.RED + " Q " + Simulator.RESET);
                    }
                }
            }
            System.out.println(sb);
        }
    }

}
