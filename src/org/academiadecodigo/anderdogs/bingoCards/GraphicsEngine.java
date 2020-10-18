package org.academiadecodigo.anderdogs.bingoCards;

import org.academiadecodigo.anderdogs.cupcake.Cupcake;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GraphicsEngine {
    private static final String GRID = "rc/org/academiadecodigo/anderdogs/assets";



    public void newCard() {
        Picture bg = new Picture(10, 10, GRID);
        bg.draw();

    }

    public void cupcake (Cupcake cupcake, int x, int y) {
        drawCupcake(x, y, cupcake);
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

    }



    private void drawX();


}

private
