package com.betfair.blocantii.control;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;

import com.betfair.blocantii.meta.UserMeta;
import com.betfair.blocantii.model.User;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery.TooManyResultsException;
import com.google.appengine.api.memcache.InvalidValueException;

public class UserController {

	UserMeta meta = UserMeta.get();

	public List<User> getUsers() {
		return Datastore.query(User.class).asList();
	}

	public User getUserByCarNumber(String carNumber) {
		User user = null;
		try {
			user = Datastore.query(meta)
					.filter(meta.carNumber.equal(carNumber)).asSingle();
		} catch (TooManyResultsException e) {
			// should not happen
			throw new InvalidValueException(
					"to many results for the same car number", e);
		}
		return user;
	}

	public void initUsers() {
		User user = new User();
		user.setCarNumber("AAA");
		user.setUsername("Grozav");
		Datastore.put(user);
	}

	public void deleteAllUsers() {
		List<User> users = Datastore.query(User.class).asList();
		List<Key> list = new ArrayList<Key>();
		for (User spot : users) {
			list.add(spot.getKey());
		}
		Datastore.delete(list);
	}

	public User getUserByKey(String userKey) {
		Key key = Datastore.stringToKey(userKey);
		return Datastore.get(User.class, key);
	}

}
