package com.manage.gradlassTeacher.web;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.manage.advisory.web.AdvisoryAction;
import com.manage.gradlassTeacher.control.GradlassTeacher;
import com.manage.gradlassTeacher.control.GradlassTeacherBO;
import com.manage.gradlassTeacher.persistent.GradlassTeacherDBParam;
import com.manage.gradlassTeacher.persistent.GradlassTeacherVO;
import com.util.Constants;

/**
 * Title: GradlassTeacherAction
 * @author 
 * @version 1.0
 */
public class GradlassTeacherAction extends BaseAction{
	private static final long serialVersionUID = -5478057802776844675L;
	private final Log log = LogFactory.getLog(GradlassTeacherAction.class);
	public GradlassTeacherAction() {
		super();

		//????????��?����??��?????
		this.setForm(new GradlassTeacherForm());
		this.setParam(new GradlassTeacherWebParam());

        //???��VO?��
        setClsVO(GradlassTeacherVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"ctId"};
		this.setClsControl(GradlassTeacher.class);
		this.setClsQueryParam(GradlassTeacherDBParam.class) ;

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
		this.setParam4DataTable();
		GradlassTeacherWebParam params = (GradlassTeacherWebParam) this.getParam();
		GradlassTeacher bo = (GradlassTeacher) BOFactory.build(GradlassTeacherBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd HH:mm:ss");
		return null;
	}
	/**
	 * 查询
	 */
	public String doShow() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		this.setParam4DataTable();
		GradlassTeacherWebParam params = (GradlassTeacherWebParam) this.getParam();
		GradlassTeacher bo = (GradlassTeacher) BOFactory.build(GradlassTeacherBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		PageUtils.writePage(dp, response, "yyyy-MM-dd HH:mm:ss");
		return null;
	}
	/**
	 * 保存
	 */

	public String doSave() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			GradlassTeacherForm form = (GradlassTeacherForm) getForm();
			GradlassTeacherVO vo = new GradlassTeacherVO();
			BeanUtils.copyProperties(vo, form);
			GradlassTeacher bo = (GradlassTeacher) BOFactory.build(GradlassTeacherBO.class, this.getDBAccessUser());
			if (null == vo.getCtId()) {		
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
		GradlassTeacherWebParam params = (GradlassTeacherWebParam) this.getParam();
		GradlassTeacher bo = (GradlassTeacher) BOFactory.build(GradlassTeacherBO.class, this.getDBAccessUser());
		GradlassTeacherVO form = bo.doFindByPk(Integer.valueOf(params.get_pk()));
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
			GradlassTeacher bo = (GradlassTeacher) BOFactory.build(GradlassTeacherBO.class, this.getDBAccessUser());
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
}