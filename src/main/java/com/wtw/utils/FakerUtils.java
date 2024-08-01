package com.wtw.utils;

import com.github.javafaker.Faker;

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
