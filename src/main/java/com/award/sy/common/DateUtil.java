package com.award.sy.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @描述：时间格式化的工具类
 * @作者：cyh
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午10:55:20
 *
 */
public class DateUtil {
	
	/**
	 * 获取当前日期(年月日)
	 * @param time
	 * @return
	 */
	public static String getNowDay(){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.FORMAT1_);
		Date date = new Date();
		String _time = sdf.format(date);
		return _time;
	}
	
	/**
	 * 获取当前时间(年-月-日 时:分:秒)
	 * @param time
	 * @return
	 */
	public static String getNowDate(){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.FORMAT1);
		Date date = new Date();
		String _time = sdf.format(date);
		return _time;
	}
	
	/**
	 * 获取当前时间(年-月-日 时:分:秒)
	 * @param time
	 * @return
	 */
	public static String getNowTime(){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.FORMAT3);
		Date date = new Date();
		String _time = sdf.format(date);
		return _time;
	}
	
	/**
	 * 根据给定的日期得到一天前的日期(年-月-日)
	 * @param time
	 * @return
	 */
	public static String getDayBeginDate(long time){
		Long three = 24 * 60 * 60 * 1000l;
		Long threeDay = time - three;
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.FORMAT1);
		Date threeTime = new Date(threeDay);
		String _time = sdf.format(threeTime);
		return _time;
	}
	
	/**
	 * 根据给定的日期得到三天前的日期(年-月-日)
	 * @param time
	 * @return
	 */
	public static String getThreeBeginDate(long time){
		Long three = 3 * 24 * 60 * 60 * 1000l;
		Long threeDay = time - three;
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.FORMAT1);
		Date threeTime = new Date(threeDay);
		String _time = sdf.format(threeTime);
		return _time;
	}
	
	/**
	 * 根据给定的日期得到一个月前的日期(年-月-日)
	 * @param time
	 * @return
	 */
	public static String getMonthBeginDate(long time){
		Long month = 30 * 24 * 60 * 60 * 1000l;
		Long threeDay = time - month;
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.FORMAT1);
		Date threeTime = new Date(threeDay);
		String _time = sdf.format(threeTime);
		return _time;
	}
	
	/**
	 * 根据给定的时间得到三天前的时间(年-月-日 时:分)
	 * @param time
	 * @return
	 */
	public static String getThreeDayBeginTime(long time){
		Long three = 3 * 24 * 60 * 60 * 1000l;
		Long threeDay = time - three;
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.FORMAT2);
		Date threeTime = new Date(threeDay);
		String _time = sdf.format(threeTime);
		return _time;
	}
	
	/**
	 * 根据给定的时间得到下一分钟前的时间(年-月-日 时:分)
	 * @param time
	 * @return
	 */
	public static String getPreMBeginTime(long time){
		Long three = 60 * 1000l;
		Long threeDay = time + three;
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.FORMAT2);
		Date threeTime = new Date(threeDay);
		String _time = sdf.format(threeTime);
		return _time;
	}
	
	/**
	 * 根据给定的时间得到一天前的时间(年-月-日 时:分:秒)
	 * @param time
	 * @return
	 */
	public static String getDayBeginTime(long time){
		Long three = 24 * 60 * 60 * 1000l;
		Long threeDay = time - three;
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.FORMAT3);
		Date threeTime = new Date(threeDay);
		String _time = sdf.format(threeTime);
		return _time;
	}
	
	/**
	 * 根据给定的时间得到十天前的时间(年-月-日 时:分:秒)
	 * @param time
	 * @return
	 */
	public static String getTenBeginTime(long time){
		Long three = 10*24 * 60 * 60 * 1000l;
		Long threeDay = time - three;
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.FORMAT3);
		Date threeTime = new Date(threeDay);
		String _time = sdf.format(threeTime);
		return _time;
	}
	
	/**
	 * 根据给定的时间得到10天的时间
	 * @param time
	 * @return
	 */
	public static Date getDateSecond(long time){
		Long month = 10 * 1000l;
		Long threeDay = time - month;
		Date threeTime = new Date(threeDay);
		return threeTime;
	}
	
	/**
	 * 根据给定的时间得到三天前的时间
	 * @param time
	 * @return
	 */
	public static Date getThreeDayBeginTime(Date time){
		Long three = 3 * 24 * 60 * 60 * 1000l;
		Long threeDay = time.getTime() - three;
		Date threeTime = new Date(threeDay);
		return threeTime;
	}
	/**
	 * 格式化时间，去掉后面的0
	 * @param date
	 * @return
	 */
	public static String formatTimeNew(Date date){
		if(date == null)
			return null;
		
		String checkTime = String.valueOf(date);
		
		if(checkTime != null && !"".equals(checkTime) && checkTime.length()>19){
			checkTime = checkTime.substring(0, 19);
		}
		
		return checkTime;
	}
	
	/**
	 * 格式化时间，保留到分钟
	 * @param date
	 * @return
	 */
	public static String formatTime(Date date){
		if(date == null)
			return null;
		
		String checkTime = String.valueOf(date);
		
		if(checkTime != null && !"".equals(checkTime) && checkTime.length()>19){
			checkTime = checkTime.substring(0, 16);
		}
		
		return checkTime;
	}
	
	/**
	 * 格式化时间，得到日期
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date){
		if(date == null)
			return null;
		
		String checkTime = String.valueOf(date);
		
		if(checkTime != null && !"".equals(checkTime) && checkTime.length()>19){
			checkTime = checkTime.substring(0, 10);
		}
		
		return checkTime;
	}
	
	/**
	 * 格式化时间，得到日期
	 * @param date
	 * @return
	 */
	public static String formatDate(String date){
		if(date == null)
			return null;
		
		String checkTime = String.valueOf(date);
		
		if(checkTime != null && !"".equals(checkTime) && checkTime.length()>19){
			checkTime = checkTime.substring(0, 10);
		}
		
		return checkTime;
	}
	
	/**
	 * 格式化时间，保留到秒
	 * @param date
	 * @return
	 */
	public static String formatTime(String date){
		if(date == null)
			return null;
		
		String checkTime = String.valueOf(date);
		
		if(checkTime != null && !"".equals(checkTime) && checkTime.length()>19){
			checkTime = checkTime.substring(0, 19);
		}
		
		return checkTime;
	}

}
