/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus;

import javax.swing.DefaultListModel;
import mallus.model.Item;
import mallus.model.Store;
import mallus.model.iterator.Enumeration;
import mallus.model.iterator.Iterator;
import mallus.model.observer.StoreObserver;

/**
 *
 * @author SWETS_MAIL\lsdrom1
 */
public class StoreItemsObserver implements StoreObserver {
    private MallusView mallusView;

    StoreItemsObserver(MallusView mallusView) {
        this.mallusView = mallusView;
    }

    public void storeChanged(Store store) {
        DefaultListModel dflm = new DefaultListModel();
        Enumeration<Item> items = store.getItems();
        for (Iterator<Item> it = items.getIterator(); it.hasNext();) {
            Item item = it.next();
            dflm.add(dflm.getSize(), item);
        }
        mallusView.getItems().setModel(dflm);
        
    }
}
