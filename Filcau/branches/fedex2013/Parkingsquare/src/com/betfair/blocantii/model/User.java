package com.betfair.blocantii.model;

import com.google.appengine.api.datastore.Key;

public class User {

	// @Attribute(primaryKey = true)
	private Key key;

	private String username;
	private String yahooId;
	private String phoneNumber;
	private String carNumber;

	public User(String username, String yahooId, String phoneNumber,
			String carNumber) {
		super();
		this.username = username;
		this.yahooId = yahooId;
		this.phoneNumber = phoneNumber;
		this.carNumber = carNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getYahooId() {
		return yahooId;
	}

	public void setYahooId(String yahooId) {
		this.yahooId = yahooId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

}
