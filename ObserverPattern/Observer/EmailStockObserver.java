package ObserverPattern.Observer;

import ObserverPattern.Observable.Observable;

public class EmailStockObserver implements Observer{

    private Observable observable;

    public EmailStockObserver( Observable observable){
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("The stock price has changed : " + observable.getState());
    }
}
