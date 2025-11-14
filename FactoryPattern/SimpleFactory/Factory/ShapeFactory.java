package FactoryPattern.SimpleFactory.Factory;

import FactoryPattern.SimpleFactory.Entity.Circle;
import FactoryPattern.SimpleFactory.Entity.Shape;
import FactoryPattern.SimpleFactory.Entity.Square;

public class ShapeFactory {

    public static Shape getShape( ShapeType shapeType){

        if( shapeType.equals(ShapeType.CIRCLE)){
            return new Circle();
        }
        else if( shapeType.equals(ShapeType.SQUARE)){
            return new Square();
        }
        else return null;
    }
}
