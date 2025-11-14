package FactoryPattern.SimpleFactory.Entity;

public interface Shape {

    void draw();
}


/*
*
* This is simple factory method, it is highly used but has limitation and breaks few code quality principle like Single Responsibility, and is not extendable,
* because there is only 1 factory for all the entities because of which if any new entity is introduced the factory needs to be changed and multiple if-else conditions
* for each entity. It also becomes bulky if the object creation has a lot of steps making code cluttered.
* */