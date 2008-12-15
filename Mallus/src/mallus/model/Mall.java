/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model;

import mallus.model.iterator.Enumeration;
import mallus.model.iterator.StoresEnumeration;

/**
 *
 * @author mihai.enea
 */
public class Mall {

   static Mall mallInstance;
   public String name;
   private Enumeration<Store> stores = new StoresEnumeration<Store>();
   private Enumeration<Customer> customers;

   private Mall() {
   }

   public static Mall getInstance() {
      if (null == mallInstance) {
         mallInstance = new Mall();
      }
      return mallInstance;
   }

   protected Object clone() throws
    CloneNotSupportedException {
      throw new CloneNotSupportedException();
   }

   public void enter() {

   }

   public void exit() {
   
   }

    public ShoppingCart getShoppingCart() {
        ShoppingCart sc = new ShoppingCart();
        return sc;
    }

    public Enumeration<Customer> customers() {
        return customers;
   }

    public Enumeration<Store> stores() {
        return stores;
   }
    
    
    public Mall addStore(Store store) {
        stores.add(store);
        return this;
    }

}
