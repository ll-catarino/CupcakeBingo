package org.academiadecodigo.anderdogs.bingoGame.game;

import org.academiadecodigo.anderdogs.bingoGame.GraphicsEngine;
import org.academiadecodigo.anderdogs.bingoGame.Server;
import org.academiadecodigo.anderdogs.cupcake.Cupcake;

import java.io.IOException;

public class GameServer implements Runnable{
    private GraphicsEngine ge;
    private boolean newRound;
    private boolean gameOver;
    private Cupcake[] cupcakes;
    private int counter;
    private Server server;


    public GameServer() {
        ge = new GraphicsEngine();
        ge.initGameScreen();
        Controls controls = new Controls(this);
        server = new Server(25565);
        Thread serverThread = new Thread(server);
        serverThread.start();
        newRound = false;
        gameOver = false;
        cupcakes = new Cupcake[81];
        counter = 0;
    }

    public void start() {
        while (!gameOver) {
            System.out.print("");
            if (newRound) {
                try {
                    newRound();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                newRound = false;
            }
        }
    }

    private void newRound() throws InterruptedException {
        Cupcake cupcake = newCupcake();
        cupcakes[counter] = cupcake;
        counter++;
        System.out.println(cupcake);
        server.sendAll(cupcake.toString());
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

    @Override
    public void run() {
        start();
    }
}
