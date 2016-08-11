package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Hex;
import org.apache.struts2.ServletActionContext;

import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.member.persistent.MemberVO;
import com.opensymphony.xwork2.ActionContext;

/**
 * 系统处理
 * 
 * @author chenzp 2013-6-3
 */
public class SysUtils {
	public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	private static final int BUFFER_SIZE = 16 * 1024;

	/**
	 * 获取IP和Mac地址
	 * 
	 * @return
	 */
	public static Map<String, String> getIpMac() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Process p = null;
		String str = "";
		String macAddress = "";
		String ip = request.getHeader("x-forwarded-for");
		try {
			// 获取IP
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
			if (System.getProperty("os.name").toLowerCase().indexOf("window") != -1) {// windows下
				p = Runtime.getRuntime().exec("nbtstat -A " + ip);
			} else {
			}
			// 获取MAC
			if (p != null) {
				InputStreamReader ir = new InputStreamReader(p.getInputStream());
				LineNumberReader input = new LineNumberReader(ir);
				for (int i = 1; i < 100; i++) {
					str = input.readLine();
					if (str != null) {
						if (str.indexOf("MAC Address") > 1) {
							macAddress = str.substring(str.indexOf("MAC Address") + 14, str.length());
							break;
						}
					}
				}
				input.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, String> m = new HashMap<String, String>();
		m.put("ip", ip);
		m.put("mac", macAddress);
		return m;
	}

	/**
	 * 文件上传
	 * 
	 * @param src 源头
	 * @param dst 目标
	 * @return
	 */
	public static String copy(File src, File dst) {
		String info = "";
		InputStream in = null;
		OutputStream out = null;
		if (null == src) {
			return "请选择要上传的文件";
		}
		try {
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer, 0, 8192)) != -1) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			info = "文件上传异常" + e.getMessage();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					info = "文件上传异常" + e.getMessage();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					info = "文件上传异常" + e.getMessage();
				}
			}
		}
		return info;
	}

	/**
	 * 获取指定目录下文件和目录
	 * 
	 * @param path 目录
	 * @param fileList null
	 * @param pid null
	 * @return
	 * @throws Exception
	 */
	
	
	/**
	 * 设置session内容
	 * 
	 * @param user
	 */
	public static void setSession(MemberVO user) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute(Constants.SESSION_TIOSUSER, user);
		// dbUser
		com.core.jop.ui.User dbUser = new com.core.jop.ui.User();
		dbUser.setSessionID(session.getId());
		dbUser.setOperid(user.getMbId());
		dbUser.setIp(ServletActionContext.getRequest().getRemoteAddr());
		dbUser.setLogintime(new Date());
		dbUser.setCityid(DBAccessUser.getInnerUser().getCityid());
		dbUser.setOprcode(user.getMbName());
		dbUser.setPassword(user.getMbPassword());
		dbUser.setOpername(user.getMbPetName());
		dbUser.setLogintime(new Date());
		session.setAttribute(Constants.SESSION_DBUSER, dbUser);
	}

	public static String FormatFileSize(long f) {// 转换文件大小
		DecimalFormat df = new DecimalFormat("#.00");
		String size = "";
		if (f < 1024) {
			size = df.format((double) f) + "B";
		} else if (f < 1048576) {
			size = df.format((double) f / 1024) + "KB";
		} else if (f < 1073741824) {
			size = df.format((double) f / 1048576) + "MB";
		} else {
			size = df.format((double) f / 1073741824) + "GB";
		}
		return size;
	}

	public static void main(String args[]) {

	}

}
