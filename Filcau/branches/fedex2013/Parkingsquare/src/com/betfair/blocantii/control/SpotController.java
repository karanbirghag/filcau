package com.betfair.blocantii.control;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;

import com.betfair.blocantii.model.Spot;
import com.google.appengine.api.datastore.Key;

public class SpotController {

	public List<Spot> getCarSpots() {
		return Datastore.query(Spot.class).asList();
	}

	public void initCarSpots() {
		List<Spot> list = new ArrayList<Spot>();
		for (int i = 0; i < 4; i++) {
			Spot spot = new Spot();
			spot.setType("CAR");
			list.add(spot);
		}
		Datastore.put(list);
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
