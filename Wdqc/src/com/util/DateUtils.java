package com.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

/**
 * 日期处理类
 * 
 * @author chenzp 2016-03-01
 */
public class DateUtils {
	public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	public static SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 根据当前时间返回一个形式为'yyyy-MM-dd-HH-mm-ss'的字符串
	 * <P>
	 * 改字符串可作为一个文件的名称
	 * 
	 * @return 形式如'yyyy-MM-dd-HH-mm-ss'的字符串
	 */
	public static final String dateTime2FileName() {
		String date_time = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		date_time = date_time.replaceAll(":", "-");
		date_time = date_time.replaceAll(" ", "-");
		return date_time;
	}

	/**
	 * 格式化时间的显示，传入参数为Calendar
	 * 
	 * @param objCal Calendar Object
	 * @param strFormat 日期格式化的标准 e.g. "yyyy/MM/dd
	 *            HH:mm:ss"（务必按标准写，可参考java.text.simpleDateFormat.java)
	 * @return String 格式化的时间
	 */
	public static String formatCalendar(Calendar objCal, String strFormat) {

		if (objCal == null) {
			return null;
		} else {
			SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
			return formatter.format(objCal.getTime());
		}
	}

	/**
	 * 格式化时间的显示，传入参数为Date
	 * 
	 * @param dt Date
	 * @param strFormat 日期格式化的标准 e.g. "yyyy/MM/dd
	 *            HH:mm:ss"（务必按标准写，可参考java.text.simpleDateFormat.java)
	 * @return String 格式化的时间
	 */
	public static String formatDate(Date dt, String format) {
		if (dt == null) {
			return null;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			return formatCalendar(cal, format);
		}
	}

	public static String formatDate(Date dt) {
		if (dt == null) {
			return null;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			return formatCalendar(cal, "yyyy-MM-dd");
		}
	}

	public static String formatDateTime(Date dt, String format) {
		if (dt == null) {
			return null;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			return formatCalendar(cal, format);
		}
	}

	public static String formatDateTime(Date dt) {
		if (dt == null) {
			return null;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			return formatCalendar(cal, "yyyy-MM-dd HH:mm:ss");
		}
	}

	/**
	 * 格式化时间的显示
	 * <p>
	 * <code>strFormat</code>的格式如"yyyy/MM/dd
	 * HH:mm:ss"（务必按标准写，可参考java.text.simpleDateFormat.java)
	 * 
	 * @param objTS Timestamp Object
	 * @param strFormat 日期格式化的标准 e.g. "yyyy/MM/dd
	 *            HH:mm:ss"（务必按标准写，可参考java.text.simpleDateFormat.java)
	 * @return String 格式化的时间
	 */
	public static String formatTimestamp(Timestamp objTS, String strFormat) {

		if (objTS == null) {
			return null;
		} else {
			Calendar objCal = Calendar.getInstance();
			Date d = new Date(objTS.getTime());
			objCal.setTime(d);
			return formatCalendar(objCal, strFormat);
		}
	}

	/**
	 * 返回特定时间的前几天 如果特定时间为"2005-5-23 23:22:32",<code>days</code>为7，
	 * 如果from=false,则为2005-5-16 23:22:32, 如果from＝true，则为2005-5-16 00:00:00
	 * <P>
	 * 如果<code>days</code>是负数，则是返回其后几天
	 * 
	 * @param dt Date 指定的特定时间
	 * @param days int 返回前几天的天数
	 * @param from0 boolean 是否从零点开始
	 * @return Date
	 */
	public static Date getBeforeDays(Date dt, int days, boolean from0) {
		if (dt == null) {
			return null;
		} else {
			Calendar cl = Calendar.getInstance();
			cl.setTime(dt);

			if (from0) {
				Calendar c2 = Calendar.getInstance();
				c2.set(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH), cl.get(Calendar.DATE), 0, 0, 0);
				cl = c2;
			}

			cl.add(Calendar.DATE, -days);
			return cl.getTime();
		}
	}

	/**
	 * 得到特定时间的前几个月的时间
	 * <P>
	 * 如果<code>months</code>是负数，则是返回其后几个月
	 * 
	 * @param dt Date 指定的特点时间
	 * @param months int 返回前几月的月数
	 * @return Date
	 */
	public static Date getBeforeMonths(Date dt, int months) {
		if (dt == null) {
			return null;
		}
		int[] dts = DateUtils.TimeSplit(DateUtils.formatDate(dt, "yyyy-MM-dd HH-mm-ss"));
		int years = dts[0];
		int all = years * 12 + dts[1];
		int all_new = all - months - 1;
		int years_new = all_new / 12;
		int month_new = all_new % 12;
		Calendar dt_new = Calendar.getInstance();
		dt_new.setTime(dt);
		dt_new.set(years_new, month_new, dts[2], dts[3], dts[4], dts[5]);
		return dt_new.getTime();
	}

	/**
	 * 计算两个时间之间相隔天数
	 * <P>
	 * 如果<code>startDay</code>或<code>endDay</code>有一个格式不为'yyyyMMdd'，则返回-1
	 * 
	 * @param startday 开始时间
	 * @param endday 结束时间
	 * @return 相隔的天数
	 */
	public static int getIntervalDays(String startDay, String endDay) {
		if (startDay.length() != 8 || endDay.length() != 8) {
			return -1;
		}
		return getIntervalDays(DateUtils.string2Date(startDay, "yyyyMMdd"), DateUtils.string2Date(endDay, "yyyyMMdd"));
	}

	/**
	 * 计算两个时间之间相隔天数
	 * <P>
	 * 如果<code>startDay</code>或<code>endDay</code>有一个为<code>null</code>，则返回-1
	 * 
	 * @param startday 开始时间
	 * @param endday 结束时间
	 * @return 相隔的天数
	 */
	public static int getIntervalDays(Calendar startDay, Calendar endDay) {
		if (startDay == null || endDay == null) {
			return -1;
		}
		return getIntervalDays(startDay.getTime(), endDay.getTime());
	}

	/**
	 * 计算两个时间之间相隔天数
	 * <P>
	 * 如果<code>startDay</code>或<code>endDay</code>有一个为<code>null</code>，则返回-1
	 * 
	 * @param startday 开始时间
	 * @param endday 结束时间
	 * @return 相隔的天数
	 */
	public static int getIntervalDays(Date startDay, Date endDay) {
		if (startDay == null || endDay == null) {
			return -1;
		}
		// 确保startday在endday之前
		if (startDay.after(endDay)) {
			Date cal = startDay;
			startDay = endDay;
			endDay = cal;
		}
		// 分别得到两个时间的毫秒数
		long start = startDay.getTime();
		long end = endDay.getTime();
		long inter = end - start;

		long dateMillSec = 24 * 60 * 60 * 1000;

		long dateCnt = inter / dateMillSec;

		long remainder = inter % dateMillSec;

		if (remainder != 0) {
			dateCnt++;
		}

		// 根据毫秒数计算间隔天数
		return (int) (dateCnt);
	}

	/**
	 * 计算某一月份的最大天数
	 * 
	 * @param year 年份
	 * @param month 月份
	 * @return 返回指定月份的最大天数
	 */
	public static int getMaxDayInMonth(int year, int month) {
		Calendar time = Calendar.getInstance();
		time.clear();
		time.set(Calendar.YEAR, year);
		time.set(Calendar.MONTH, month - 1);// 注意,Calendar对象默认一月为0
		int day = time.getActualMaximum(Calendar.DAY_OF_MONTH);// 本月份的天数
		return day;
	}

	/**
	 * 计算某一天是一年中的第几星期
	 * <P>
	 * 如果<code>date</code>为<code>null</code>，则返回0
	 * 
	 * @param date 指定的时间
	 * @return 返回指定时间是是一年中的第几星期
	 */
	public static int getWeekNoOfDay(Date date) {
		if (date == null) {
			return -1;
		}
		Calendar time = Calendar.getInstance();
		time.setTime(date);
		return time.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 返回当前时间，显示格式为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return String 格式化后的时间
	 */
	public static String getNowDateTime() {
		Date datetime = new Date();
		return dtf.format(datetime);
	}

	/**
	 * 把传入的 <code>sdate</code> 转化成<code>Date</code>
	 * <P>
	 * 传入的 <code>sdate</code>
	 * 的格式务必按标准写（可参考java.text.simpleDateFormat.java）如'yyyy-MM-dd'、'yyyy-MM-dd
	 * HH:mm:ss'
	 * <P>
	 * 当<code>sdate</code>为<code>null</code>或者<code>sdate</code>的长度为0时，返回
	 * <code>null</code>
	 * <P>
	 * 当<code>sdate</code>和<code>format</code>格式不同时返回<code>null</code>
	 * 
	 * @param sdate 传入的时间串，格式为'yyyy-MM-dd'
	 * @return 返回<code>sdate</code>表示的时间
	 */
	public static final java.util.Date string2Date(String sdate, String format) {
		if (sdate == null || sdate.length() == 0) {
			return null;
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			return formatter.parse(sdate);
		} catch (ParseException ex) {
			return null;
		}
	}

	/**
	 * 从标准时间格式的字符串中取出年、月、日、时、分、秒组成的int类型数组
	 * <P>
	 * 如果传入的String为null或空，则直接返回null
	 * 
	 * @param DateTimeStr String "2004-2-2 3-34-35" (用－或：或/作间隔）
	 * @return int[] 返回以年、月、日、时、分、秒组成的int类型数组
	 */
	public static int[] TimeSplit(String DateTimeStr) {
		if (DateTimeStr == null || DateTimeStr.length() == 0) {
			return null;
		}

		DateTimeStr = DateTimeStr.trim().replaceAll("/", "-");
		DateTimeStr = DateTimeStr.replaceAll(" ", "-").replaceAll(":", "-");
		String[] values = DateTimeStr.split("-");
		int[] timeArr = new int[values.length];
		for (int i = 0; i < timeArr.length; i++) {
			try {
				timeArr[i] = Integer.parseInt(values[i]);
			} catch (NumberFormatException nfe) {
				timeArr[i] = 0;
			}
		}
		return timeArr;
	}

	/**
	 * 时间格式化
	 * 
	 * @param source
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String source, String format) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(source);
	}

	/**
	 * 获取指定年份指定周次指定星期的对应日期
	 * 
	 * @param year
	 * @param weekofyear 第一周是1
	 * @param dayofweek 星期一是1
	 * @return
	 */
	public static String getDay(int year, int weekNo, int dayofweek) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.WEEK_OF_YEAR, weekNo);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		c.add(Calendar.DAY_OF_WEEK, dayofweek);
		String day = formatCalendar(c, "yyyy-MM-dd");
		return day;
	}

	public static int getDayofweek(String dayofweek) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("星期一", 0);
		map.put("星期二", 1);
		map.put("星期三", 2);
		map.put("星期四", 3);
		map.put("星期五", 4);
		map.put("星期六", 5);
		map.put("星期日", 6);
		return map.get(dayofweek);
	}

	public static String getStartDayOfWeekNo(int year, int weekNo) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.WEEK_OF_YEAR, weekNo);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return formatCalendar(c, "yyyy-MM-dd");
	}

	public static String getEndDayOfWeekNo(int year, int weekNo) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.WEEK_OF_YEAR, weekNo);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		c.add(Calendar.DAY_OF_WEEK, 6);
		return formatCalendar(c, "yyyy-MM-dd");
	}

	/**
	 * 私有的构造函数，可防止本类被实例化
	 * 
	 */
	private DateUtils() {

	}

	public static void main(String args[]) {
		// String d = DateUtils.formatDate(new Date(), "ddMMyy");
		// String id2 = String.format("%04d", 50000);
		// System.out.println(id2);
		// System.out.println(d);

		// Calendar calendar = Calendar.getInstance();
		// calendar.set(calendar.get(Calendar.YEAR),
		// calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
		// Date s = calendar.getTime();
		// calendar.add(Calendar.DATE, 1);
		// Date e = calendar.getTime();
		// System.out.println(formatDateTime(s));
		// System.out.println(formatDateTime(e));
		// Date d = DateUtils.getBeforeDays(new Date(), -1, true);
		// System.out.println(formatDateTime(d));

		// int w = 6;
		// for (int i = 1; i < 7; i++) {
		// System.out.println(DateUtils.getDay(2016, i,getDayofweek("星期二")) );
		// }
	}
}
