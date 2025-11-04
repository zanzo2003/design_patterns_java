package ObserverPattern.Observable;


import ObserverPattern.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class StockObservableImpl implements Observable<Integer>{

    private List<Observer> observers = new ArrayList<>();
    private int stockPrice;

    @Override
    public void add(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        for(Observer obs: this.observers){
            if( observer.equals(obs)){
                this.observers.remove(obs);
                break;
            }
        }
    }

    @Override
    public void notifySubscibers() {
        for( Observer observer: observers){
            observer.update();
        }
    }

    @Override
    public int getState() {
        return this.stockPrice;
    }

    @Override
    public void setState(Integer newState) {
        this.stockPrice = newState;
        notifySubscibers();
    }
}
