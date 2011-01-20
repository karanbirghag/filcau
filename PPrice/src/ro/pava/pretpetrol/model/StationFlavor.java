package ro.pava.pretpetrol.model;

import java.math.BigDecimal;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model
public class StationFlavor {

    @Attribute(primaryKey = true)
    private Key key;

    private String station;

    private String flavor;

    @Attribute(lob = true)
    private BigDecimal flavorPrice;

    private int flavorPriceCount;

    @Attribute(lob = true)
    private BigDecimal stationPricePetrol;

    private int stationPricePetrolCount;

    @Attribute(lob = true)
    private BigDecimal stationPriceDiesel;

    private int stationPriceDieselCount;


    /**
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * @return the station
     */
    public String getStation() {
        return station;
    }

    /**
     * @param station the station to set
     */
    public void setStation(String station) {
        this.station = station;
    }

    /**
     * @return the flavor
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * @param flavor the flavor to set
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * @return the flavorPrice
     */
    public BigDecimal getFlavorPrice() {
        return flavorPrice;
    }

    /**
     * @param flavorPrice the flavorPrice to set
     */
    public void setFlavorPrice(BigDecimal flavorPrice) {
        this.flavorPrice = flavorPrice;
    }

    /**
     * @return the flavorPriceCount
     */
    public int getFlavorPriceCount() {
        return flavorPriceCount;
    }

    /**
     * @param flavorPriceCount the flavorPriceCount to set
     */
    public void setFlavorPriceCount(int flavorPriceCount) {
        this.flavorPriceCount = flavorPriceCount;
    }

    /**
     * @return the stationPricePetrol
     */
    public BigDecimal getStationPricePetrol() {
        return stationPricePetrol;
    }

    public String getPetrolPrice() {
        return stationPricePetrol == null ? "-" : stationPricePetrol.toString();
    }
    public String getDieselPrice() {
        return stationPriceDiesel == null ? "-" : stationPriceDiesel.toString();
    }
    /**
     * @param stationPricePetrol the stationPricePetrol to set
     */
    public void setStationPricePetrol(BigDecimal stationPricePetrol) {
        this.stationPricePetrol = stationPricePetrol;
    }

    /**
     * @return the stationPricePetrolCount
     */
    public int getStationPricePetrolCount() {
        return stationPricePetrolCount;
    }

    /**
     * @param stationPricePetrolCount the stationPricePetrolCount to set
     */
    public void setStationPricePetrolCount(int stationPricePetrolCount) {
        this.stationPricePetrolCount = stationPricePetrolCount;
    }

    /**
     * @return the stationPriceDiesel
     */
    public BigDecimal getStationPriceDiesel() {
        return stationPriceDiesel;
    }

    /**
     * @param stationPriceDiesel the stationPriceDiesel to set
     */
    public void setStationPriceDiesel(BigDecimal stationPriceDiesel) {
        this.stationPriceDiesel = stationPriceDiesel;
    }

    /**
     * @return the stationPriceDieselCount
     */
    public int getStationPriceDieselCount() {
        return stationPriceDieselCount;
    }

    /**
     * @param stationPriceDieselCount the stationPriceDieselCount to set
     */
    public void setStationPriceDieselCount(int stationPriceDieselCount) {
        this.stationPriceDieselCount = stationPriceDieselCount;
    }
}
