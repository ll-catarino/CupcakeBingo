package org.academiadecodigo.anderdogs.cupcake;

public enum Wrapper {
    BLANK("blank","src/org/academiadecodigo/anderdogs/assets/wrappers/blank.png"),
    GREEN("green","src/org/academiadecodigo/anderdogs/assets/wrappers/green.png"),
    BLUE("blue","src/org/academiadecodigo/anderdogs/assets/wrappers/blue.png"),
    PINK("pink","src/org/academiadecodigo/anderdogs/assets/wrappers/pink.png");

    private String name;
    private String path;

    Wrapper(String name, String path) {
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
