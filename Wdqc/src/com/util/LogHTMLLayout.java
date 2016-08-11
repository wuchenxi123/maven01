package com.util;

import java.util.Date;

import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.helpers.Transform;
import org.apache.log4j.spi.LoggingEvent;

public class LogHTMLLayout extends HTMLLayout {

	String title = "Store-Log";

	// Print no location info by default
	boolean locationInfo = true;

	protected final int BUF_SIZE = 256;
	protected final int MAX_CAPACITY = 1024;

	static String TRACE_PREFIX = "<br>&nbsp;&nbsp;&nbsp;&nbsp;";

	// output buffer appended to when format() is invoked
	private StringBuffer sbuf = new StringBuffer(BUF_SIZE);

	public LogHTMLLayout() {
	}

	/**
	 * Returns appropriate HTML headers.
	 */
	public String getHeader() {
		StringBuffer sbuf = new StringBuffer();
		// sbuf.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">"
		// + Layout.LINE_SEP);
		sbuf.append("<html>" + Layout.LINE_SEP);
		sbuf.append("<head>" + Layout.LINE_SEP);
		sbuf.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\">"
				+ Layout.LINE_SEP);
		sbuf.append("<title>" + title + "</title>" + Layout.LINE_SEP);
		sbuf.append("<style type=\"text/css\">" + Layout.LINE_SEP);
		sbuf.append("<!--" + Layout.LINE_SEP);
		sbuf.append("body, table {font-family: arial,sans-serif; font-size: 12px;}"
				+ Layout.LINE_SEP);
		// sbuf.append("th {background: #336699; color: #FFFFFF; text-align: left;}"
		// + Layout.LINE_SEP);
		sbuf.append("td{border-top: 1px solid;border-right: 1px solid;}"
				+ Layout.LINE_SEP);
		sbuf.append("-->" + Layout.LINE_SEP);
		sbuf.append("</style>" + Layout.LINE_SEP);
		sbuf.append("</head>" + Layout.LINE_SEP);
		sbuf.append("<body topmargin=\"0\" leftmargin=\"0\" bgcolor=\"#E7E7E7\">"
				+ Layout.LINE_SEP);
		// sbuf.append("<hr size=\"1\" noshade>" + Layout.LINE_SEP);
		// sbuf.append("Log session start time " + new java.util.Date() + "<br>"
		// + Layout.LINE_SEP);
		// sbuf.append("<br>" + Layout.LINE_SEP);
		sbuf.append("<table width=\"755\" cellspacing=\"0\" cellpadding=\"2\" border=\"1\" bordercolor=\"#224466\" style=\"word-wrap:break-word; table-layout:fixed;border-left: 1px solid;border-bottom: 1px solid;\">"
				+ Layout.LINE_SEP);
		sbuf.append("<tr bgcolor=\"#336699\">" + Layout.LINE_SEP);
		sbuf.append("<td align=\"center\" width=\"120\"><font color=\"#FFFFFF\">时间</font></td>"
				+ Layout.LINE_SEP);
		// sbuf.append("<th>Thread</th>" + Layout.LINE_SEP);
		sbuf.append("<td align=\"center\" width=\"30\"><font color=\"#FFFFFF\">等级</font></td>"
				+ Layout.LINE_SEP);
		// sbuf.append("<th>Category</th>" + Layout.LINE_SEP);
		if (locationInfo) {
			sbuf.append("<td align=\"center\" width=\"130\"><font color=\"#FFFFFF\">日志名</font></td>"
					+ Layout.LINE_SEP);
		}
		sbuf.append("<td align=\"center\" width=\"475\"><font color=\"#FFFFFF\">日志消息</font></td>"
				+ Layout.LINE_SEP);
		sbuf.append("</tr>" + Layout.LINE_SEP);
		return sbuf.toString();
	}

	public String format(LoggingEvent event) {

		if (sbuf.capacity() > MAX_CAPACITY) {
			sbuf = new StringBuffer(BUF_SIZE);
		} else {
			sbuf.setLength(0);
		}

		sbuf.append(Layout.LINE_SEP + "<tr>" + Layout.LINE_SEP);

		sbuf.append("<td>");
		sbuf.append(DateUtils.formatDate(new Date(event.timeStamp),
				"MM/dd HH:mm:ss.SSS"));
		sbuf.append("</td>" + Layout.LINE_SEP);

		/*
		 * sbuf.append("<td title=\"" + event.getThreadName() + " thread\">");
		 * sbuf.append(Transform.escapeTags(event.getThreadName()));
		 * sbuf.append("</td>" + Layout.LINE_SEP);
		 */

		sbuf.append("<td align=\"center\">");
		if (event.getLevel().equals(Level.DEBUG)) {
			sbuf.append("<font color=\"#339933\">");
			// sbuf.append(event.getLevel());
			sbuf.append("调试");
			sbuf.append("</font>");
		} else if (event.getLevel().equals(Level.WARN)) {
			sbuf.append("<font color=\"#993300\">警告</font>");
		} else if (event.getLevel().equals(Level.INFO)) {
			sbuf.append("信息");
		} else if (event.getLevel().equals(Level.ERROR)) {
			sbuf.append("<font color=\"#993300\">错误</font>");
		} else if (event.getLevel().equals(Level.FATAL)) {
			sbuf.append("<font color=\"#FF0000\">严重</font>");
		}

		sbuf.append("</td>" + Layout.LINE_SEP);

		/*
		 * sbuf.append("<td title=\"" + event.getLoggerName() + " category\">");
		 * sbuf.append(Transform.escapeTags(event.getLoggerName()));
		 * sbuf.append("</td>" + Layout.LINE_SEP);
		 */

		if (locationInfo) {
			// LocationInfo locInfo = event.getLocationInformation();
			sbuf.append("<td>");
			// sbuf.append(Transform.escapeTags(locInfo.getFileName()));
			// sbuf.append(':');
			// sbuf.append(locInfo.getLineNumber());
			sbuf.append(event.getLoggerName());
			sbuf.append("</td>" + Layout.LINE_SEP);
		}

		sbuf.append("<td>");
		sbuf.append(Transform.escapeTags(event.getRenderedMessage()));
		sbuf.append("</td>" + Layout.LINE_SEP);
		sbuf.append("</tr>" + Layout.LINE_SEP);

		if (event.getNDC() != null) {
			sbuf.append("<tr><td bgcolor=\"#EEEEEE\" style=\"font-size : xx-small;\" colspan=\"6\" title=\"Nested Diagnostic Context\">");
			sbuf.append("NDC: " + Transform.escapeTags(event.getNDC()));
			sbuf.append("</td></tr>" + Layout.LINE_SEP);
		}

		String[] s = event.getThrowableStrRep();
		if (s != null) {
			sbuf.append("<tr><td bgcolor=\"#993300\" style=\"color:White; font-size : 11px;\" colspan=\"6\">");
			appendThrowableAsHTMLX(s, sbuf);
			sbuf.append("</td></tr>" + Layout.LINE_SEP);
		}

		return sbuf.toString();
	}

	void appendThrowableAsHTMLX(String[] mys, StringBuffer mysbuf) {
		if (mys != null) {
			int len = mys.length;
			if (len == 0)
				return;
			mysbuf.append(Transform.escapeTags(mys[0]));
			mysbuf.append(Layout.LINE_SEP);
			for (int i = 1; i < len; i++) {
				mysbuf.append(TRACE_PREFIX);
				mysbuf.append(Transform.escapeTags(mys[i]));
				mysbuf.append(Layout.LINE_SEP);
			}
		}
	}

}
