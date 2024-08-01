package com.wtw.customexception;

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
