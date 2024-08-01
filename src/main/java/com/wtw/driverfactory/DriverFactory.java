package com.wtw.driverfactory;

import java.time.Duration;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wtw.constants.FrameworkConstants;
import com.wtw.customexception.InvalidRunModeException;
import com.wtw.enums.BrowserType;
import com.wtw.enums.RunMode;
import com.wtw.ownerfactory.PropUtil;

/**
 * @author Amol Wangate
 * @summary: This class provides factory implementation for different run modes
 *           (e.g local or remote i.e. browserstack and deals with quitting
 *           driver mechanism
 */

public final class DriverFactory {

	private static final Logger LOG = LogManager.getLogger();

	private DriverFactory() {

	}

	public static void initDriver(BrowserType browserType, RunMode runMode) {
		if (Objects.isNull(DriverManager.getDriver())) {
			switch (runMode) {
			case LOCAL:
				LOG.info("launching local driver");
				DriverManager.setDriver(new LocalDriver().getDriverInstance(browserType));
				break;
			case BROWSERSTACK:
				LOG.info("launching remote browserstack driver");
				DriverManager.setDriver(new BrowserStackDriver().getDriverInstance(browserType));
				break;
			default:
				throw new InvalidRunModeException(String.format("Provided run mode % is invalid", runMode));
			}

			LOG.info("deleting all cookies");
			DriverManager.getDriver().manage().deleteAllCookies();
			LOG.info("maximizing browser");
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts()
					.pageLoadTimeout(Duration.ofSeconds(FrameworkConstants.getPageTimeoutWait()));
			LOG.info("launching url");
			DriverManager.getDriver().get(PropUtil.getConfig().url());
		}
	}

	public static void quit() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			LOG.info("quitting browser");
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
