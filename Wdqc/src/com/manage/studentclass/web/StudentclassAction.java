package com.manage.studentclass.web;

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

import com.manage.studentclass.persistent.StudentclassVO ;
import com.core.jop.common.utils.bean.BeanUtils;
import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.ui.struts2.BaseAction ;
import com.core.sys.util.PageUtils;
import com.core.sys.util.object.DataTablePage;
import com.manage.studentclass.control.Studentclass ;
import com.manage.studentclass.control.StudentclassBO;
import com.util.Constants;

/**
 * Title: StudentclassAction
 * @author Hujj
 * @version 1.0
 */
public class StudentclassAction extends BaseAction{
	private static final long serialVersionUID = -5478057802776844675L;
	private final Log log = LogFactory.getLog(StudentclassAction.class);
	public StudentclassAction() {
		super();

		//????????��?����??��?????
		this.setForm(new StudentclassForm());
		this.setParam(new StudentclassWebParam());

        //???��VO?��
        setClsVO(StudentclassVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"scId"};
		this.setClsControl(Studentclass.class);

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
		StudentclassWebParam params = (StudentclassWebParam) this.getParam();
		Studentclass bo = (Studentclass) BOFactory.build(StudentclassBO.class, this.getDBAccessUser());
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
		StudentclassWebParam params = (StudentclassWebParam) this.getParam();
		Studentclass bo = (Studentclass) BOFactory.build(StudentclassBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		PageUtils.writePage(dp, response, "yyyy-MM-dd");
		return null;
	}
	/**
	 * 保存
	 */

	public String doSave() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			StudentclassForm form = (StudentclassForm) getForm();
			StudentclassVO vo = new StudentclassVO();
			BeanUtils.copyProperties(vo, form);
			Studentclass bo = (Studentclass) BOFactory.build(StudentclassBO.class, this.getDBAccessUser());
			if (null == vo.getScId()) {
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
		StudentclassWebParam params = (StudentclassWebParam) this.getParam();
		Studentclass bo = (Studentclass) BOFactory.build(StudentclassBO.class, this.getDBAccessUser());
		StudentclassVO form = bo.doFindByPk(Integer.valueOf(params.get_pk()));
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
			Studentclass bo = (Studentclass) BOFactory.build(StudentclassBO.class, this.getDBAccessUser());
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