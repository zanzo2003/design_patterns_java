package ObserverPattern.Observable;

import ObserverPattern.Observer.Observer;

public interface Observable <T>{

    public void add(Observer observer);

    public void remove(Observer observer);

    public void notifySubscibers();

    public int getState();

    public void setState(T newState);

}
