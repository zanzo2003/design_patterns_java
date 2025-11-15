package FactoryPattern.FactoryMethod.Entity;

public interface Shape {

    void draw();

}


/*
This is the Factory method pattern which solves some of the shortcomings of the Simple Factory Pattern. This allows each concrete entity to have its own
Factory implementation making the code open for extensibility by not depending on a single factory to handle object creation (Single Responsibility Principle).
 This also makes the code readable by eliminating if else blocks
 */