package StrategyPattern;

public class SportsDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("<<--- Running in Sports Mode --->>");
        return ;
    }
}
