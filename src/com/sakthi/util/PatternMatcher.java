/**
 * 
 */
package com.sakthi.util;

import java.util.regex.Pattern;

/**
 * @author sakthivel
 *
 */
public class PatternMatcher {

	private static final String UNITS_PATTERN = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("test");

		String units = "day,hour,second,minute";
		Pattern unitPattern = Pattern.compile(UNITS_PATTERN);

		unitPattern.matcher(units);
	}

}
