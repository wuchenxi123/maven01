package com.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.core.sys.util.processor.DateJsonValueProcessor;
import com.core.sys.util.processor.FloatJsonValueProcessor;

public class PageUtils {
	public static JsonConfig configJson(String[] excludes, String datePattern) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonConfig.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor(datePattern));
		jsonConfig.registerJsonValueProcessor(Float.class,
				new FloatJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(java.sql.Date.class,
				new DateJsonValueProcessor(datePattern));
		return jsonConfig;
	}

	public static void writePage(Object bean, HttpServletResponse response,
			String datePattern) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String callback = request.getParameter("callback");
		JsonConfig jsonConfig = configJson(null, datePattern);
		JSON json = JSONSerializer.toJSON(bean, jsonConfig);
		response.setContentType("text/json;charset=utf-8");
		if (StringUtils.isBlank(callback)) {
			response.getWriter().write(json.toString());
		} else {
			response.getWriter().write(callback + "(" + json.toString() + ");");
		}
	}

	public static void writePage(Object bean, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(toJSON(bean));
	}

	public static String toJSON(Object bean, String datePattern) {
		JsonConfig jsonConfig = configJson(null, datePattern);
		JSON json = JSONSerializer.toJSON(bean, jsonConfig);
		return json.toString();
	}

	public static String toJSON(Object bean) {
		return toJSON(bean, "yyyy-MM-dd HH:mm:ss");
	}

}
