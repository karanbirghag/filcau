/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model;

import mallus.model.iterator.ItemsEnumeration;
import mallus.model.iterator.Enumeration;

/**
 *
 * @author andrei.nistor
 */
public class ShoeStoreCreator extends StoreCreator {
    
    private static final String SHOP_NAME = "Shoe Store";

    @Override
    public Store createStore() {

        ShoeStore s = new ShoeStore(ShoeStoreCreator.SHOP_NAME);
        s.setItems(this.getItemsForStore());
        return s;
    }

    /**
     * Return items for the store.
     * @return
     */
    private Enumeration<Item> getItemsForStore() {
        Enumeration<Item> items = new ItemsEnumeration<Item>();
        Item i1 = new Item("Parada", "Item1_ShoeStore", ShoeStoreCreator.SHOP_NAME, new Double(2.0));
        Item i2 = new Item("Buma", "Item2_ShoeStore", ShoeStoreCreator.SHOP_NAME, new Double(2.3));
        Item i3 = new Item("Reeboc", "Item3_ShoeStore", ShoeStoreCreator.SHOP_NAME, new Double(1.1));
        Item i4 = new Item("Adibas", "Item4_ShoeStore", ShoeStoreCreator.SHOP_NAME, new Double(19.2));
        Item i5 = new Item("Mike", "Item5_ShoeStore", ShoeStoreCreator.SHOP_NAME, new Double(5.5));
        items.add(i1);
        items.add(i2);
        items.add(i3);
        items.add(i4);
        items.add(i5);

        return items;
    }
}
