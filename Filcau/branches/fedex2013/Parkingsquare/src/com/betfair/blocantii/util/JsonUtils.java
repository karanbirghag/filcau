package com.betfair.blocantii.util;

public final class JsonUtils {

	public static String errorToJson(String value) {
		return "{ \"error\": " + "\"" + value + "\"" + "}";
	}

}
