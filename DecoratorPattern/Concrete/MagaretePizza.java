package DecoratorPattern.Concrete;

import DecoratorPattern.Pizza;

public class MagaretePizza implements Pizza {

    private int price = 150;


    @Override
    public String getDescription() {
        return "This is a Margarete Pizza";
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
