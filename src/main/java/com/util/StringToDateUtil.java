/**
 *@Copyright:Copyright (c) 2014
 */
package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 字符串转Date类型
 *@Author kklt21cn
 *@Since 2014年7月1日
 *@Version 1.0
 */
public class StringToDateUtil {
	public Date toDate(String dateStr){
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");        
		Date time = null;
		try {
			time = formatDate.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
		
	}
}
