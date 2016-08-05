package com.manage.coursegroup.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.ui.struts2.BaseAction;
import com.core.sys.util.PageUtils;
import com.manage.course.control.Course;
import com.manage.course.control.CourseBO;
import com.manage.course.persistent.CourseVO;
import com.manage.course.web.CourseWebParam;
import com.manage.coursegroup.control.CourseGroup;
import com.manage.coursegroup.persistent.CourseGroupDBParam;
import com.manage.coursegroup.persistent.CourseGroupVO;

/**
 * Title: courseGroupAction
 * @author 
 * @version 1.0
 */
public class CourseGroupAction extends BaseAction{
	
	public CourseGroupAction() {
		super();

		//????????��?����??��?????
		this.setForm(new CourseGroupForm());
		this.setParam(new CourseGroupWebParam());

        //???��VO?��
        setClsVO(CourseGroupVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"cgpId"};
		this.setClsControl(CourseGroup.class);
		this.setClsQueryParam(CourseGroupDBParam.class) ;

		/**
		 * ???????��??????????????????BaseAction??CRUD???��?��?????��??Delegate????��??��??????��????��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
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
}