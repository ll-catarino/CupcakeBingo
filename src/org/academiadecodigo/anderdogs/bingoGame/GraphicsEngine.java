package org.academiadecodigo.anderdogs.bingoGame;

import org.academiadecodigo.anderdogs.bingoGame.game.Quotes;
import org.academiadecodigo.anderdogs.cupcake.*;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GraphicsEngine {
    private static final String BACKGROUND_PATH = "src/org/academiadecodigo/anderdogs/assets/ui/background.png";
    private static final String BUBBLE_PATH = "src/org/academiadecodigo/anderdogs/assets/ui/bubble.png";


    Picture dough = new Picture(0, 0, Dough.BLANK.getPath());
    Picture wrapper = new Picture(0, 0, Wrapper.BLANK.getPath());
    Picture frosting = new Picture(0, 0, Frosting.BLANK.getPath());
    Picture topping = new Picture(0, 0, Topping.BLANK.getPath());
//very dirty i know. too little time, energy and motivation for this crap thank you.
    Picture dough2 = new Picture(266, 520, Dough.BLANK.getPath());
    Picture wrapper2 = new Picture(70, 510, Wrapper.BLANK.getPath());
    Picture frosting2 = new Picture(462, 555, Frosting.BLANK.getPath());
    Picture topping2 = new Picture(650, 555, Topping.BLANK.getPath());

    Text caetanoText = new Text(780, 130, "");

    Text wrapperText = new Text(780, 200, "");
    Text doughText = new Text(780, 210, "");
    Text frostingText = new Text(780, 220, "");
    Text toppingText = new Text(780, 230, "");


    public void initGameScreen() {
        Picture bg = new Picture(10, 10, BACKGROUND_PATH);
        bg.draw();
        Picture bubble = new Picture(750, 100, BUBBLE_PATH);
        bubble.draw();
    }

    public void newRound(Cupcake cupcake) throws InterruptedException {
        deleteCupcake2();
        speak();
        for (int i = 0; i < 10; i++) {
            drawCupcake(70, 510, new Cupcake(Wrapper.values()[(int) (Math.random() * (Wrapper.values().length)-1)+1], Dough.BLANK, Frosting.BLANK, Topping.BLANK));
            Thread.sleep(100);
        }
        drawCupcake2(70, 510, new Cupcake(cupcake.getWrapper(), Dough.BLANK, Frosting.BLANK, Topping.BLANK));
        for (int i = 0; i < 10; i++) {
            drawCupcake(266, 520, new Cupcake(Wrapper.BLANK, Dough.values()[(int) (Math.random() * (Dough.values().length)-1)+1], Frosting.BLANK, Topping.BLANK));
            Thread.sleep(100);
        }
        drawCupcake2(266, 520, new Cupcake(cupcake.getWrapper(), cupcake.getDough(), Frosting.BLANK, Topping.BLANK));
        for (int i = 0; i < 10; i++) {
            drawCupcake(462, 555, new Cupcake(Wrapper.BLANK, Dough.BLANK, Frosting.values()[(int) (Math.random() * (Frosting.values().length)-1)+1], Topping.BLANK));
            Thread.sleep(100);
        }
        drawCupcake2(462, 555, new Cupcake(cupcake.getWrapper(), cupcake.getDough(), cupcake.getFrosting(), Topping.BLANK));
        for (int i = 0; i < 10; i++) {
            drawCupcake(650, 555, new Cupcake(Wrapper.BLANK, Dough.BLANK, Frosting.BLANK, Topping.values()[(int) (Math.random() * (Frosting.values().length)-1)+1]));
            Thread.sleep(100);
        }
        drawCupcake2(650, 555, new Cupcake(cupcake.getWrapper(), cupcake.getDough(), cupcake.getFrosting(), cupcake.getTopping()));

        drawCupcake(940, 386, cupcake);
        speakResult(cupcake.getWrapper().getName(), cupcake.getDough().getName(), cupcake.getFrosting().getName(), cupcake.getTopping().getName());
    }

    private void drawCupcake(int x, int y, Cupcake c) {


        dough.translate(x-dough.getX(), y-dough.getY());
        //dough.grow(50 , 50);
        dough.load(c.getDough().getPath());
        dough.draw();


        wrapper.translate(x-wrapper.getX(), y-wrapper.getY());
        //dough.grow(50 , 50);
        wrapper.load(c.getWrapper().getPath());
        wrapper.draw();


        frosting.translate(x-frosting.getX(), y-frosting.getY());
        //dough.grow(50 , 50);
        frosting.load(c.getFrosting().getPath());
        frosting.draw();


        topping.translate(x-topping.getX(), y-topping.getY());
        //dough.grow(50 , 50);
        topping.load(c.getTopping().getPath());
        topping.draw();
    }

    private void drawCupcake2(int x, int y, Cupcake c) {


        //dough.grow(50 , 50);
        dough2.load(c.getDough().getPath());
        dough2.draw();



        //dough.grow(50 , 50);
        wrapper2.load(c.getWrapper().getPath());
        wrapper2.draw();



        //dough.grow(50 , 50);
        frosting2.load(c.getFrosting().getPath());
        frosting2.draw();



        //dough.grow(50 , 50);
        topping2.load(c.getTopping().getPath());
        topping2.draw();
    }

    private void deleteCupcake() {
        dough.delete();
        wrapper.delete();
        frosting.delete();
        topping.delete();
    }

    private void deleteCupcake2() {
        dough2.delete();
        wrapper2.delete();
        frosting2.delete();
        topping2.delete();
    }

    private void speak() {
        caetanoText.delete();

        wrapperText.delete();
        doughText.delete();
        frostingText.delete();
        toppingText.delete();

        caetanoText = new Text(770, 140, Quotes.values()[(int) (Math.random() * Quotes.values().length)].toString());
        caetanoText.draw();
    }
    private void speakResult(String wrapper, String dough, String frosting, String topping) {
        caetanoText.delete();

        wrapperText.delete();
        doughText.delete();
        frostingText.delete();
        toppingText.delete();


        wrapperText = new Text(800, 140, "Wrapper: "+wrapper);
        wrapperText.draw();
        doughText = new Text(800, 150, "Dough: "+dough);
        doughText.draw();
        frostingText = new Text(800, 160, "Frosting: "+frosting);
        frostingText.draw();
        toppingText = new Text(800, 170, "Topping: "+topping);
        toppingText.draw();
    }
}
