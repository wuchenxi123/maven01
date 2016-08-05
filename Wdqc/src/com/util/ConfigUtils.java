package com.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DBAccessUser;*/

/**
 * 系统配置类
 * 
 * @author chenzp 2013-8-15
 */
public class ConfigUtils {
	private final Log log = LogFactory.getLog(ConfigUtils.class);
	private static ConfigUtils instance = null;
	private static Map<String, String> config = new HashMap<String, String>();

	public static ConfigUtils getInstance() {
		if (instance == null) {
			instance = new ConfigUtils();
		}
		return instance;
	}

	/**
	 * 获取系统参数
	 * 
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		return getInstance().getConfig(key);
	}

	/**
	 * 获取产品序列号过期时间（天）
	 * 
	 * @return
	 */
	public static int getOverdueDay() {
		String over = get("overdue_day");
		if (StringUtils.isEmpty(over)) {
			return 30;
		}
		return Integer.valueOf(over);
	}

	/**
	 * 是否测试系统
	 * 
	 * @return
	 */
	public static boolean isTest() {
		return "true".equals(ConfigUtils.get("isTest"));
	}

	private String getConfig(String key) {
		return config.get(key);
	}

	private ConfigUtils() {
		init();
	}

	private void init() {
		try {
			/*STConfig bo = (STConfig) BOFactory.build(STConfigBO.class,
					DBAccessUser.getInnerUser());
			config = bo.doConfig();*/
		} catch (Exception e) {
			log.error(e);
		}
	}
}
