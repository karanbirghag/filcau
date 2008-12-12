/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model;

import java.util.List;

/**
 *
 * @author mihai.enea
 */
public class Mall {

   static Mall mallInstance;
   public String name;
   public Aggregate <Store> stores;
   public Aggregate <Customer> customers;

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

   
}
