package com.wtw.customexception;

/**
 * @author Amol Wangate
 * @summary: This class provides custom exception implementation to throw in
 *           case file is not found
 * 
 */
public class FNFException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2831350880627314607L;

	public FNFException(String message) {
		super(message);
	}

	public FNFException(String message, Throwable cause) {
		super(message, cause);
	}

}
