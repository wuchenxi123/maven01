package com.manage.classroom.web;

import java.util.Arrays;
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
import com.manage.classroom.control.Classroom;
import com.manage.classroom.control.ClassroomBO;
import com.manage.classroom.persistent.ClassroomVO;
import com.util.Constants;

/**
 * Title: ClassroomAction
 * @author Hujj
 * @version 1.0
 */
public class ClassroomAction extends BaseAction{
	private final Log log = LogFactory.getLog(AdvisoryAction.class);
	public ClassroomAction() {
		super();

		//????????��?����??��?????
		this.setForm(new ClassroomForm());
		this.setParam(new ClassroomWebParam());

        //???��VO?��
        setClsVO(ClassroomVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"crId"};
		this.setClsControl(Classroom.class);

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
		ClassroomWebParam params = (ClassroomWebParam) this.getParam();
		Classroom bo = (Classroom) BOFactory.build(ClassroomBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd HH:mm:ss");
		return null;
	}
	public String doShow() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		this.setParam4DataTable();
		ClassroomWebParam params = (ClassroomWebParam) this.getParam();
		Classroom bo = (Classroom) BOFactory.build(ClassroomBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		List<ClassroomVO> al=dp.getDatas();
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
			ClassroomForm form = (ClassroomForm) getForm();
			ClassroomVO vo = new ClassroomVO();
			BeanUtils.copyProperties(vo, form);
			Classroom bo = (Classroom) BOFactory.build(ClassroomBO.class, this.getDBAccessUser());
			if (null == vo.getCrId()) {
				/*vo.setCreator(this.getDBAccessUser().getOperid());*/
//				vo.setCreateTime(new Date());
				vo = bo.doCreate(vo);
			} else {
//				vo.setUpdator(this.getDBAccessUser().getOperid());
//				vo.setUpdateTime(new Date());
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
		ClassroomWebParam params = (ClassroomWebParam) this.getParam();
		Classroom bo = (Classroom) BOFactory.build(ClassroomBO.class, this.getDBAccessUser());
		ClassroomVO form = bo.doFindByPk(Long.valueOf(params.get_pk()));
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
			Classroom bo = (Classroom) BOFactory.build(ClassroomBO.class, this.getDBAccessUser());
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