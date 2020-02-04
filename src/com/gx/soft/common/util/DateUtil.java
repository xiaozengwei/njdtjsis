package com.gx.soft.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final long SENCODS_IN_FIVE_DAYS = 1000 * 24 * 60 * 60 * 5;// 5天换算成毫秒数

	/**
	 * 功能或作用：格式化日期时间
	 * 
	 * @param DateValue
	 *            输入日期或时间
	 * @param DateType
	 *            格式化 EEEE是星期, yyyy是年, MM是月, dd是日, HH是小时, mm是分钟, ss是秒
	 * @return 输出字符串
	 */
	public static String formatDate(String DateValue, String DateType) {
		String result;
		SimpleDateFormat formatter = new SimpleDateFormat(DateType);
		try {
			Date mDateTime = formatter.parse(DateValue);
			result = formatter.format(mDateTime);
		} catch (Exception ex) {
			result = ex.getMessage();
		}
		if (result.equalsIgnoreCase("1900-01-01")) {
			result = "";
		}
		return result;
	}

	public static String getDateTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mDateTime = formatter.format(cal.getTime());
		return (mDateTime);
	}

	public static String formatDateTime(Date d) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mDateTime = formatter.format(d);

		return (mDateTime);
	}

	public static Timestamp getDate() {
		Calendar cal = Calendar.getInstance();
		long timeMillis = cal.getTimeInMillis();
		return new Timestamp(timeMillis);
	}

	public static String formatSecond(Date d) {
		SimpleDateFormat f2 = new SimpleDateFormat("ss");
		return f2.format(d);
	}

	public static String formatDate(Date d) {
		SimpleDateFormat f2 = new SimpleDateFormat("yyyyMMddHHmm");
		return f2.format(d);
	}

	public static boolean isInSomeDays(Date date) {
		Date dateNow = new Date();
		// 获得两个时间的毫秒时间差异
		long diff = dateNow.getTime() - date.getTime();
		if (diff < 0) {
			diff = -diff;
		}
		return SENCODS_IN_FIVE_DAYS > diff;// 5天内true

	}

	/**
	 * 获得指定日期的前一天
	 * 
	 * @param specifiedDay
	 * @return
	 * @throws Exception
	 */
	public static String getSpecifiedDayBefore(String specifiedDay) {// 可以用new
																		// Date().toLocalString()传递参数
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);

		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
				.getTime());
		return dayBefore;
	}

	/**
	 * 获得指定日期的后一天
	 * 
	 * @param specifiedDay
	 * @return
	 */
	public static String getSpecifiedDayAfter(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
				.format(c.getTime());
		return dayAfter;
	}
}
