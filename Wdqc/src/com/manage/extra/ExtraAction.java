package com.manage.extra;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.ui.struts2.BaseAction;
import com.core.sys.util.PageUtils;
import com.manage.costlist.control.Costlist;
import com.manage.costlist.control.CostlistBO;
import com.manage.costlist.persistent.CostlistDBParam;
import com.manage.costlist.web.CostlistForm;
import com.manage.member.control.Member;
import com.manage.member.control.MemberBO;
import com.manage.member.persistent.MemberVO;
import com.manage.student.control.Student;
import com.manage.student.control.StudentBO;
import com.manage.student.web.StudentWebParam;
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
	 * ע��
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
	 * �ж��û��Ƿ��Ѿ���¼
	 * 
	 * @throws Exception
	 */
	public void doCheckLogined() throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();
		Integer uid = this.getDBAccessUser().getOperid();
		Map<String, Object> dp = new HashMap<String, Object>();
		dp.put(Constants.AC, uid > 0);
		dp.put(Constants.AC_msg, uid > 0 ? "" : "��ǰ�Ự��δ���û���¼��");
		PageUtils.writePage(dp, res);
	}

	/**
	 * �޸ĵ�ǰ�û�������
	 * 
	 * @return
	 * @throws Exception
	 */
	public void doChangePwd() throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		String password = req.getParameter("password");
		if (StringUtil.isEmpty(password)) {
			throw new Exception("���벻��Ϊ�գ�");
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
				dp.put(Constants.AC_msg, "��ǰ�û���δ��¼��");
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
	 * ��������
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
			throw new Exception("�ֻ���벻��Ϊ�գ�");
		}

		if (StringUtil.isEmpty(password)) {
			throw new Exception("���벻��Ϊ�գ�");
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
				dp.put(Constants.AC_msg, "�û������ڣ��޷��������룡");
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
	 * ע��
	 * 
	 * @throws Exception
	 */
	public String doRegister() throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("password");
		if (StringUtil.isEmpty(mobile)) {
			throw new Exception("�ֻ���벻��Ϊ�գ�");
		}

		if (StringUtil.isEmpty(password)) {
			throw new Exception("���벻��Ϊ�գ�");
		}
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			Member bo = (Member) BOFactory.build(MemberBO.class, this.getDBAccessUser());
			MemberVO vo = new MemberVO();
			vo.setMbName(mobile);
			vo.setMbPhone(mobile);
			vo.setMbPassword(password);
			vo.setMbRegisterDate(new Date());

			vo.setMbType(1); // Ĭ����ͨ�û��� �û����ͣ�1��ͨ�û���2�����ߣ�0����Ա
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
	 * ��ѯ��ǰ�û���Ϣ
	 * 
	 * @throws Exception
	 */
	public void doGetUserInfo() throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();
		Member bo = (Member) BOFactory.build(MemberBO.class, this.getDBAccessUser());
		Integer pk = this.getDBAccessUser().getOperid();
		if (pk <= 0) {
			throw new Exception("���ȵ�¼��");
		}
		MemberVO vo = bo.doFindByPk(Integer.valueOf(pk));
		PageUtils.writePage(vo, res, "yyyy-MM-dd HH:mm:ss");
	}

/*	*//**
	 * ��ȡͼ����֤��
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
	 * У����ͼ��֤��
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
			msg = "��֤�벻��ȷ��";
		}
		Map<String, Object> dp = new HashMap<String, Object>();
		dp.put(Constants.AC, Constants.AC_success);
		dp.put("valid", r);
		dp.put("message", msg);
		PageUtils.writePage(dp, res);
	}*/

/*
	*//**
	 * �ж��˺��Ƿ���ڣ��˺Ű����˺�/����/�ֻ�
	 * 
	 * @throws Exception
	 *//*
	public void doAccountExist() throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		String mobile = req.getParameter("mobile");
		if (StringUtil.isEmpty(mobile)) {
			throw new Exception("�˺Ų���Ϊ�գ�");
		}
		Member bo = (Member) BOFactory.build(MemberBO.class, this.getDBAccessUser());
		MemberVO user = bo.getUserByAccount(mobile);
		boolean exist = null != user;

		Map<String, Object> dp = new HashMap<String, Object>();
		dp.put(Constants.AC, Constants.AC_success);
		dp.put("valid", exist);
		dp.put("message", exist ? "" : "�˺�" + mobile + "�����ڣ���˶ԣ�");
		PageUtils.writePage(dp, res);
	}*/

	/**
	 * ��ȡ��ҳ��С��Ϊ��ֹ�����������ݲ�ѯ��ϵͳĬ��һ��ֻ��ѯ10����¼��
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getPageSize() {
		return this.Mobile_PageSize;
	}

	/**
	 * ��ȡ��ѯҳ��
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getPageNo() {
		HttpServletRequest req = ServletActionContext.getRequest();
		String pageno = req.getParameter("pageno");
		if (StringUtil.isEmpty(pageno)) {
			pageno = "1";
		}
		return pageno;
	}
	public String getSignInfo() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		StudentWebParam params = new StudentWebParam();
		params.setQueryAll(true);
		Student bo = (Student) BOFactory.build(StudentBO.class,
				this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		String signcount=String.valueOf(dp.getRowCount());
		String costsum = getSignCostSum();
		Map<String, Object> dt = new HashMap<String, Object>();
		dt.put("count", signcount);
		dt.put("costsum", costsum);
		PageUtils.writePage(dt, response);
		return null;
		
	}
	
	public String getSignCostSum() throws Exception {
		CostlistDBParam params = new CostlistDBParam();
		params.setQueryAll(true);
		Costlist bo = (Costlist) BOFactory.build(CostlistBO.class,
				this.getDBAccessUser());
		CostlistForm dt = ((CostlistBO) bo).doQueryCost(params);
		int costsum=dt.getCostcum();
		return String.valueOf(costsum);
		
	}
	
}
