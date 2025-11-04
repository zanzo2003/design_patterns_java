package StrategyPattern;

public class HeavyLoadDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("<<---- Driving for carrying Heavy Loads ---->>");
    }
}
