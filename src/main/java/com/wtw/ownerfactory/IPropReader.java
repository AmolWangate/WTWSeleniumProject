package com.wtw.ownerfactory;

import org.aeonbits.owner.Config;

/**
 * @author Amol Wangate
 * @Summart This Configuration interface is for reading property values from
 *          configuration files. This interface uses the Owners library to load
 *          and merge property values from multiple configuration files.
 */

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(value = { "file:${user.dir}/src/test/resources/envconfig.properties",
		"file:${user.dir}/src/test/resources/logindata.properties",
		"file:${user.dir}/src/test/resources/remotecaps.properties" })
public interface IPropReader extends Config {

	String browser();

	String mode();

	String url();

	int retrycount();

	boolean openreport();

	boolean passscreenshot();

	boolean failscreenshot();

	boolean skipscreenshot();

	boolean infoscreenshot();

	boolean overridereport();

	String validusername();

	String lockedusername();

	String errorusername();

	String performanceglitchuser();

	String userpassword();

	String browserName();

	String os();

	String userName();

	String accessKey();

	String osVersion();

	String browserVersion();

	String consoleLogs();

	String seleniumVersion();

	String remoteurl();

}
