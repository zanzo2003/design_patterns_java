package FactoryPattern.FactoryMethod.Entity;

public class SquareShape implements Shape{
    @Override
    public void draw() {
        System.out.println("I am a Square!!");
    }
}
