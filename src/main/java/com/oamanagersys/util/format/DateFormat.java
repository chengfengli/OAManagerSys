package com.oamanagersys.util.format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	public static String dateToString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		String str = sdf.format(date);
		return str;
	}
	/**
	 * 当前时间
	 * @return
	 */
	public static String newDateString(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		String str = sdf.format(new Date());
		return str;
	}
	/**
	 * 时间戳
	 * @return
	 */
	public static String dateTime(){
		Date date = new Date();
		long time = date.getTime();
		return Long.toString(time);
	}
}
