package org.academiadecodigo.anderdogs.cupcake;

public enum Dough {
    BLANK("blank","src/org/academiadecodigo/anderdogs/assets/doughs/blank.png"),
    VANILLA("vanilla","src/org/academiadecodigo/anderdogs/assets/doughs/vanilla.png"),
    CHOCOLATE("chocolate","src/org/academiadecodigo/anderdogs/assets/doughs/chocolate.png"),
    BLUEBERRY("blueberry","src/org/academiadecodigo/anderdogs/assets/doughs/blueberry.png");

    private String name;
    private String path;

    Dough(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
