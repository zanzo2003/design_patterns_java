import DecoratorPattern.*;
import DecoratorPattern.Concrete.FarmhousePizza;
import DecoratorPattern.Decorator.CheeseDecorator;
import DecoratorPattern.Decorator.ChickenDecorator;
import DecoratorPattern.Decorator.PizzaDecorator;

public class Main {

    public static void main(String[] args) {

        Pizza pizza1 = new FarmhousePizza();
        PizzaDecorator customizedPizza = new ChickenDecorator(new CheeseDecorator(pizza1));
        System.out.println(customizedPizza.getDescription() + " and Price is " + customizedPizza.getPrice() + " only!!");

    }

}