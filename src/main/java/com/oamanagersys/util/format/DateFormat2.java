package com.oamanagersys.util.format;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 时间转换工具类
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年7月24日 下午4:55:10
 */
public class DateFormat2 {
	/**
	 * Date转string yyyy-MM-dd HH:mm
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		String str = sdf.format(date);
		return str;
	}
	/**
	 * 字符串转Date
	 * @param date
	 * @return
	 */
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
	public static String nowDateTimeString(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		return sdf.format(getNetworkDate());
	}
	
	/**
	 * 当前日期yyyy-MM-dd
	 * @return
	 */
	public static String nowDateString(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		return sdf.format(getNetworkDate());
	}
	
	/**
	 * 当前时间 HH:mm
	 * @return
	 */
	public static String getTime(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		return dateFormat.format(getNetworkDate());
	}
	/**
	 * 时间戳
	 * @return
	 */
	public static String dateTime(){
		Date date = getNetworkDate();
		long time = date.getTime();
		return Long.toString(time);
	}
	
	/**
	 * 获取当前年月份 XXXX-XX
	 * @return
	 */
	public static String getYearAndMonth(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM");
		return dateFormat.format(getNetworkDate());
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
	
	/**
	 * 获取网络时间
	 * @return
	 */
	public static Date getNetworkDate() {
        try {
            URL url = new URL("http://www.taobao.com");
            URLConnection conn = url.openConnection();
            conn.connect();
            long dateL = conn.getDate();
            Date date = new Date(dateL);
            return date;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
