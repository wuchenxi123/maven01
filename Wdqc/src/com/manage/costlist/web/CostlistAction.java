package com.manage.costlist.web;

import java.util.ArrayList;
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

import com.manage.costlist.persistent.CostlistVO ;
import com.core.jop.common.utils.bean.BeanUtils;
import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.ui.struts2.BaseAction ;
import com.core.sys.util.PageUtils;
import com.core.sys.util.object.DataTablePage;
import com.manage.costlist.control.Costlist ;
import com.manage.costlist.control.CostlistBO;
import com.util.Constants;

/**
 * Title: CostlistAction
 * @author Hujj
 * @version 1.0
 */
public class CostlistAction extends BaseAction{
	private static final long serialVersionUID = -5478057802776844675L;
	private final Log log = LogFactory.getLog(CostlistAction.class);
	public CostlistAction() {
		super();

		//????????��?����??��?????
		this.setForm(new CostlistForm());
		this.setParam(new CostlistWebParam());

        //???��VO?��
        setClsVO(CostlistVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"cltId"};
		this.setClsControl(Costlist.class);

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
		CostlistWebParam params = (CostlistWebParam) this.getParam();
		Costlist bo = (Costlist) BOFactory.build(CostlistBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd");
		return null;
	}
	
	/**
	 * 查询
	 */
	public String doShow() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		this.setParam4DataTable();
		CostlistWebParam params = (CostlistWebParam) this.getParam();
		Costlist bo = (Costlist) BOFactory.build(CostlistBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		PageUtils.writePage(dp, response, "yyyy-MM-dd");
		return null;
	}
	
	/**
	 * 获取报名学员收入总账
	 */
	public String doGetCostSum() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		this.setParam4DataTable();
		CostlistWebParam params = (CostlistWebParam) this.getParam();
		Costlist bo = (Costlist) BOFactory.build(CostlistBO.class, this.getDBAccessUser());
		params.setQueryAll(true);
		CostlistForm form=((CostlistBO) bo).doQueryCost(params);
		PageUtils.writePage(form, response, "yyyy-MM-dd");
		return null;
	}
	
	/**
	 * 保存
	 */

	public String doSave() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			CostlistForm form = (CostlistForm) getForm();
			CostlistVO vo = new CostlistVO();
			BeanUtils.copyProperties(vo, form);
			Costlist bo = (Costlist) BOFactory.build(CostlistBO.class, this.getDBAccessUser());
			if (null == vo.getCltId()) {
				/*vo.setCreator(this.getDBAccessUser().getOperid());*/
				vo.setCreateTime(new Date());
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
		CostlistWebParam params = (CostlistWebParam) this.getParam();
		Costlist bo = (Costlist) BOFactory.build(CostlistBO.class, this.getDBAccessUser());
		CostlistVO form = bo.doFindByPk(Integer.valueOf(params.get_pk()));
		PageUtils.writePage(form, response, "yyyy-MM-dd");
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
			Costlist bo = (Costlist) BOFactory.build(CostlistBO.class, this.getDBAccessUser());
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