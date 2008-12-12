/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model;

import java.util.LinkedList;
import java.util.List;
import mallus.model.observer.Observable;
import mallus.model.observer.StoreObserver;

/**
 *
 * @author andrei.nistor
 */
public abstract class Store implements Observable {

    private List<StoreObserver> observers = new LinkedList<StoreObserver>();

    public void addObserver(StoreObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StoreObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (StoreObserver observer : observers) {
            observer.storeChanged(this);
        }
    }

}
