package com.wtw.ownerfactory;

import org.aeonbits.owner.ConfigFactory;

/**
 * @author Amol Wangate
 * @summary This utility class is for accessing configuration properties. The
 *          `PropUtil` class provides a static method to retrieve the
 *          configuration properties defined in the IPropReader interface.
 */
public final class PropUtil {

	private static final IPropReader CONFIG = ConfigFactory.create(IPropReader.class);

	private PropUtil() {
	}

	public static IPropReader getConfig() {
		return CONFIG;
	}
}
