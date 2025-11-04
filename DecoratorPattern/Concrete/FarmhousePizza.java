package DecoratorPattern.Concrete;

import DecoratorPattern.Pizza;

public class FarmhousePizza implements Pizza {

    private int price = 200;

    @Override
    public String getDescription() {
        return "This is a Farm House Pizza";
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
