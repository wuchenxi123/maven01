package com.manage.group.web;

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
import com.manage.group.control.Group;
import com.manage.group.control.GroupBO;
import com.manage.group.persistent.GroupDBParam;
import com.manage.group.persistent.GroupVO;

/**
 * Title: GroupAction
 * @author 
 * @version 1.0
 */
public class GroupAction extends BaseAction{
	
	public GroupAction() {
		super();

		//????????��?����??��?????
		this.setForm(new GroupForm());
		this.setParam(new GroupWebParam());

        //???��VO?��
        setClsVO(GroupVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"groupId"};
		this.setClsControl(Group.class);
		this.setClsQueryParam(GroupDBParam.class) ;

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
		GroupWebParam params = (GroupWebParam) this.getParam();
		Group bo = (Group) BOFactory.build(GroupBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd HH:mm:ss");
		return null;
	}
	public String doShow() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		this.setParam4DataTable();
		GroupWebParam params = (GroupWebParam) this.getParam();
		Group bo = (Group) BOFactory.build(GroupBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		List<GroupVO> al=dp.getDatas();
		PageUtils.writePage(dp, response);
		map.put("datas",al);
		return null;
	}
}