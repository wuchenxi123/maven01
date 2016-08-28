package com.manage.course.web;

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
import com.manage.course.control.Course;
import com.manage.course.control.CourseBO;
import com.manage.course.persistent.CourseVO;
import com.util.Constants;

/**
 * Title: CourseAction
 * @author Hujj
 * @version 1.0
 */
public class CourseAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8639990112649682482L;
	private final Log log = LogFactory.getLog(AdvisoryAction.class);
	public CourseAction() {
		super();

		//????????��?����??��?????
		this.setForm(new CourseForm());
		this.setParam(new CourseWebParam());

        //???��VO?��
        setClsVO(CourseVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"coId"};
		this.setClsControl(Course.class);

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
		CourseWebParam params = (CourseWebParam) this.getParam();
		Course bo = (Course) BOFactory.build(CourseBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd HH:mm:ss");
		return null;
	}
	public String doShow() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		this.setParam4DataTable();
		CourseWebParam params = (CourseWebParam) this.getParam();
		Course bo = (Course) BOFactory.build(CourseBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		List<CourseVO> al=dp.getDatas();
		PageUtils.writePage(dp, response);
		map.put("datas",al);
		return null;
	}
	public String doShowClassify() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		this.setParam4DataTable();
		CourseWebParam params = (CourseWebParam) this.getParam();
		params.set_ne_coId(params.get_ne_coId());
		Course bo = (Course) BOFactory.build(CourseBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		List<CourseVO> al=dp.getDatas();
		PageUtils.writePage(dp, response);
		map.put("datas",al);
		return null;
	}
	
	/**
	 * 保存
	 */

	public String doSave() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			CourseForm form = (CourseForm) getForm();
			CourseVO vo = new CourseVO();
			BeanUtils.copyProperties(vo, form);
			Course bo = (Course) BOFactory.build(CourseBO.class, this.getDBAccessUser());
			if (null == vo.getCoId()) {
				vo.setCreator(1/*this.getDBAccessUser().getOperid()*/);
				vo.setCreatetime(new Date());
				vo = bo.doCreate(vo);
			} else {
				vo.setUpdator(this.getDBAccessUser().getOperid());
				vo.setUpdatetime(new Date());
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
		CourseWebParam params = (CourseWebParam) this.getParam();
		Course bo = (Course) BOFactory.build(CourseBO.class, this.getDBAccessUser());
		CourseVO form = bo.doFindByPk(Integer.valueOf(params.get_pk()));
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
			Course bo = (Course) BOFactory.build(CourseBO.class, this.getDBAccessUser());
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