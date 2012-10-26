package com.betfair.blocantii.model;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model
public class Statistics {

	@Attribute(primaryKey = true)
	private Key key;

	private int freeSpots;
	private int occupiedSpots;
	private int blockedSpots;
	private int blockingSpots;

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public int getFreeSpots() {
		return freeSpots;
	}

	public void setFreeSpots(int freeSpots) {
		this.freeSpots = freeSpots;
	}

	public int getOccupiedSpots() {
		return occupiedSpots;
	}

	public void setOccupiedSpots(int occupiedSpots) {
		this.occupiedSpots = occupiedSpots;
	}

	public int getBlockedSpots() {
		return blockedSpots;
	}

	public void setBlockedSpots(int blockedSpots) {
		this.blockedSpots = blockedSpots;
	}

	public int getBlockingSpots() {
		return blockingSpots;
	}

	public void setBlockingSpots(int blockingSpots) {
		this.blockingSpots = blockingSpots;
	}

}
