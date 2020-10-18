package org.academiadecodigo.anderdogs.bingoGame.game;

public enum Quotes {
    HELLO("Saudações"),
    QUOTE0("Never antes, after sempre");

    private String text;

    Quotes(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return text;
    }
}
