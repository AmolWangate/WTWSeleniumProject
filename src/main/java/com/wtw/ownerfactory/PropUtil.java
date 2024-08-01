package com.wtw.ownerfactory;

import org.aeonbits.owner.ConfigFactory;

public final class PropUtil {

	private static final IPropReader CONFIG = ConfigFactory.create(IPropReader.class);

	private PropUtil() {
	}

	public static IPropReader getConfig() {
		return CONFIG;
	}
}
