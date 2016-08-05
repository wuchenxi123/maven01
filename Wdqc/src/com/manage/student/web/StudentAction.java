package com.manage.student.web;

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
import org.apache.xmlbeans.impl.jam.internal.parser.ParamStructPool;

import com.manage.student.persistent.StudentVO;
import com.core.jop.common.utils.bean.BeanUtils;
import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.ui.struts2.BaseAction;
import com.core.sys.util.PageUtils;
import com.core.sys.util.object.DataTablePage;
import com.manage.student.control.Student;
import com.manage.student.control.StudentBO;
import com.util.Constants;

/**
 * Title: StudentAction
 * 
 * @author Hujj
 * @version 1.0
 */
public class StudentAction extends BaseAction {
	private static final long serialVersionUID = -5478057802776844675L;
	private final Log log = LogFactory.getLog(StudentAction.class);

	public StudentAction() {
		super();

		// ????????��?����??��?????
		this.setForm(new StudentForm());
		this.setParam(new StudentWebParam());

		// ???��VO?��
		setClsVO(StudentVO.class);
		// ???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
		this.pkNameArray = new String[] { "stId" };
		this.setClsControl(Student.class);

		/**
		 * ???????��??????????????????BaseAction??CRUD???��?��?????��??Delegate?
		 * ???��??��??????��????�� this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * 查询
	 */
	public String doList() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		this.setParam4DataTable();
		StudentWebParam params = (StudentWebParam) this.getParam();
		Student bo = (Student) BOFactory.build(StudentBO.class,
				this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		PageUtils.writePage(new DataTablePage(dp), response,
				"yyyy-MM-dd");
		return null;
	}

	/**
	 * 保存
	 */

	public String doSave() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			StudentForm form = (StudentForm) getForm();
			StudentVO vo = new StudentVO();
			BeanUtils.copyProperties(vo, form);
			Student bo = (Student) BOFactory.build(StudentBO.class,
					this.getDBAccessUser());
			if (null == vo.getStId()) {
				/* vo.setCreator(this.getDBAccessUser().getOperid()); */
				vo.setCreateTime(new Date());
				vo = bo.doCreate(vo);
			} else {
				/*vo.setUpdator(this.getDBAccessUser().getOperid());*/
				/*vo.setCltId(null);*/
				vo.setUpdateTime(new Date());
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
	 * 保存
	 */

	public String doUpdate() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			StudentWebParam params = (StudentWebParam) this.getParam();
			Student bo = (Student) BOFactory.build(StudentBO.class,
					this.getDBAccessUser());
			StudentVO form = bo.doFindByPk(Long.valueOf(params.get_pk()));
			StudentVO vo = new StudentVO();
			BeanUtils.copyProperties(vo, form);
			vo.setUpdator(this.getDBAccessUser().getOperid());
			System.out.println(vo.getStStatus());
			if(vo.getStStatus().equals("0")){
				vo.setStStatus("1");
			}else{
				vo.setStStatus("0");
			}
			
			vo.setUpdateTime(new Date());
			vo = bo.doUpdate(vo);
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
		StudentWebParam params = (StudentWebParam) this.getParam();
		Student bo = (Student) BOFactory.build(StudentBO.class,
				this.getDBAccessUser());
		StudentVO form = bo.doFindByPk(Long.valueOf(params.get_pk()));
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
			Student bo = (Student) BOFactory.build(StudentBO.class,
					this.getDBAccessUser());
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