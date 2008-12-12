/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mallus.model.observer.Observable;
import mallus.model.observer.StoreObserver;

/**
 *
 * @author andrei.nistor
 */
public abstract class Store implements Observable {

    private String name;

    private List<Item> items = new ArrayList<Item>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StoreObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<StoreObserver> observers) {
        this.observers = observers;
    }

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
