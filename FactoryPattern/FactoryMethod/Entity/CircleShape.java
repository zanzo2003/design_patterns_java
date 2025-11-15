package FactoryPattern.FactoryMethod.Entity;

public class CircleShape implements Shape{

    @Override
    public void draw(){
        System.out.println("I am a Circle!!");
    }
}
