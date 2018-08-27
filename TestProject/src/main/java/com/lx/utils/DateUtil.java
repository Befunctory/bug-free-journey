package com.lx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 获取当前时间 yyyy-MM-dd hh:mm:ss
	 * 
	 * @return
	 */
	public static String formatDate() {
		SimpleDateFormat sl = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String format = sl.format(new Date());
		return format;
	}

}
