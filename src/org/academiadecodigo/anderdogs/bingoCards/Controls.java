package org.academiadecodigo.anderdogs.bingoCards;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls implements KeyboardHandler {

    private Keyboard keyboard;
    private Card card;


    public Controls(Card card){
        this.card = card;
    }

    public void init(){

        keyboard = new Keyboard(this);

        KeyboardEvent key1 = new KeyboardEvent();
        KeyboardEvent key2 = new KeyboardEvent();
        KeyboardEvent key3 = new KeyboardEvent();
        KeyboardEvent key4 = new KeyboardEvent();
        KeyboardEvent key5 = new KeyboardEvent();
        KeyboardEvent key6 = new KeyboardEvent();
        KeyboardEvent key7 = new KeyboardEvent();
        KeyboardEvent key8 = new KeyboardEvent();
        KeyboardEvent key9 = new KeyboardEvent();

        key1.setKey(KeyboardEvent.KEY_1);
        key2.setKey(KeyboardEvent.KEY_2);
        key3.setKey(KeyboardEvent.KEY_3);
        key4.setKey(KeyboardEvent.KEY_4);
        key5.setKey(KeyboardEvent.KEY_5);
        key6.setKey(KeyboardEvent.KEY_6);
        key7.setKey(KeyboardEvent.KEY_7);
        key8.setKey(KeyboardEvent.KEY_8);
        key9.setKey(KeyboardEvent.KEY_9);

        key1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key3.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key4.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key5.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key6.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key7.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key8.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key9.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(key1);
        keyboard.addEventListener(key2);
        keyboard.addEventListener(key3);
        keyboard.addEventListener(key4);
        keyboard.addEventListener(key5);
        keyboard.addEventListener(key6);
        keyboard.addEventListener(key7);
        keyboard.addEventListener(key8);
        keyboard.addEventListener(key9);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey()==KeyboardEvent.KEY_1)
            System.out.println("");
        card.drawX(keyboardEvent.getKey()-48);
        System.out.println("");
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
