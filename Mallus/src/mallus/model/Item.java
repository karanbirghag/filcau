/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model;

/**
 *
 * @author andrei.nistor
 */
public class Item {

    private String name;
    private String id;
    private String storeId;
    private Double price;

    public Item(String name, String id, String storeId) {
        this.name = name;
        this.id = id;
        this.storeId = storeId;
    }

    public Item(String name, String id, String storeId, Double price) {
        this(name, id, storeId);
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
    
    public String toString() {
        return price + "$ " + name;
    }
}
