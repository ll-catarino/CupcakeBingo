package org.academiadecodigo.anderdogs.bingoGame.game;

import org.academiadecodigo.anderdogs.bingoGame.GraphicsEngine;
import org.academiadecodigo.anderdogs.cupcake.Cupcake;

public class Game {
    private GraphicsEngine ge;
    private boolean newRound;
    private boolean gameOver;


    public Game() {
        ge = new GraphicsEngine();
        ge.initGameScreen();
        Controls controls = new Controls(this);
        newRound = false;
        gameOver = false;
    }

    public void start() throws InterruptedException {
        while (!gameOver) {
            System.out.println("");
            if (newRound) {
                newRound();
                newRound = false;
            }
        }
    }

    private void newRound() throws InterruptedException {
        Cupcake cupcake = new Cupcake();
        //todo check if new
        System.out.println(cupcake);
        ge.newRound(cupcake);
    }

    public void setNewRound() {
        newRound = true;
    }
}
