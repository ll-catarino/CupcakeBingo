package org.academiadecodigo.anderdogs.cupcake;

public enum Topping {
    BLANK("blank","src/org/academiadecodigo/anderdogs/assets/toppings/blank.png"),
    CHOCOLATE("chocolate","src/org/academiadecodigo/anderdogs/assets/toppings/chocolate.png"),
    RAINBOW("rainbow","src/org/academiadecodigo/anderdogs/assets/toppings/rainbow.png"),
    MNM("m&m","src/org/academiadecodigo/anderdogs/assets/toppings/mnm.png");

    private String name;
    private String path;

    Topping(String name, String path) {
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
