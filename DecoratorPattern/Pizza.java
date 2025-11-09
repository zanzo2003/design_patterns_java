package DecoratorPattern;

import DecoratorPattern.Concrete.FarmhousePizza;
import DecoratorPattern.Decorator.CheeseDecorator;
import DecoratorPattern.Decorator.ChickenDecorator;
import DecoratorPattern.Decorator.PizzaDecorator;

public interface Pizza {

    public String getDescription();

    public int getPrice();
}

/*
 MAIN class example
Pizza pizza1 = new FarmhousePizza();
PizzaDecorator customizedPizza = new ChickenDecorator(new CheeseDecorator(pizza1));
PizzaDecorator newCustomizedPizza = new CheeseDecorator(pizza1);
System.out.println(customizedPizza.getDescription() + " and Price is " + customizedPizza.getPrice() + " only!!");
System.out.println(newCustomizedPizza.getDescription() + " and Price is " + newCustomizedPizza.getPrice() + " only!!");
 */