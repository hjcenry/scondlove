package com.mochasoft.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	
	public static String dateToString(Date date)
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss"); 
		java.sql.Date sDate=new java.sql.Date(date.getTime());
		return df.format(sDate);
	}

}
