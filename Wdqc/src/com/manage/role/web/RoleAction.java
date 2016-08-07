package com.manage.role.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.ui.struts2.BaseAction;
import com.core.sys.util.PageUtils;
import com.core.sys.util.object.DataTablePage;
import com.manage.role.control.Role;
import com.manage.role.control.RoleBO;
import com.manage.role.persistent.RoleDBParam;
import com.manage.role.persistent.RoleVO;

/**
 * Title: RoleAction
 * @author chenlei
 * @version 1.0
 */
public class RoleAction extends BaseAction{
	
	public RoleAction() {
		super();

		//????????��?����??��?????
		this.setForm(new RoleForm());
		this.setParam(new RoleWebParam());

        //???��VO?��
        setClsVO(RoleVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"roleId"};
		this.setClsControl(Role.class);
		this.setClsQueryParam(RoleDBParam.class) ;

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
		RoleWebParam params = (RoleWebParam) this.getParam();
		Role bo = (Role) BOFactory.build(RoleBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd HH:mm:ss");
		return null;
	}
	public String doShow() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		this.setParam4DataTable();
		RoleWebParam params = (RoleWebParam) this.getParam();
		Role bo = (Role) BOFactory.build(RoleBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		List<RoleVO> al=dp.getDatas();
		PageUtils.writePage(dp, response);
		map.put("datas",al);
		return null;
	}
}