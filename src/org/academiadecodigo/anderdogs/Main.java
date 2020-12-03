package org.academiadecodigo.anderdogs;

import org.academiadecodigo.anderdogs.bingoCards.Card;
import org.academiadecodigo.anderdogs.bingoGame.game.Game;
import org.academiadecodigo.anderdogs.bingoGame.game.GameServer;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        if (args.length != 0) {
            if (args[0].equals("-host")) {
                host();
            }
        }
        else {
            player();
        }

    }

    private static void player() {
        Game game = new Game();
        Thread gameThread = new Thread(game);

        gameThread.start();

        Card card = new Card();
        card.createCard();
    }

    private static void host() {
        GameServer game = new GameServer();
        Thread gameThread = new Thread(game);
        gameThread.start();

        Scanner in = new Scanner(System.in);
        while (true) {
            if (in.hasNextLine()) {
                game.setNewRound();
            }
        }

    }
}
