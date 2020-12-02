package org.academiadecodigo.anderdogs.bingoCards;

import org.academiadecodigo.anderdogs.cupcake.Cupcake;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GraphicsEngine {
    private static final String CARD = "src/org/academiadecodigo/anderdogs/assets/ui/bingo_card.png";
    private static final String CROSS = "src/org/academiadecodigo/anderdogs/assets/ui/crossi.png";
    private static final String BINGO = "src/org/academiadecodigo/anderdogs/assets/ui/bingo_stamp.png";
    private final Picture[] pics = new Picture[9];
    private final int padding = 10;
    private final int offset = 1080;
    private int counter = 0;



    public void newCard() {
        Picture bg = new Picture(padding+offset, padding, CARD);
        bg.draw();
    }

    public void cupcake (Cupcake cupcake, int x, int y) {
        drawCupcake(x+offset, y, cupcake);
    }

    private void drawCupcake(int x, int y, Cupcake c) {
        Picture dough = new Picture(x, y, c.getDough().getPath());

        dough.draw();
        Picture wrapper = new Picture(x, y, c.getWrapper().getPath());

        wrapper.draw();
        Picture frosting = new Picture(x, y, c.getFrosting().getPath());

        frosting.draw();
        Picture topping = new Picture(x, y, c.getTopping().getPath());

        topping.draw();

        pics[counter]= topping;

        counter++;
    }


    public void drawX(int position){
        Picture crossX = new Picture(pics[position-1].getX(),pics[position-1].getY(),CROSS);
        crossX.draw();
    }

    public void drawBingo(){

        Picture bingo = new Picture(padding+offset,padding,BINGO);
        bingo.draw();
    }

}


