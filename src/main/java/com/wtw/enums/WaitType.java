package com.wtw.enums;

/**
 * @author Amol Wangate
 * @Summary This enum defines various wait conditions that are to be used in
 *          WaitUtility to ensure elements are in the expected state before
 *          interacting with them.
 */

public enum WaitType {

	CLICKABLE, 
	VISIBLE, 
	PRESENCE, 
	NONE
}
