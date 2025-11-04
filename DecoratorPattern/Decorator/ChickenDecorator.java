package DecoratorPattern.Decorator;

import DecoratorPattern.Pizza;

public class ChickenDecorator extends PizzaDecorator {

    public ChickenDecorator( Pizza decoratedPizza){
        super(decoratedPizza);
    }

    @Override
    public String getDescription(){
        return this.decoratedPizza.getDescription() + ", Chicken";
    }

    @Override
    public int getPrice(){
        return this.decoratedPizza.getPrice() + 70;
    }
}
