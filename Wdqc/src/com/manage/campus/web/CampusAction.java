package com.manage.campus.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.manage.campus.persistent.CampusVO ;
import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.ui.struts2.BaseAction ;
import com.core.sys.util.PageUtils;
import com.core.sys.util.object.DataTablePage;
import com.manage.campus.control.Campus ;
import com.manage.campus.control.CampusBO;
import com.manage.teacher.control.Teacher;
import com.manage.teacher.control.TeacherBO;
import com.manage.teacher.web.TeacherWebParam;

/**
 * Title: CampusAction
 * @author Hujj
 * @version 1.0
 */
public class CampusAction extends BaseAction{
	
	public CampusAction() {
		super();

		//????????��?����??��?????
		this.setForm(new CampusForm());
		this.setParam(new CampusWebParam());

        //???��VO?��
        setClsVO(CampusVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"cpId"};
		this.setClsControl(Campus.class);

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
		CampusWebParam params = (CampusWebParam) this.getParam();
		Campus bo = (Campus) BOFactory.build(CampusBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd HH:mm:ss");
		return null;
	}
	
	public String doShow() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		this.setParam4DataTable();
		CampusWebParam params = (CampusWebParam) this.getParam();
		Campus bo = (Campus) BOFactory.build(CampusBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		List<CampusVO> al=dp.getDatas();
		PageUtils.writePage(dp, response);
		map.put("datas",al);
		return null;
	}
}