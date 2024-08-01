package com.wtw.retryanalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * @author Amol Wangate
 * @summary The AnnotationTransformer class implements IAnnotationTransformer to
 *          customize the behavior of TestNG annotations at runtime. This
 *          implementation sets a retry analyzer for all test methods, allowing
 *          tests to be retried in case of failure
 */
public class AnnotationTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
