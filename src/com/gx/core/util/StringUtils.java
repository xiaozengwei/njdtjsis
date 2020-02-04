package com.gx.core.util;

import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;

public class StringUtils {
	protected StringUtils() {
	}

	public static boolean isEmpty(String text) {
		return org.apache.commons.lang3.StringUtils.isEmpty(text);
	}

	public static boolean isBlank(String text) {
		return org.apache.commons.lang3.StringUtils.isBlank(text);
	}

	public static boolean isNotBlank(String text) {
		return org.apache.commons.lang3.StringUtils.isNotBlank(text);
	}

	public static String capitalize(String text) {
		return org.apache.commons.lang3.StringUtils.capitalize(text);
	}

	public static String substring(String text, int offset, int limit) {
		return org.apache.commons.lang3.StringUtils.substring(text, offset,
				limit);
	}

	public static String substringBefore(String text, String token) {
		return org.apache.commons.lang3.StringUtils
				.substringBefore(text, token);
	}

	public static String substringAfter(String text, String token) {
		return org.apache.commons.lang3.StringUtils.substringAfter(text, token);
	}

	public static String[] splitByWholeSeparator(String text, String separator) {
		return org.apache.commons.lang3.StringUtils.splitByWholeSeparator(text,
				separator);
	}

	public static String join(List list, String separator) {
		return org.apache.commons.lang3.StringUtils.join(list, separator);
	}

	public static String escapeHtml(String text) {
		return StringEscapeUtils.escapeHtml4(text);
	}

	public static String unescapeHtml(String text) {
		return StringEscapeUtils.unescapeHtml4(text);
	}

	public static String escapeXml(String text) {
		return StringEscapeUtils.escapeXml11(text);
	}

	public static String unescapeXml(String text) {
		return StringEscapeUtils.unescapeXml(text);
	}

	public static String trim(String text) {
		if (text == null) {
			return null;
		}

		text = text.replace("" + ((char) 160), " ");

		text = org.apache.commons.lang3.StringUtils.trim(text);
		text = org.apache.commons.lang3.StringUtils.strip(text, "　");

		return text;
	}

	/**
	 * 如果字符串为空或者长度为0，设置默认值为###
	 * 
	 * @param str
	 */
	public static void setDefualtStringIfNull(String str) {
		if (str == null || str.length() < 1) {
			str = "###";
		}
	}

	/**
	 * 校验字符串非空，且长度大于0
	 * 
	 * @param str
	 * @return
	 */
	public static boolean validateString(String str) {
		return (str != null && str.length() > 0);
	}

	/**
	 * 校验string是否为double
	 * 
	 * @param str
	 * @return
	 */
	public static boolean validateDouble(String str) {
		boolean isDouble = false;
		if (!validateString(str)) {// 长度小于0，或者为0，直接返回false
			return isDouble;
		}
		try {

			Double.valueOf(str);
			isDouble = true;
		} catch (NumberFormatException e) {

		}
		return isDouble;
	}

	/**
	 * 校验String是否为double
	 * 
	 * @param str
	 * @return
	 */
	public static boolean validateInteger(String str) {
		boolean isInteger = false;
		if (!validateString(str)) {// 长度小于0，或者为0，直接返回false
			return isInteger;
		}
		try {

			Integer.valueOf(str);
			isInteger = true;
		} catch (NumberFormatException e) {

		}
		return isInteger;
	}

	public static boolean validateLong(Object obj) {
		boolean isLong = false;
		if (obj == null) {
			return isLong;
		}
		String str = obj.toString();
		if (!validateString(str)) {// 长度小于0，或者为0，直接返回false
			return isLong;
		}
		try {

			Long.valueOf(str);
			isLong = true;
		} catch (NumberFormatException e) {

		}
		return isLong;
	}

	public static boolean validateFloat(Object obj) {
		boolean isFloat = false;
		if (obj == null) {
			return isFloat;
		}
		String str = obj.toString();
		if (!validateString(str)) {// 长度小于0，或者为0，直接返回false
			return isFloat;
		}
		try {

			Float.valueOf(str);
			isFloat = true;
		} catch (NumberFormatException e) {

		}
		return isFloat;
	}

	/**
	 * 除去某字符串中的最后一个某符号
	 * 
	 * @param str
	 * @param ch
	 * @return
	 */
	public static String getStringExceptLastChar(String str, String ch) {
		if (validateString(str) && str.endsWith(ch)) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	public static String getString(String str) {
		return validateString(str) ? str : "";
	}

	public static String getString(Object str) {
		return str != null && validateString(str.toString()) ? str.toString()
				: "";
	}
}
