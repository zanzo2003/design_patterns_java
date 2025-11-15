package FactoryPattern.FactoryMethod.Factory;


import FactoryPattern.FactoryMethod.Entity.Shape;
import FactoryPattern.FactoryMethod.Entity.SquareShape;

public class SquareShapeFactory implements ShapeFactory{

    @Override
    public Shape giveShape() {
        return new SquareShape();
    }
}
