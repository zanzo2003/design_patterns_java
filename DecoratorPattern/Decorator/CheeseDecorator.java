package DecoratorPattern.Decorator;

import DecoratorPattern.Pizza;

public class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription(){
        String updatedDescription = this.decoratedPizza.getDescription() + ", Cheese ";
        return updatedDescription;
    }

    @Override
    public int getPrice(){
        return this.decoratedPizza.getPrice() + 150;
    }
}
