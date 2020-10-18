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
            ge.cupcake(cupcakes[0],10,180);
            ge.cupcake(cupcakes[1],170,180);
            ge.cupcake(cupcakes[2],360,180);
            ge.cupcake(cupcakes[3],10,360);
            ge.cupcake(cupcakes[4],170,360);
            ge.cupcake(cupcakes[5],360,360);
            ge.cupcake(cupcakes[6],10,540);
            ge.cupcake(cupcakes[7],170,540);
            ge.cupcake(cupcakes[8],360,540);
    }

    public void drawX (int position){
        ge.drawX(position);
        bingo++;
        if (bingo == 9){
            ge.drawBingo();
            System.out.println("Bingo");
        }
    }

}
