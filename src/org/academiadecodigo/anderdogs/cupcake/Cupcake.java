package org.academiadecodigo.anderdogs.cupcake;

/**
 * Cupcake class
 * @version 1.0
 *
 * @author Lourenço Catarino
 */
public class Cupcake {
    private Wrapper wrapper;
    private Dough dough;
    private Frosting frosting;
    private Topping topping;

    /**
     * This constructor creates a custom cupcake with the given parameters.
     * @param wrapper
     * @param dough
     * @param frosting
     * @param topping
     */
    public Cupcake(Wrapper wrapper, Dough dough, Frosting frosting, Topping topping) {
        this.wrapper = wrapper;
        this.dough = dough;
        this.topping = topping;
        this.frosting = frosting;
    }

    /**
     * This constructor creates a cupcake with random attributes.
     *
     */
    public Cupcake() {
        wrapper = Wrapper.values()[(int) (Math.random() * (Wrapper.values().length)-1)+1];
        dough = Dough.values()[(int) (Math.random() * (Dough.values().length)-1)+1];
        frosting = Frosting.values()[(int) (Math.random() * (Frosting.values().length)-1)+1];
        topping = Topping.values()[(int) (Math.random() * (Topping.values().length)-1)+1];
    }

    public Wrapper getWrapper() {
        return wrapper;
    }

    public Dough getDough() {
        return dough;
    }

    public Frosting getFrosting() {
        return frosting;
    }

    public Topping getTopping() {
        return topping;
    }


    public void setWrapper(Wrapper wrapper) {
        this.wrapper = wrapper;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setFrosting(Frosting frosting) {
        this.frosting = frosting;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cupcake) {
           Cupcake cupcake = (Cupcake) obj;
           return wrapper == cupcake.getWrapper()
                   && dough == cupcake.getDough()
                   && frosting == cupcake.getFrosting()
                   && topping == cupcake.getTopping();
        }
        return false;
    }

    @Override
    public String toString() {
        return "{" +
                "\"wrapper\":\"" + wrapper.getName()+ "\", " +
                "\"dough\":\"" + dough.getName() + "\", " +
                "\"frosting\":\"" + frosting.getName() + "\", " +
                "\"topping\":\"" + topping.getName() +
                "}";
    }
}
