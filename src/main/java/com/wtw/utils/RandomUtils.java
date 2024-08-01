package com.wtw.utils;

/**
 * @author Amol Wangate
 * @summary The RandmomUtils class provides static methods for generating
 *          various types of random data, such as names and addresses.
 */
public final class RandomUtils {

	private RandomUtils() {

	}

	public static String getFirstName() {
		return FakerUtils.getFirstName();
	}

	public static String getLastName() {
		return FakerUtils.getLastName();
	}

	public static String getZipCode() {
		return FakerUtils.getZipCode();
	}

}
