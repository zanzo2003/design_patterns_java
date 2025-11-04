package StrategyPattern;

public class Vehical {

    private DriveStrategy strategy;

    public Vehical(DriveStrategy strategy){
        this.strategy = strategy;
    }

    public void drive(){
        System.out.println("<<----- Drive Strategy------>");
        strategy.drive();
        return ;
    }
}
