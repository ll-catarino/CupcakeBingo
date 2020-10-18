package org.academiadecodigo.anderdogs.bingoGame.game;

import org.academiadecodigo.anderdogs.bingoGame.GraphicsEngine;
import org.academiadecodigo.anderdogs.cupcake.Cupcake;

public class Game {
    GraphicsEngine ge;

    public Game() {
        ge = new GraphicsEngine();
        ge.initGameScreen();
        Controls controls = new Controls(this);
    }

    public void newRound() {
        Cupcake cupcake = new Cupcake();
        //todo check if new
        System.out.println(cupcake);

    }
}
