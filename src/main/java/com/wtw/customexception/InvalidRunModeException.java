package com.wtw.customexception;

/**
 * @author Amol Wangate
 * @summary: This class provides custom exception implementation that will be
 *           thrown in case provided mode value in envconfig.properties file is
 *           not valid
 */
public class InvalidRunModeException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4258854511337185991L;

	public InvalidRunModeException(String message) {
		super(message);
	}

	public InvalidRunModeException(String message, Throwable cause) {
		super(message, cause);
	}
}
