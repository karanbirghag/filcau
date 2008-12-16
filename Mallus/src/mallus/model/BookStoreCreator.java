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
public class BookStoreCreator extends StoreCreator {

    private static final String SHOP_NAME = "Book Store";

    @Override
    public Store createStore() {

        BookStore s = new BookStore(BookStoreCreator.SHOP_NAME);
        s.setItems(this.getItemsForStore());
        return s;
    }

    /**
     * Return items for the store.
     * @return
     */
    private Enumeration<Item> getItemsForStore() {
        Enumeration<Item> items = new ItemsEnumeration<Item>();
        Item i1 = new Item("Memories from the childhood", "Item1_BookStore", BookStoreCreator.SHOP_NAME, new Double(2.0));
        Item i2 = new Item("The bag with two coins", "Item2_BookStore", BookStoreCreator.SHOP_NAME, new Double(2.3));
        Item i3 = new Item("The goat with the three kids", "Item3_BookStore", BookStoreCreator.SHOP_NAME, new Double(1.1));
        Item i4 = new Item("The bear tricked by the fox", "Item4_BookStore", BookStoreCreator.SHOP_NAME, new Double(19.2));
        Item i5 = new Item("The story of a lazy man", "Item5_BookStore", BookStoreCreator.SHOP_NAME, new Double(5.5));
        items.add(i1);
        items.add(i2);
        items.add(i3);
        items.add(i4);
        items.add(i5);

        return items;
    }

}
