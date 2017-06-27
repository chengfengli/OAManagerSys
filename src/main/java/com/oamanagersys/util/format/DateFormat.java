package com.oamanagersys.util.format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	public static String dateToString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		String str = sdf.format(date);
		return str;
	}
	
	public static String newDateString(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		String str = sdf.format(new Date());
		return str;
	}
}
