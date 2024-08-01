package com.wtw.utils;

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
