package DecoratorPattern.Decorator;

import DecoratorPattern.Pizza;

public abstract class PizzaDecorator implements Pizza {

    protected Pizza decoratedPizza;

    public PizzaDecorator( Pizza pizza){
        this.decoratedPizza = pizza;
    }

    @Override
    public int getPrice() {
        return this.decoratedPizza.getPrice();
    }

    @Override
    public String getDescription(){
        return this.decoratedPizza.getDescription() + " with ";
    }

}
