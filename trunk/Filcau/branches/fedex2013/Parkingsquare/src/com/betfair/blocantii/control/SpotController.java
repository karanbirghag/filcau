package com.betfair.blocantii.control;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;

import com.betfair.blocantii.meta.SpotMeta;
import com.betfair.blocantii.model.Spot;
import com.google.appengine.api.datastore.Key;

public class SpotController {

	private SpotMeta meta = SpotMeta.get();

	public List<Spot> getCarSpots() {
		return Datastore.query(meta).filter(meta.type.equal("CAR")).asList();
	}

	public void initCarSpots() {
		Spot car = new Spot();
		car.setType("CAR");
		Datastore.put(car);
	}

	public void deleteAllCarSpots() {
		List<Spot> carSpots = Datastore.query(Spot.class).asList();
		List<Key> list = new ArrayList<Key>();
		for (Spot spot : carSpots) {
			list.add(spot.getKey());
		}
		Datastore.delete(list);
	}
}
