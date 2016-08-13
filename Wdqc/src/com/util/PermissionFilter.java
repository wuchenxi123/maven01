package com.util;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.core.jop.infrastructure.db.DBAccessUser;
import com.manage.member.persistent.MemberVO;

/**
 * @author hujianjun
 * 
 */
public class PermissionFilter implements Filter {
	private final Log log = LogFactory.getLog(PermissionFilter.class);
	// 不需要做权限检查的资源列表
	private static HashMap<String, String> Free_Resource;
	// 以下后台资源开放给网站客户端用户访问
	private static HashMap<String, String> Guest_Resource;
	// 默认的登入跳转
	private static final String No_Login_Page = "/admin/login.jsp";
	private static final String No_Login_Page_mobile = "/assets/html5/user/login.html";
	// 没有权限页面
	private static final String No_Permission_Page = "/admin/nopermission.jsp";
	HttpServletRequest req = null;
	HttpServletResponse res = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		Free_Resource = new HashMap<String, String>();
		if (true) {
			Free_Resource.put("/ct_Show.ac", "");
			Free_Resource.put("/assets/html5/index.html", "手机首页");
			Free_Resource.put("/admin/login.jsp", "登录页面");
			Free_Resource.put("/admin/pages/member/register.jsp", "注册页面");
			Free_Resource.put(No_Login_Page, "管理员登录页面");
			Free_Resource.put(No_Permission_Page, "没有权限页面");
			Free_Resource.put(No_Login_Page_mobile, "手机登入页面");
		}
		Guest_Resource = new HashMap<String, String>();
		if (true) {
			Guest_Resource.put("/xxx", "yyy");
		}
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		req = (HttpServletRequest) request;
		res = (HttpServletResponse) response;
		String contextPath = req.getContextPath();
		// 当前访问的URL
		String url = req.getRequestURI();
		if (url != null) {
			url = url.replaceFirst(contextPath, "");
		if (free(url)) {
			// if free
			DBAccessUser user = (DBAccessUser) req.getSession().getAttribute(Constants.SESSION_DBUSER);
			if (user == null) {
				// set inner user
				req.getSession().setAttribute(Constants.SESSION_DBUSER, DBAccessUser.getInnerUser());
			}
		}else {
			MemberVO user = (MemberVO) req.getSession().getAttribute(Constants.SESSION_TIOSUSER);
			if (user == null) {
				Cookie cookie = new Cookie("JSESSIONID","-1");
				res.addCookie(cookie);
				res.sendRedirect(contextPath + getLoginPage(url));
				return;
			} else {
				// Permission check

			}
		}
		filterChain.doFilter(request, response);
		}
	}

	/**
	 * 是否自由访问的资源
	 */
	private boolean free(String url) {
		boolean free = Free_Resource.containsKey(url);
		boolean guest = Guest_Resource.containsKey(url);
		// action on mobile free(test)
		boolean mobile_action = /*url.contains("/mobile/") && */url.contains(".ac");
		// if html then android and ios free
		boolean free_html = isFreeHtml(url);
		return free || guest || mobile_action || free_html;
	}

	private boolean isFreeHtml(String url) {
		boolean h = url.toLowerCase().contains(".html");
		boolean f = url.toLowerCase().contains("html5/forum/");
		boolean i = url.toLowerCase().contains("html5/info/");
		boolean p = url.toLowerCase().contains("html5/portal/");
		boolean s = url.toLowerCase().contains("html5/store/");
		boolean u = url.toLowerCase().contains("html5/user/");
		return h && (f || i || p || s || u);
	}

	private boolean isAndroid() {
		String ag = req.getHeader("user-agent").toLowerCase();
		res.setHeader("ua", "android");
		return ag.contains("android");
	}

	private boolean isIPhone() {
		String ag = req.getHeader("user-agent").toLowerCase();
		res.setHeader("ua", "ios");
		log.info(ag);
		return ag.contains("iphone");
	}

	private String getLoginPage(String url) {
		if (isAndroid() || isIPhone()) {
			return No_Login_Page_mobile + "?u=" + url;
		} else {
			return No_Login_Page + "?u=" + url;
		}
	}
}
