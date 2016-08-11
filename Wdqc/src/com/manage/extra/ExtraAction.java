package com.manage.extra;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.ui.struts2.BaseAction;
import com.core.sys.util.PageUtils;
import com.manage.member.control.Member;
import com.manage.member.control.MemberBO;
import com.manage.member.persistent.MemberVO;
import com.opensymphony.xwork2.ActionContext;
import com.util.Constants;
import com.util.MD5;
import com.util.StringUtil;

/**
 * Title: MobileAction
 * 
 * @author ChenZhiPing
 * @version 1.0
 */
public class ExtraAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5256077480566493900L;
	private final Log log = LogFactory.getLog(ExtraAction.class);
	private String Mobile_PageSize = "10";

	/**
	 * 注销
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doLogout() throws Exception {
		ActionContext.getContext().getSession().remove(Constants.SESSION_TIOSUSER);
		ActionContext.getContext().getSession().remove(Constants.SESSION_DBUSER);
		ActionContext.getContext().getSession().remove(Constants.SESSION_SN);
		ActionContext.getContext().getSession().remove(Constants.SESSION_MOBILE_SN);
		ActionContext.getContext().getSession().clear();

		HttpServletResponse res = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		req.getSession().invalidate();
		Cookie cookie = new Cookie("JSESSIONID", "-1");
		res.addCookie(cookie);

		Map<String, Object> dp = new HashMap<String, Object>();
		dp.put(Constants.AC, Constants.AC_success);
		dp.put(Constants.AC_msg, "");
		PageUtils.writePage(dp, res);
		return null;
	}

	/**
	 * 判断用户是否已经登录
	 * 
	 * @throws Exception
	 */
	public void doCheckLogined() throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();
		Integer uid = this.getDBAccessUser().getOperid();
		Map<String, Object> dp = new HashMap<String, Object>();
		dp.put(Constants.AC, uid > 0);
		dp.put(Constants.AC_msg, uid > 0 ? "" : "当前会话尚未有用户登录！");
		PageUtils.writePage(dp, res);
	}

	/**
	 * 修改当前用户的密码
	 * 
	 * @return
	 * @throws Exception
	 */
	public void doChangePwd() throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		String password = req.getParameter("password");
		if (StringUtil.isEmpty(password)) {
			throw new Exception("密码不能为空！");
		}
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			Member bo = (Member) BOFactory.build(MemberBO.class, this.getDBAccessUser());
			Integer pk = this.getDBAccessUser().getOperid();
			if (pk > 0) {
				MemberVO vo = bo.doFindByPk(pk);
				vo.setMbPassword(password);
				bo.doUpdate(vo);
				// log out
				doLogout();
				dp.put(Constants.AC, Constants.AC_success);
				dp.put(Constants.AC_msg, "");
			} else {
				dp.put(Constants.AC, Constants.AC_fail);
				dp.put(Constants.AC_msg, "当前用户尚未登录！");
			}
		} catch (Exception e) {
			dp.put(Constants.AC, Constants.AC_fail);
			dp.put(Constants.AC_msg, e.getMessage());
			dp.put(Constants.AC_Exception, StringUtil.getError(e));
			log.error(e);
		}
		PageUtils.writePage(dp, res);
	}

	/**
	 * 重置密码
	 * 
	 * @return
	 * @throws Exception
	 *//*
	public void doResetPwd() throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("password");
		if (StringUtil.isEmpty(mobile)) {
			throw new Exception("手机号码不能为空！");
		}

		if (StringUtil.isEmpty(password)) {
			throw new Exception("密码不能为空！");
		}
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			Member bo = (Member) BOFactory.build(MemberBO.class, this.getDBAccessUser());
			MemberVO vo = bo.getUserByAccount(mobile);
			if (null != vo) {
				vo.setMbPassword(password);
				bo.doUpdate(vo);
				// log out
				doLogout();
				dp.put(Constants.AC, Constants.AC_success);
				dp.put(Constants.AC_msg, "");
			} else {
				dp.put(Constants.AC, Constants.AC_fail);
				dp.put(Constants.AC_msg, "用户不存在，无法重置密码！");
			}
		} catch (Exception e) {
			dp.put(Constants.AC, Constants.AC_fail);
			dp.put(Constants.AC_msg, e.getMessage());
			dp.put(Constants.AC_Exception, StringUtil.getError(e));
			log.error(e);
		}
		PageUtils.writePage(dp, res);
	}
*/
	/**
	 * 注册
	 * 
	 * @throws Exception
	 */
	public String doRegister() throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("password");
		if (StringUtil.isEmpty(mobile)) {
			throw new Exception("手机号码不能为空！");
		}

		if (StringUtil.isEmpty(password)) {
			throw new Exception("密码不能为空！");
		}
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			Member bo = (Member) BOFactory.build(MemberBO.class, this.getDBAccessUser());
			MemberVO vo = new MemberVO();
			vo.setMbName(mobile);
			vo.setMbPhone(mobile);
			vo.setMbPassword(password);
			vo.setMbRegisterDate(new Date());

			vo.setMbType(1); // 默认普通用户。 用户类型：1普通用户；2开发者；0管理员
			vo.setMbPetName(req.getParameter("form.mbPetName"));
			vo.setMbQuestion(req.getParameter("form.mbQuestion"));
			vo.setMbAnswer(req.getParameter("form.mbAnswer"));

			// set default password
			if (StringUtil.isEmpty(vo.getMbPassword())) {
				MD5 m = new MD5();
				String n = m.getMD5ofStr(Constants.Pwd_Default).toLowerCase();
				vo.setMbPassword(n);
			}
			vo = bo.doCreate(vo);
			dp.put(Constants.AC, Constants.AC_success);
			dp.put(Constants.AC_msg, "");
		} catch (Exception e) {
			dp.put(Constants.AC, Constants.AC_fail);
			dp.put(Constants.AC_msg, e.getMessage());
			dp.put(Constants.AC_Exception, StringUtil.getError(e));
			log.error(e);
		}
		PageUtils.writePage(dp, res);
		return null;
	}

	/**
	 * 查询当前用户信息
	 * 
	 * @throws Exception
	 */
	public void doGetUserInfo() throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();
		Member bo = (Member) BOFactory.build(MemberBO.class, this.getDBAccessUser());
		Integer pk = this.getDBAccessUser().getOperid();
		if (pk <= 0) {
			throw new Exception("请先登录！");
		}
		MemberVO vo = bo.doFindByPk(Integer.valueOf(pk));
		PageUtils.writePage(vo, res, "yyyy-MM-dd HH:mm:ss");
	}

/*	*//**
	 * 获取图形验证码
	 *//*
	public void doGetPicCode() {
		HttpServletResponse res = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		RadomNumber num = new RadomNumber();
		try {
			num.doGet(req, res);
		} catch (Exception e) {
			log.error(e);
		}
	}

	*//**
	 * 校验验图形证码
	 * 
	 * @throws Exception
	 *//*
	public void doCheckPicCode() throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		String c = req.getParameter("c");
		String msg = "";
		boolean r = String.valueOf(req.getSession().getAttribute(Constants.SESSION_SN)).equals(c);
		if (!r) {
			msg = "验证码不正确！";
		}
		Map<String, Object> dp = new HashMap<String, Object>();
		dp.put(Constants.AC, Constants.AC_success);
		dp.put("valid", r);
		dp.put("message", msg);
		PageUtils.writePage(dp, res);
	}*/

/*
	*//**
	 * 判断账号是否存在，账号包括账号/邮箱/手机
	 * 
	 * @throws Exception
	 *//*
	public void doAccountExist() throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		String mobile = req.getParameter("mobile");
		if (StringUtil.isEmpty(mobile)) {
			throw new Exception("账号不能为空！");
		}
		Member bo = (Member) BOFactory.build(MemberBO.class, this.getDBAccessUser());
		MemberVO user = bo.getUserByAccount(mobile);
		boolean exist = null != user;

		Map<String, Object> dp = new HashMap<String, Object>();
		dp.put(Constants.AC, Constants.AC_success);
		dp.put("valid", exist);
		dp.put("message", exist ? "" : "账号" + mobile + "不存在，请核对！");
		PageUtils.writePage(dp, res);
	}*/

	/**
	 * 获取分页大小，为防止恶意大批量数据查询，系统默认一次只查询10条记录。
	 * 
	 * @return
	 */
	private String getPageSize() {
		return this.Mobile_PageSize;
	}

	/**
	 * 获取查询页号
	 * 
	 * @return
	 */
	private String getPageNo() {
		HttpServletRequest req = ServletActionContext.getRequest();
		String pageno = req.getParameter("pageno");
		if (StringUtil.isEmpty(pageno)) {
			pageno = "1";
		}
		return pageno;
	}
}
