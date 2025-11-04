

import ObserverPattern.Observable.Observable;
import ObserverPattern.Observer.Observer;
import ObserverPattern.Observable.StockObservableImpl;
import ObserverPattern.Observer.EmailStockObserver;


public class Main {

    public static void main(String[] args) {

        // creating observable for Nvidia Stock price
        Observable nvidiaStock = new StockObservableImpl();

        // creating observer for nvidia stocks
        Observer shashwath = new EmailStockObserver(nvidiaStock);
        Observer shreyas = new EmailStockObserver(nvidiaStock);
        Observer bhaskar = new EmailStockObserver(nvidiaStock);


        // adding Observer to the list
        nvidiaStock.add(shashwath);
        nvidiaStock.add(shreyas);
        nvidiaStock.add(bhaskar);

        // changing stock price
        nvidiaStock.setState(12);
        nvidiaStock.setState(234);
        nvidiaStock.setState(0);

        // removing observer
        nvidiaStock.remove(bhaskar);

        // changing stock price
        nvidiaStock.setState(34);
    }

}