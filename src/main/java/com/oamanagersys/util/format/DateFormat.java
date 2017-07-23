package com.oamanagersys.util.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {
	public static String dateToString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		String str = sdf.format(date);
		return str;
	}
	
	public static Date stringToDate(String date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		Date str = null;
		try {
			str = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * 当前日期时间yyyy-MM-dd HH:mm
	 * @return
	 */
	public static String newDateString(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		String str = sdf.format(new Date());
		return str;
	}
	
	/**
	 * 当前日期yyyy-MM-dd
	 * @return
	 */
	public static String nowDateString(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		String str = sdf.format(new Date());
		return str;
	}
	
	/**
	 * 当前时间 HH:mm
	 * @return
	 */
	public static String getTime(){
		String str = newDateString();
		str = str.substring(str.indexOf(" ")+1);
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
	
	/**
	 * 获取当前年月份 XXXX-XX
	 * @return
	 */
	public static String getYearAndMonth(){
		Calendar cal = Calendar.getInstance();
		String year = Integer.toString(cal.get(Calendar.YEAR));
		String month = String.format("%02d", cal.get(Calendar.MONTH) + 1);
		return year+"-"+month;
	}
	
	/**
	 * 获取星期
	 * @return
	 */
	public static String getWeekDay(){
		String[] weekDays = {"日", "一", "二", "三", "四", "五", "六"};
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK)-1;
		if (week < 0){
			week = 0;
		}
        return weekDays[week];
	}
}
