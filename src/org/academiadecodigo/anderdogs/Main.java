package org.academiadecodigo.anderdogs;

import org.academiadecodigo.anderdogs.bingoCards.Card;
import org.academiadecodigo.anderdogs.bingoGame.game.GameServer;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        if (args.length != 0) {
            if (args[0].equals("card")) {
                card();
            }
        }
        else {
            game();
        }

    }

    private static void game() throws InterruptedException {
        GameServer game = new GameServer();
        game.start();
    }

    private static void card() {
        Card card = new Card();
        card.createCard();
    }
}
