/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model.observer;

import mallus.model.Store;


/**
 *
 * @author SWETS_MAIL\lsdrom1
 */
public interface StoreObserver {
    public void storeChanged(Store store);
}
