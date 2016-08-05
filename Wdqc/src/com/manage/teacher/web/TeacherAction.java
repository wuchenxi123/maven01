package com.manage.teacher.web;

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
import com.manage.gradlass.control.Gradlass;
import com.manage.gradlass.control.GradlassBO;
import com.manage.gradlass.persistent.GradlassVO;
import com.manage.gradlass.web.GradlassWebParam;
import com.manage.gradlassTeacher.control.GradlassTeacher;
import com.manage.gradlassTeacher.control.GradlassTeacherBO;
import com.manage.gradlassTeacher.persistent.GradlassTeacherVO;
import com.manage.gradlassTeacher.web.GradlassTeacherWebParam;
import com.manage.teacher.control.Teacher;
import com.manage.teacher.control.TeacherBO;
import com.manage.teacher.persistent.TeacherVO;
import com.util.Constants;

/**
 * Title: TeacherAction
 * @author 
 * @version 1.0
 */
public class TeacherAction extends BaseAction{
	private final Log log = LogFactory.getLog(TeacherAction.class);
	public TeacherAction() {
		super();

		//????????��?����??��?????
		this.setForm(new TeacherForm());
		this.setParam(new TeacherWebParam());

        //???��VO?��
        setClsVO(TeacherVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"teId"};
		this.setClsControl(Teacher.class);

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
		Map<String, Object> map = new HashMap<String, Object>();
		TeacherWebParam params = (TeacherWebParam) this.getParam();
		Teacher bo = (Teacher) BOFactory.build(TeacherBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		List<TeacherVO> al=dp.getDatas();
		map.put("datas",al);
		PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd");
		return null;
	}
	/**
	 * 查询
	 */
	public String doListGradlass() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		this.setParam4DataTable();
		Map<String, Object> map = new HashMap<String, Object>();
		TeacherWebParam params = (TeacherWebParam) this.getParam();
		Teacher bo = (Teacher) BOFactory.build(TeacherBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		List<TeacherVO> al=dp.getDatas();
		map.put("datas",al);
		List<GradlassVO> algrad=al.get(0).getGradlassList();
		if(algrad!=null&&algrad.size()>0){
			dp.setDatas(algrad);
		}else{
			dp.setDatas(null);
		}
		PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd");
		return null;
	}
	public String doShow() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		this.setParam4DataTable();
		TeacherWebParam params = (TeacherWebParam) this.getParam();
		Teacher bo = (Teacher) BOFactory.build(TeacherBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		List<TeacherVO> al=dp.getDatas();
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
			TeacherForm form = (TeacherForm) getForm();
			TeacherVO vo = new TeacherVO();
			BeanUtils.copyProperties(vo, form);
			Teacher bo = (Teacher) BOFactory.build(TeacherBO.class, this.getDBAccessUser());
			vo.setUpdatedate(new Date());
			if (null == vo.getTeId()) {
				/*vo.setCreator(this.getDBAccessUser().getOperid());*/
				vo = bo.doCreate(vo);
				vo.setGradlassteacher(vo.getTeId());
				vo = bo.doUpdate(vo);
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
		TeacherWebParam params = (TeacherWebParam) this.getParam();
		Teacher bo = (Teacher) BOFactory.build(TeacherBO.class, this.getDBAccessUser());
		TeacherVO form = bo.doFindByPk(Integer.valueOf(params.get_pk()));
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
			Teacher bo = (Teacher) BOFactory.build(TeacherBO.class, this.getDBAccessUser());
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