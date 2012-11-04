package com.spark.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AppUtils {

	public static Date currentTime() {
		return new Date();
	}
	
	public static Date parseDate(String sdate, String format) throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.parse(sdate);
	}
	
	public static String format(Date date, String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(date);
	}
}
