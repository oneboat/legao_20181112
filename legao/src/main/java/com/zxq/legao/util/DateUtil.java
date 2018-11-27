package com.zxq.legao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String getAge(Date date){
		Long currentTime = System.currentTimeMillis();
		if ((currentTime - date.getTime()) <=0 || date==null){
			return "0岁0个月";
		}
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(new Date());

			int ageyear = calendar1.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
			int agemonth = calendar1.get(Calendar.MONTH) - calendar.get(Calendar.MONTH);
			if(agemonth<=0){agemonth=0;}
			String age = ageyear+"岁"+agemonth+"个月";
			return age;

	}
}
