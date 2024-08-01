package com.wtw.customexception;

/**
 * @author Amol Wangate
 * @summary: This class provides custom exception implementation to throw in
 *           case of any exception occurred during driver initialization
 * 
 */

public class DriverInitalizationException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9094584474865712490L;

	public DriverInitalizationException(String message) {
		super(message);
	}

	public DriverInitalizationException(String message, Throwable cause) {
		super(message, cause);
	}
}
