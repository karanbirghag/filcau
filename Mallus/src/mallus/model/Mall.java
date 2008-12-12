/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mihai.enea
 */
public class Mall {

   static Mall mallInstance;
   public String name;
   public List <Store> stores;
   public List <Customer> customers;

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

   public void Enter() {

        

   }

   public void Exit() {

   
   }

   public ShoppingCart getShoppingCart() {
        ShoppingCart sc = new ShoppingCart();


   return sc;
   }

   public List Customers() {
        List<Customer> customers = new ArrayList();

        return customers;
   }

      public List Stores() {
        List<Store> stores = new ArrayList();

        return stores;
   }
      public boolean addStore(Store store) {
            boolean hasBeenAdded = false;

            return hasBeenAdded;
      }

}
