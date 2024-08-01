package com.wtw.utils;

import com.github.javafaker.Faker;

/**
 * @author Amol Wangate
 * @summary The FakerUtils class provides static methods for generating various
 *          types of random data, such as names and addresses.
 */
public final class FakerUtils {

	private FakerUtils() {

	}

	private static Faker faker = new Faker();

	static String getFirstName() {
		return faker.name().firstName();
	}

	static String getLastName() {
		return faker.name().lastName();
	}

	static String getZipCode() {
		return faker.address().zipCode();
	}
}
