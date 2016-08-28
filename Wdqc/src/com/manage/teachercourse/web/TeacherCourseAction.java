package com.manage.teachercourse.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.ui.struts2.BaseAction;
import com.core.sys.util.PageUtils;
import com.core.sys.util.object.DataTablePage;
import com.manage.teachercourse.control.TeacherCourse;
import com.manage.teachercourse.control.TeacherCourseBO;
import com.manage.teachercourse.persistent.TeacherCourseDBParam;
import com.manage.teachercourse.persistent.TeacherCourseVO;
import com.util.Constants;


/**
 * Title: TeacherCourseAction
 * @author 
 * @version 1.0
 */
public class TeacherCourseAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2825105569022220380L;
	private final Log log = LogFactory.getLog(TeacherCourseAction.class);
	public TeacherCourseAction() {
		super();

		//????????��?����??��?????
		this.setForm(new TeacherCourseForm());
		this.setParam(new TeacherCourseWebParam());

        //???��VO?��
        setClsVO(TeacherCourseVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"tcId"};
		this.setClsControl(TeacherCourse.class);
		this.setClsQueryParam(TeacherCourseDBParam.class) ;

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
		TeacherCourseWebParam params = (TeacherCourseWebParam) this.getParam();
		TeacherCourse bo = (TeacherCourse) BOFactory.build(TeacherCourseBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd HH:mm:ss");
		return null;
	}
	
	public String doShow() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		this.setParam4DataTable();
		TeacherCourseWebParam params = (TeacherCourseWebParam) this.getParam();
		TeacherCourse bo = (TeacherCourse) BOFactory.build(TeacherCourseBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		List<TeacherCourseVO> al=dp.getDatas();
		PageUtils.writePage(dp, response);
		map.put("datas",al);
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
			TeacherCourse bo = (TeacherCourse) BOFactory.build(TeacherCourseBO.class, this.getDBAccessUser());
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