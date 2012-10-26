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
		deleteAllUsers();
		User user = new User();
		user.setCarNumber("CJ-10-JSM");
		user.setYahooId("omulplajei");
		user.setUsername("Rusu Rares");
		user.setPhoneNumber("0744-784741");
		Datastore.put(user);

		user.setCarNumber("AB-05-XAB");
		user.setYahooId("dr_hoppa");
		user.setUsername("Popa Horea");
		user.setPhoneNumber("0744-428963");
		Datastore.put(user);

		user.setCarNumber("AB-17-WAR");
		user.setYahooId("tony_muntean");
		user.setUsername("Muntean Ioan Antoniu");
		user.setPhoneNumber("0747-683402");
		Datastore.put(user);
	}

	public void deleteAllUsers() {
		List<User> users = Datastore.query(User.class).asList();
		List<Key> list = new ArrayList<Key>();
		for (User user : users) {
			list.add(user.getKey());
		}
		Datastore.delete(list);
	}

	public User getUserByKey(String userKey) {
		Key key = Datastore.stringToKey(userKey);
		return Datastore.get(User.class, key);
	}

}
