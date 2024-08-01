package com.wtw.customannotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author Amol Wangate
 * @summary: This annotation has methods to be used under @TestAnnontation on
 *           test case level. The values for the same are being read in
 *           TestListeners class
 * 
 */

@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface TestAnnotation {

	String user();

	String module();
}
