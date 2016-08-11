package com.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Blob;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

public class StringUtil {

	/**
	 * 如果对象数组tars中存在对象src,返回true;否则返回false.用equals方法比较对象
	 * (注意:当src为null时,如果tars中有null的值将返回true)
	 * 
	 * @param src
	 * @param tars
	 * @return
	 */
	public static boolean isExist(Object src, Object[] tars) {
		for (Object tar : tars) {
			if (src == null && tar == null)
				return true;
			if (src.equals(tar))
				return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否为空
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}

	/**
	 * 如果src为空返回def,否则返回src
	 * 
	 * @param src
	 * @param def
	 * @return
	 */
	public static String isEmpty(String src, String def) {
		if (isEmpty(src))
			return def;
		return src;
	}

	/**
	 * 如果src为空返回空字串(""),否则返回src
	 * 
	 * @param src
	 * @return
	 */
	public static String isEmptyDefault(String src) {
		return isEmpty(src, "");
	}

	/**
	 * 将字符串数组用指定连接字符连接成一个字符串
	 * 
	 * @param sources 源字符串数组
	 * @param separator 连接字符串
	 * @return
	 */
	public static String join(String[] sources, String separator) {
		if (sources == null || sources.length == 0) {
			return "";
		}
		int size = sources.length;
		StringBuffer targetBuffer = new StringBuffer();
		for (int i = 0; i < size - 1; i++) {
			targetBuffer.append(sources[i]).append(separator);
		}
		targetBuffer.append(sources[size - 1]);
		return targetBuffer.toString();
	}

	/**
	 * 将字符串转换为utf8格式
	 */
	public static String asc2utf(String str) {
		if (str == null) {
			return "";
		}
		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return str;
		}
	}

	/**
	 * 将字符串编码为utf8格式
	 */
	public static String decode2Utf(String str) {
		try {
			return URLDecoder.decode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			return str;
		}
	}

	/**
	 * 将首字母变为大写
	 * 
	 * @param src
	 * @return
	 */
	public static String toPreUpper(String src) {
		return src.substring(0, 1).toUpperCase() + src.substring(1);
	}

	/**
	 * 读取Blob类型的值，以字符串形式返回
	 * 
	 * @param b
	 * @return
	 */
	public static String readBlob(Blob b) {
		if (b == null)
			return "";
		StringBuffer sb = new StringBuffer();
		InputStreamReader r = null;
		try {
			r = new InputStreamReader(b.getBinaryStream());
			char[] cs = new char[1024];
			int len;
			while ((len = r.read(cs)) != -1) {
				sb.append(cs, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (r != null)
				try {
					r.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return sb.toString();
	}

	public static int[] toInt(String[] vs) {
		if (vs == null)
			return null;
		int[] re = new int[vs.length];
		int c = 0;
		for (String v : vs) {
			try {
				int i = Integer.parseInt(v);
				re[c++] = i;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int[] is = new int[c];
		System.arraycopy(re, 0, is, 0, c);
		return is;
	}

	public static String clearChar() {
		return null;
	}

	/**
	 * 字符串按字节截取
	 * 
	 * @param str 原字符
	 * @param len 截取长度
	 * @param elide 省略符
	 * @return String
	 */

	public static String splitString(String str, int len, String elide) {
		if (str == null) {
			return "";
		}
		byte[] strByte = str.getBytes();
		int strLen = strByte.length;
		if (len >= strLen || len < 1) {
			return str;
		}
		int count = 0;
		for (int i = 0; i < len; i++) {
			int value = (int) strByte[i];
			if (value < 0) {
				count++;
			}
		}
		if (count % 2 != 0) {
			len = (len == 1) ? len + 1 : len - 1;
		}
		return new String(strByte, 0, len) + elide.trim();
	}

	public static String[] Sort(String[] a) {
		int y = a.length;
		for (int x = 0; x < a.length - 1; x++) {
			for (int i = 0; i < y - 1; i++) {
				String str1 = a[i];
				String str2 = a[i + 1];
				int flag = str1.compareToIgnoreCase(str2);
				if (flag >= 0) {
					a[i] = str2;
					a[i + 1] = str1;
				}
			}
			y = y - 1;
		}
		return a;
	}

	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replace("-", "");
	}

	public static String getRandom(int length) {
		long lseed = new Date().getTime();
		java.util.Random random = new Random(lseed);
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < length; i++) {
			str.append(random.nextInt(9)); // 生成随机数字
		}
		return str.toString();
	}

	public static String getFilePre(String name) {
		if (!StringUtils.isEmpty(name) && name.lastIndexOf(".") > 0) {
			return name.substring(name.lastIndexOf("."));
		} else {
			return "";
		}
	}

	public static String getFilePath(String fullPath) {
		if (null != fullPath && fullPath.trim().length() > 0) {
			fullPath = fullPath.replaceAll("\\\\", "/");
		}
		String path = fullPath.substring(fullPath.lastIndexOf("/"));
		return path;
	}

	public static String getFileName(String fullPath) {
		if (null != fullPath && fullPath.trim().length() > 0) {
			fullPath = fullPath.replaceAll("\\\\", "/");
		}
		String name = fullPath.substring(fullPath.lastIndexOf("/") + 1, fullPath.lastIndexOf("."));
		return name;
	}

	/**
	 * 获取异常详细信息
	 * 
	 * @param e
	 * @return
	 */
	public static String getError(Exception e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<strong style='color:green;'>" + e.getMessage() + "</strong>");
		StackTraceElement[] trace = e.getStackTrace();
		for (int i = 0; i < trace.length; i++) {
			String t = trace[i].toString();
			if (trace[i].getClassName().contains("com.tios")) {
				t = "<strong style='color:blue;'><br>\tat " + t + "</strong>";
			} else {
				t = "<br>\tat " + t;
			}
			sb.append(t);
			if (i >= 30) {
				sb.append("<br>\t...");
				break;
			}
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		System.out.println(getUUID());
		/*
		 * String str = "Java按字节截取字符串,中文是两字节"; int num = 7000; String s =
		 * splitString(str, num, "..."); System.out.println(s);
		 * 
		 * String[] a = { "700=10", "700=4", "700=1", "700=10", "700=99",
		 * "700=1" }; String[] b = Sort(a); for (int i = 0; i < b.length; i++) {
		 * System.out.println(a[i]); }
		 */
	}
}