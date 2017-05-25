package com.oamanagersys.util.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

/**
 * md5加密类
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月25日 上午9:20:39
 */
public class Md5 {
	public static String md5(String str){
		if(StringUtils.isNotBlank(str)){
			String newStr = "";
			try {
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				Base64 base64en = new Base64();
				newStr = base64en.encodeAsString(md5.digest(str.getBytes()));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return newStr;
		}else{
			return "";
		}
	}
}
