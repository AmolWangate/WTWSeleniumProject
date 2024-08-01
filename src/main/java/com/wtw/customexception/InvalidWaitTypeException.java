package com.wtw.customexception;

/**
 * @author Amol Wangate
 * @summary: This class provides custom exception implementation that will be
 *           thrown in case provided wait type for explicit wait is not valid
 */
public class InvalidWaitTypeException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5451337175644384392L;

	public InvalidWaitTypeException(String message) {
		super(message);
	}

	public InvalidWaitTypeException(String message, Throwable cause) {
		super(message, cause);
	}

}
