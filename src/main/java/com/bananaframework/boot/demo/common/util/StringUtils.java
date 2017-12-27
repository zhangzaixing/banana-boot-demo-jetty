package com.bananaframework.boot.demo.common.util;

/**
 * 
 *StringUtils class
 *
 *@author zzx
 *@date 2017年12月26日 上午10:09:49
 */
public class StringUtils {

	public static String zeroAfterFill(String message, int size) {
		int length = message.length();
		if(length >= size) {
			return message;
		}
		else {
			String zeroStr = "";
			int differLength = size - length;
			for (int i = 1; i <= differLength; i++) {
				zeroStr += "0";
			}
			return message + zeroStr;
		}
	}
	
	public static String zeroBeforeFill(String message, int size) {
		int length = message.length();
		if(length >= size) {
			return message;
		}
		else {
			String zeroStr = "";
			int differLength = size - length;
			for (int i = 1; i <= differLength; i++) {
				zeroStr += "0";
			}
			return zeroStr + message;
		}
	}
	
}
