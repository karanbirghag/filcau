/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model.observer;

import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author SWETS_MAIL\lsdrom1
 */
public interface Observable {
    public void addObserver(StoreObserver observer);
    public void removeObserver(StoreObserver observer);
    public void notifyObservers();
}
