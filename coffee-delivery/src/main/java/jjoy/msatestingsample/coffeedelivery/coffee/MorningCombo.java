package jjoy.msatestingsample.coffeedelivery.coffee;

public class MorningCombo {

    private Coffee coffee;
    private Bread bread;

    public MorningCombo(Coffee coffee, Bread bread) {
        this.coffee = coffee;
        this.bread = bread;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public Bread getBread() {
        return bread;
    }
}
