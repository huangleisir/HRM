package com.hrm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串形式日期转换成timpstamp类型的字符串的工具类
 * 目的是为了将页面获取的日期字符串方便的插入到数据库中timestamp字段中
 * @author Administrator
 *
 */
public class StringToTimeStamp {
	public static String parse(String date) throws ParseException{
		if(null==date || "".equals(date.trim()))
			return null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date parse2date=sdf.parse(date);
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-M月-yy hh.mm.ss.000000 上午");
		String time=sdf1.format(parse2date);
		return time;
	}
	public static String parse(Date date) throws ParseException{
		if(null==date)
			return null;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-M月-yy hh.mm.ss.000000 上午");
		String time=sdf.format(date);
		return time;
	}
}
