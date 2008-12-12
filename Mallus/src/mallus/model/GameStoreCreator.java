/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrei.nistor
 */
public class GameStoreCreator extends StoreCreator {

    private static String SHOP_NAME = "Game Store";

    @Override
    public Store createStore() {

        GameStore s = new GameStore(GameStoreCreator.SHOP_NAME);
        s.setItems(this.getItemsForStore());
        return s;
    }

    /**
     * Return items for the store.
     * @return
     */
    private List<Item> getItemsForStore() {
        List<Item> items = new ArrayList<Item>();
        Item i1 = new Item("Item1", "Item1_GameStore", GameStoreCreator.SHOP_NAME, new Double(2.0));
        Item i2 = new Item("Item2", "Item2_GameStore", GameStoreCreator.SHOP_NAME, new Double(2.3));
        Item i3 = new Item("Item3", "Item3_GameStore", GameStoreCreator.SHOP_NAME, new Double(1.1));
        Item i4 = new Item("Item4", "Item4_GameStore", GameStoreCreator.SHOP_NAME, new Double(19.2));
        Item i5 = new Item("Item5", "Item5_GameStore", GameStoreCreator.SHOP_NAME, new Double(5.5));
        items.add(i1);
        items.add(i2);
        items.add(i3);
        items.add(i4);
        items.add(i5);

        return items;
    }

}
