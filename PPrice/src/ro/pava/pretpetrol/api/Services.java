package ro.pava.pretpetrol.api;

import java.math.BigDecimal;
import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import ro.pava.pretpetrol.meta.PriceMeta;
import ro.pava.pretpetrol.meta.StationFlavorMeta;
import ro.pava.pretpetrol.model.Price;
import ro.pava.pretpetrol.model.StationFlavor;
import ro.pava.pretpetrol.model.Type;

import com.google.appengine.api.datastore.Key;

public class Services {

    public void add(Key stationKey, Price price) {
        GlobalTransaction gbx = Datastore.beginGlobalTransaction();
        StationFlavor station = null;
        if (stationKey != null) {
            station = gbx.get(StationFlavor.class, stationKey);
        }
        if (stationKey == null || station == null) {
            station = createNewStation(gbx, price);
        }
        Key priceKey = Datastore.allocateId(station.getKey(), Price.class);
        price.setKey(priceKey);
        gbx.put(price);
        if (Type.Diesel.equals(price.getType())) {
            BigDecimal recomputedAvg = Util.recomputeAvg(station.getStationPriceDiesel(), station
                    .getStationPriceDieselCount(), price.getValue());

            station.setStationPriceDiesel(recomputedAvg);
        } else if (Type.Petrol.equals(price.getType())) {
            BigDecimal recomputedAvg = Util.recomputeAvg(station.getStationPricePetrol(), station
                    .getStationPricePetrolCount(), price.getValue());

            station.setStationPricePetrol(recomputedAvg);
        }
        gbx.put(station);
        StationFlavorMeta sfMeta = StationFlavorMeta.get();
        List<StationFlavor> flavors = gbx.query(sfMeta, station.getKey())
            .filter(sfMeta.station.equal(price.getStation()))
            .filter(sfMeta.flavor.equal(price.getFlavour()))
            .asList();
        StationFlavor flavor = null;
        if (flavors.size() > 0) {
            flavor = flavors.get(1);
        } else {
            flavor = createFlavor(gbx, price, station.getKey());
        }

        BigDecimal flavorAvg = Util.recomputeAvg(flavor.getFlavorPrice(), flavor.getFlavorPriceCount(), price.getValue());
        flavor.setFlavorPrice(flavorAvg);
        gbx.put(flavor);

        gbx.commit();
    }

    public List<StationFlavor> getAllStations() {
        StationFlavorMeta sfm = StationFlavorMeta.get();
        List<StationFlavor> stations = Datastore.query(StationFlavor.class).filter(sfm.flavor.equal(null)).asList();
        return stations;
    }


    public List<StationFlavor> getStationPrices(String station) {
        StationFlavorMeta sfm = StationFlavorMeta.get();
        return Datastore.query(StationFlavor.class).filter(sfm.station.equal(station)).asList();
    }


    public List<Price> getFlavorPrices(String station, String flavor) {
        PriceMeta pm = PriceMeta.get();
        return Datastore.query(Price.class).filter(pm.station.equal(station)).filter(pm.flavour.equal(flavor)).asList();
    }

    private StationFlavor createFlavor(GlobalTransaction gbx, Price price, Key key) {
        StationFlavor f = new StationFlavor();
        f.setKey(Datastore.allocateId(key, StationFlavor.class));
        f.setStation(price.getStation());
        f.setFlavor(price.getFlavour());
        f.setFlavorPrice(price.getValue());
        f.setFlavorPriceCount(1);
        gbx.put(f);
        return f;
    }

    private StationFlavor createNewStation(GlobalTransaction gbx, Price price) {
        StationFlavor sf = new StationFlavor();
        sf.setKey(Datastore.allocateId(StationFlavor.class));
        sf.setStation(price.getStation());
        if (Type.Diesel.equals(price.getType())) {
            sf.setStationPriceDiesel(price.getValue());
            sf.setStationPriceDieselCount(1);
        } else if (Type.Petrol.equals(price.getType())) {
            sf.setStationPricePetrol(price.getValue());
            sf.setStationPricePetrolCount(1);
        }
        gbx.put(sf);
        return sf;
    }
}