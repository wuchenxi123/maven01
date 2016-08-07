package com.manage.member.web;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.core.jop.common.utils.bean.BeanUtils;
import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.ui.struts2.BaseAction;
import com.core.sys.util.PageUtils;
import com.core.sys.util.object.DataTablePage;
import com.manage.member.control.Member;
import com.manage.member.control.MemberBO;
import com.manage.member.persistent.MemberVO;
import com.opensymphony.xwork2.ActionContext;
import com.util.Constants;
import com.util.StringUtil;
import com.util.SysUtils;


/**
 * Title: MemberAction
 * @author Hujj
 * @version 1.0
 */
public class MemberAction extends BaseAction{
	private static final long serialVersionUID = -5478057802776844675L;
	private final Log log = LogFactory.getLog(MemberAction.class);
	public MemberAction() {
		super();

		//????????��?����??��?????
		this.setForm(new MemberForm());
		this.setParam(new MemberWebParam());

        //???��VO?��
        setClsVO(MemberVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"mbId"};
		this.setClsControl(Member.class);

		/**
		 * ???????��??????????????????BaseAction??CRUD???��?��?????��??Delegate????��??��??????��????��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	/**
	 * 查询
	 */
	public String doList() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String dt = request.getParameter(DataTablePage.DT);
		dt = null == dt ? "" : dt;
		this.setParam4DataTable();
		MemberWebParam params = (MemberWebParam) this.getParam();
		Member bo = (Member) BOFactory.build(MemberBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);

		if (dt.equals(DataTablePage.ResultPage)) {
			this.setDp(dp);
			return "list";
		} else {
			PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd HH:mm:ss");
		}
		return null;
	}
	/**
	 * 保存
	 */

	public String doSave() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			MemberForm form = (MemberForm) getForm();
			MemberVO vo = new MemberVO();
			BeanUtils.copyProperties(vo, form);
			Member bo = (Member) BOFactory.build(MemberBO.class, this.getDBAccessUser());
			if (null == vo.getMbId()) {
				/*vo.setCreator(this.getDBAccessUser().getOperid());*/
				vo.setMbRegisterDate(new Date());
				vo = bo.doCreate(vo);
			} else {
				vo = bo.doUpdate(vo);
			}
			dp.put(Constants.AC, Constants.AC_success);
			dp.put(Constants.AC_msg, "");
			dp.put("datas", vo);
		} catch (Exception e) {
			dp.put(Constants.AC, Constants.AC_fail);
			dp.put(Constants.AC_msg, e.getMessage());
			log.error(e);
		}
		PageUtils.writePage(dp, response);
		return null;
	}
	/**
	 * 编辑
	 */
	public String doEdit() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		MemberWebParam params = (MemberWebParam) this.getParam();
		Member bo = (Member) BOFactory.build(MemberBO.class, this.getDBAccessUser());
		MemberVO form = bo.doFindByPk(Integer.valueOf(params.get_pk()));
		PageUtils.writePage(form, response, "yyyy-MM-dd HH:mm:ss");
		return null;
	}

	/**
	 * 删除
	 */
	public String doDel() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			String ids = request.getParameter("ids");
			Member bo = (Member) BOFactory.build(MemberBO.class, this.getDBAccessUser());
			List<String> list = Arrays.asList(ids.split(","));
			bo.doDel(list);
			dp.put(Constants.AC, Constants.AC_success);
			dp.put(Constants.AC_msg, "");
		} catch (Exception e) {
			dp.put(Constants.AC, Constants.AC_fail);
			dp.put(Constants.AC_msg, e.getMessage());
			log.error(e);
		}
		PageUtils.writePage(dp, response);
		return null;
	}
	/**
	 * 登入
	 * 
	 * @throws Exception
	 */
	public void doLogin() throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		MemberWebParam params = (MemberWebParam) this.getParam();
		System.out.println(params.get_se_mbPassword());
		Map<String, Object> dp = new HashMap<String, Object>();

		if (StringUtil.isEmpty(params.get_se_mbName())) {
			throw new Exception("账号不能为空！");
		}

		if (StringUtil.isEmpty(params.get_se_mbPassword())) {
			throw new Exception("密码不能为空！");
		}


		// 校验用户名或手机号码或邮箱
		Member bo = (Member) BOFactory.build(MemberBO.class, this.getDBAccessUser());
		boolean exist = false;
		MemberWebParam p = new MemberWebParam();
		p.set_se_mbName(params.get_se_mbName());
		p.set_se_mbPassword(params.get_se_mbPassword());
		List<?> user = bo.doQuery(p).getDatas();
		exist = user.size() > 0;

		if (!exist) {
			p = new MemberWebParam();
			p.set_se_mbPhone(params.get_se_mbName());
			p.set_se_mbPassword(params.get_se_mbPassword());
			user = bo.doQuery(p).getDatas();
			exist = user.size() > 0;
		}

		if (!exist) {
			p = new MemberWebParam();
			p.set_se_mbEmail(params.get_se_mbName());
			p.set_se_mbPassword(params.get_se_mbPassword());
			user = bo.doQuery(p).getDatas();
			exist = user.size() > 0;
		}

		if (!exist) {
			dp.put(Constants.AC, Constants.AC_fail);
			dp.put(Constants.AC_msg, "登入账号或密码不正确！");
			PageUtils.writePage(dp, res);
			return;
		} else {
			MemberVO u = (MemberVO) user.get(0);

			SysUtils.setSession(u);
			dp.put(Constants.AC, Constants.AC_success);
			dp.put(Constants.AC_msg, "");
			PageUtils.writePage(dp, res);
			return;
		}

	}

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
		
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		req.getSession().invalidate();
		Cookie cookie = new Cookie("JSESSIONID","-1");
		res.addCookie(cookie);
		
		boolean guest = "true".equals(req.getParameter("guest"));
		if (guest) {
			Map<String, Object> dp = new HashMap<String, Object>();
			dp.put(Constants.AC, Constants.AC_success);
			dp.put(Constants.AC_msg, "");
			PageUtils.writePage(dp, res);
			return null;
		}
		return "logout";
	}

	/**
	 * 修改当前用户密码
	 * 
	 * @return
	 * @throws Exception
	 */
	public void doChangePwd() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			MemberForm form = (MemberForm) getForm();
			Member bo = (Member) BOFactory.build(MemberBO.class, this.getDBAccessUser());
			MemberVO vo = bo.doFindByPk(this.getDBAccessUser().getOperid());
			vo.setMbPassword(form.getMbPassword());
			bo.doUpdate(vo);
			dp.put(Constants.AC, Constants.AC_success);
			dp.put(Constants.AC_msg, "");
		} catch (Exception e) {
			dp.put(Constants.AC, Constants.AC_fail);
			dp.put(Constants.AC_msg, e.getMessage());
			log.error(e);
		}
		PageUtils.writePage(dp, response);
	}
}