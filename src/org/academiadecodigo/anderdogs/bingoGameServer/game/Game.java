package org.academiadecodigo.anderdogs.bingoGame.game;

import org.academiadecodigo.anderdogs.bingoGame.GraphicsEngine;
import org.academiadecodigo.anderdogs.cupcake.Cupcake;

public class Game {
    private GraphicsEngine ge;
    private boolean newRound;
    private boolean gameOver;
    private Cupcake[] cupcakes;
    private int counter;


    public Game() {
        ge = new GraphicsEngine();
        ge.initGameScreen();
        Controls controls = new Controls(this);
        newRound = false;
        gameOver = false;
        cupcakes = new Cupcake[81];
        counter = 0;
    }

    public void start() throws InterruptedException {
        while (!gameOver) {
            System.out.print("");
            if (newRound) {
                newRound();
                newRound = false;
            }
        }
    }

    private void newRound() throws InterruptedException {
        Cupcake cupcake = newCupcake();
        cupcakes[counter] = cupcake;
        counter++;
        System.out.print(cupcake);
        ge.newRound(cupcake);
    }

    private Cupcake newCupcake(){
        Cupcake temp = new Cupcake();
        for(Cupcake cupcake : cupcakes){
            if(temp.equals(cupcake)){
                return newCupcake();
            }
        }
        return temp;
    }

    public void setNewRound() {
        newRound = true;
    }
}
