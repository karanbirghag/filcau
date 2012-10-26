package com.betfair.blocantii.model;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model
public class Spot {

	public Spot() {
	}
	
	public Spot(int x1, int y1, int x2, int y2) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	@Attribute(primaryKey = true)
	private Key key;

	/**
	 * first point
	 */
	private int x1;
	private int x2;

	/**
	 * second point
	 */
	private int y1;
	private int y2;

	/**
	 * CAR, WALL
	 */
	private String type;

	private boolean blocked;
	private boolean blocking;

	private ModelRef<User> user = new ModelRef<User>(User.class);

	@Override
	public String toString() {
		return "type: " + type + x1 + y1 + x2 + y2;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public boolean isBlocking() {
		return blocking;
	}

	public void setBlocking(boolean blocking) {
		this.blocking = blocking;
	}
	public ModelRef<User> getUser() {
		return user;
	}

}
