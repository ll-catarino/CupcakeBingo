package org.academiadecodigo.anderdogs.cupcake;

public enum Frosting {
    BLANK("blank","src/org/academiadecodigo/anderdogs/assets/frostings/blank.png"),
    BLUE("blue","src/org/academiadecodigo/anderdogs/assets/frostings/blue.png"),
    GREEN("green","src/org/academiadecodigo/anderdogs/assets/frostings/green.png"),
    PINK("pink","src/org/academiadecodigo/anderdogs/assets/frostings/pink.png");

    private String name;
    private String path;

    Frosting(String name, String path) {
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
