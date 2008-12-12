/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model;

/**
 *
 * @author andrei.nistor
 */
public class ShoeStoreCreator extends StoreCreator {

    @Override
    public Store createStore() {
        return new ShoeStore();
    }

}
