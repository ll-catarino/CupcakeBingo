package org.academiadecodigo.anderdogs.bingoCards;

import org.academiadecodigo.anderdogs.bingoCards.GraphicsEngine;
import org.academiadecodigo.anderdogs.cupcake.Cupcake;

public class Card {

    private final int GRID_SIZE = 9;

    private Cupcake[] cupcakes;
    private GraphicsEngine ge;
    private Controls controls;
    private int bingo;



    public Card() {
        cupcakes = new Cupcake[GRID_SIZE];
        ge = new GraphicsEngine();

        for (int i = 0; i < GRID_SIZE; i++) {
            cupcakes[i]  = newCupcake();
        }

        controls = new Controls(this);
        ge.newCard();
        controls.init();
    }


    public Cupcake newCupcake(){
        Cupcake temp = new Cupcake();
        for(Cupcake cupcake : cupcakes){
            if(temp.equals(cupcake)){
                return newCupcake();
            }
        }
        return temp;
    }


    public void createCard(){
            ge.cupcake(cupcakes[0],50,240);
            ge.cupcake(cupcakes[1],230,240);
            ge.cupcake(cupcakes[2],410,240);
            ge.cupcake(cupcakes[3],50,420);
            ge.cupcake(cupcakes[4],230,420);
            ge.cupcake(cupcakes[5],410,420);
            ge.cupcake(cupcakes[6],50,600);
            ge.cupcake(cupcakes[7],230,600);
            ge.cupcake(cupcakes[8],410,600);
    }

    public void drawX (int position){
        ge.drawX(position);
        bingo++;
        if (bingo == 9){
            ge.drawBingo();
        }
    }

}
