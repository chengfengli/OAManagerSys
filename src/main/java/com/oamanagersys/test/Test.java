package com.oamanagersys.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oamanagersys.util.format.DateFormat;
import com.oamanagersys.util.format.DateFormat2;

/**
 * 创建人： 李明
 * 时    间：2017年6月17日
 * 联    系：17310545652
 */
public class Test {
	public static void main(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		System.out.println(DateFormat2.nowDateTimeString());
	}
}
