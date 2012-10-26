package com.betfair.blocantii.control;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;

import com.betfair.blocantii.meta.SpotMeta;
import com.betfair.blocantii.model.Spot;
import com.betfair.blocantii.model.User;
import com.google.appengine.api.datastore.Key;

public class SpotController {

	private SpotMeta meta = SpotMeta.get();

	public List<Spot> getCarSpots() {
		return Datastore.query(meta).filter(meta.type.equal("CAR")).asList();
	}

	public List<Spot> getAllSpots() {
		return Datastore.query(meta).asList();
	}

	public void initCarSpots() {
		deleteAllCarSpots();
		Spot car = new Spot(100, 100, 200, 147);
		car.setType("CAR");
		Datastore.put(car);

		car = new Spot(400, 100, 500, 147);
		car.setType("CAR");
		Datastore.put(car);

		car = new Spot(100, 300, 147, 400);
		car.setType("CAR");
		Datastore.put(car);
	}

	public void deleteAllCarSpots() {
		List<Spot> carSpots = getCarSpots();
		List<Key> keyList = new ArrayList<Key>();
		for (Spot spot : carSpots) {
			keyList.add(spot.getKey());
		}
		Datastore.delete(keyList);
	}

	public Spot getFreeSpot(Spot desiredSpot) {
		boolean isFree = true;

		for (Spot spot : getAllSpots()) {
			if (isConflict(spot, desiredSpot)) {
				isFree = false;
			}
		}
		return isFree ? desiredSpot : null;
	}

	public Spot[] getBlockedSpots(Spot desiredSpot) {
		// TODO run it after check-in/out
		return null;
	}

	private boolean isConflict(Spot spot, Spot desiredSpot) {
		boolean isConflict = false;

		boolean overlapsFromUpperLeft = desiredSpot.getX2() >= spot.getX1()
				&& desiredSpot.getX2() <= spot.getX2()
				&& desiredSpot.getY2() >= spot.getY1()
				&& desiredSpot.getY2() <= spot.getY2();
		boolean overlapsFromUpperRight = desiredSpot.getX1() >= spot.getX1()
				&& desiredSpot.getX1() <= spot.getX2()
				&& desiredSpot.getY2() >= spot.getY1()
				&& desiredSpot.getY2() <= spot.getY2();
		boolean overlapsFromLowerRight = desiredSpot.getX1() <= spot.getX2()
				&& desiredSpot.getX1() >= spot.getX1()
				&& desiredSpot.getY1() <= spot.getY2()
				&& desiredSpot.getY1() >= spot.getY1();
		boolean overlapsFromLowerLeft = desiredSpot.getX2() >= spot.getX1()
				&& desiredSpot.getX2() <= spot.getX2()
				&& desiredSpot.getY1() <= spot.getY2()
				&& desiredSpot.getY1() >= spot.getY1();

		if (overlapsFromUpperLeft || overlapsFromUpperRight
				|| overlapsFromLowerLeft || overlapsFromLowerRight) {
			isConflict = true;
		}
		return isConflict;
	}

	public void linkSpotToItsUser(Spot freeSpot, User user) {
		freeSpot.getUser().setModel(user);
		Datastore.put(freeSpot);
	}
}
