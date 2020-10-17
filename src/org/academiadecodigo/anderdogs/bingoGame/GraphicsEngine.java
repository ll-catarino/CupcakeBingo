package org.academiadecodigo.anderdogs.bingoGame;

import org.academiadecodigo.anderdogs.cupcake.Cupcake;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GraphicsEngine {
    private static final String BACKGROUND_PATH = "src/org/academiadecodigo/anderdogs/assets/ui/bakery.jpg";
    private static final String COUNTER_PATH = "src/org/academiadecodigo/anderdogs/assets/ui/counter.png";


    public void initGameScreen() {
        Picture bg = new Picture(10, 10, BACKGROUND_PATH);
        bg.draw();
        Picture counter = new Picture(10, 10 + 720 - 300, COUNTER_PATH);
        counter.draw();
    }

    public void newRound(Cupcake cupcake) {
        drawCupcake(720, 320, cupcake);
    }

    private void drawCupcake(int x, int y, Cupcake c) {
        Picture dough = new Picture(x, y, c.getDough().getPath());
        dough.grow(50 , 50);
        dough.draw();
        Picture wrapper = new Picture(x, y, c.getWrapper().getPath());
        wrapper.grow(50 , 50);
        wrapper.draw();
        Picture frosting = new Picture(x, y, c.getFrosting().getPath());
        frosting.grow(50 , 50);
        frosting.draw();
        Picture topping = new Picture(x, y, c.getTopping().getPath());
        topping.grow(50 , 50);
        topping.draw();

    }
}
