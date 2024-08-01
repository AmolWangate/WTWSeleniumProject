package com.wtw.customexception;

/**
 * @author Amol Wangate
 * @summary: This class provides custom exception implementation to throw in
 *           case of any I/O exception
 * 
 */
public class FIFOException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2602403225686177065L;

	public FIFOException(String message) {
		super(message);
	}

	public FIFOException(String message, Throwable cause) {
		super(message, cause);
	}
}
