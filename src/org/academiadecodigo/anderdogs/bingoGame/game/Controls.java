package org.academiadecodigo.anderdogs.bingoGame.game;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls implements KeyboardHandler {
    private Game game;
    private Keyboard keyboard;
    KeyboardEvent keySpace;

    public Controls(Game game) {
        this.game = game;

        keyboard = new Keyboard(this);

        keySpace = new KeyboardEvent();

        keySpace.setKey(KeyboardEvent.KEY_SPACE);

        keySpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keySpace);
    }


    /**
     * @param keyboardEvent
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE)
        game.setNewRound();
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
