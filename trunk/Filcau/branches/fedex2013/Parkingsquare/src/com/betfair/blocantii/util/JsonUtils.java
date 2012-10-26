package com.betfair.blocantii.util;

import java.util.HashMap;
import java.util.Map;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public final class JsonUtils {

	public static String errorToJson(String value) {
		return "{ \"error\": " + "\"" + value + "\"" + "}";
	}

	public static String statsToJson(int freeSpots, int occupiedSpots,
			int blockedSpots, int blockingSpots) throws JSONException {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put(Constants.STATS_FREE_SPOTS, freeSpots);
		map.put(Constants.STATS_OCCUPIED_SPOTS, occupiedSpots);
		map.put(Constants.STATS_BLOCKED_SPOTS, blockedSpots);
		map.put(Constants.STATS_BLOCKING_SPOTS, blockingSpots);

		JSONObject jsonStats = new JSONObject(map);
		
		return jsonStats.toString();


	}

	public static void main(String[] args) throws JSONException {
		statsToJson(11,43,43,3);
	}

}
