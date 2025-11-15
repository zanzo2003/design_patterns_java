package FactoryPattern.FactoryMethod.Factory;

import FactoryPattern.FactoryMethod.Entity.CircleShape;
import FactoryPattern.FactoryMethod.Entity.Shape;

public class CircleShapeFactory implements ShapeFactory{

    @Override
    public Shape giveShape() {
        return new CircleShape();
    }

}
