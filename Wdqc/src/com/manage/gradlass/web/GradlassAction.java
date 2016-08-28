package com.manage.gradlass.web;

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
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.ui.struts2.BaseAction;
import com.core.sys.util.PageUtils;
import com.core.sys.util.object.DataTablePage;
import com.manage.gradlass.control.Gradlass;
import com.manage.gradlass.control.GradlassBO;
import com.manage.gradlass.persistent.GradlassDAO;
import com.manage.gradlass.persistent.GradlassVO;
import com.manage.student.persistent.StudentVO;
import com.util.Constants;

/**
 * Title: GradlassAction
 * @author Hujj
 * @version 1.0
 */
public class GradlassAction extends BaseAction{
	/**
	 * 班级管理模块---
	 */
	private static final long serialVersionUID = -186254440537726608L;
	private final Log log = LogFactory.getLog(GradlassAction.class);
	public GradlassAction() {
		super();

		//????????��?����??��?????
		this.setForm(new GradlassForm());
		this.setParam(new GradlassWebParam());

        //???��VO?��
        setClsVO(GradlassVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"csId"};
		this.setClsControl(Gradlass.class);
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
		GradlassWebParam params = (GradlassWebParam) this.getParam();
		Gradlass bo = (Gradlass) BOFactory.build(GradlassBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		List<GradlassVO> al=dp.getDatas();
		map.put("datas",al);
		PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd HH:mm:ss");
		return null;
	}
	public String doListStudent() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		this.setParam4DataTable();
		Map<String, Object> map = new HashMap<String, Object>();
		GradlassWebParam params = (GradlassWebParam) this.getParam();
		Gradlass bo = (Gradlass) BOFactory.build(GradlassBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		List<GradlassVO> al=dp.getDatas();
		map.put("datas",al);
		List<StudentVO> algrad=al.get(0).getStudentList();
		if(algrad!=null&&algrad.size()>0){
			dp.setDatas(algrad);
		}else{
			dp.setDatas(null);
		}
		PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd");
		return null;
	}
	

	public String doSave() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			GradlassForm form = (GradlassForm) getForm();
			GradlassVO vo = new GradlassVO();
			form.getCsOpendatestart();
			BeanUtils.copyProperties(vo, form);
			Gradlass bo = (Gradlass) BOFactory.build(GradlassBO.class, this.getDBAccessUser());
			if (null == vo.getCsId()) {
				vo.setCsPeopleremain(vo.getCsPeoplecount());
				vo.setCreateTime(new Date());
				vo=bo.doCreate(vo);
			}else{
				vo.setUpdateTime(new Date());
				vo=bo.doUpdate(vo,2);
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
		GradlassWebParam params = (GradlassWebParam) this.getParam();
		Gradlass bo = (Gradlass) BOFactory.build(GradlassBO.class, this.getDBAccessUser());
		GradlassVO form = bo.doFindByPk(Long.valueOf(params.get_pk()));
		params.set_ne_csId(params.get_pk());
		DataPackage dp = bo.doQuery(params);
		List<GradlassVO> al=dp.getDatas();	
		if(al!=null&&al.size()>0){
			form.setTeaList(al.get(0).getTeaList());
			form.setCoName(al.get(0).getCoName());
			form.setTimeFrame(al.get(0).getCsWeekend()+" "+al.get(0).getCsDateStartHour()+":"+al.get(0).getCsDateStartMinute()
					+"--"+al.get(0).getCsDateEndHour()+":"+al.get(0).getCsDateEndMinute());
			form.setCpName(al.get(0).getCpName());
			form.setCrName(al.get(0).getCrName());
			form.setCsPeopleremain((short)al.get(0).getStudentList().size());
		}
		PageUtils.writePage(form, response, "yyyy-MM-dd");
		return null;
	}
	
	/**
	 * 更新班人数,减小余量
	 */
	public String doUpdateRemain() throws Exception {
		Map<String, Object> dp = new HashMap<String, Object>();
		GradlassWebParam params = (GradlassWebParam) this.getParam();
		Gradlass bo = (Gradlass) BOFactory.build(GradlassBO.class, this.getDBAccessUser());
		GradlassVO vo = bo.doFindByPk(Long.valueOf(params.get_pk()));
		short remain=vo.getCsPeopleremain();
		if(remain>0){
			remain--;
			vo.setUpdateTime(new Date());
			vo.setCsPeopleremain(Short.valueOf(remain));
			}else{
				System.out.println("人数已满");
			}
		
		
		vo=((GradlassBO) bo).doUpdateNew(vo);
		dp.put(Constants.AC, Constants.AC_success);
		dp.put(Constants.AC_msg, "");
		dp.put("datas", vo);
		return null;
	}
	/**
	 * 更新班人数,增加余量
	 */
	public String doUpdateRemainadd() throws Exception {
		Map<String, Object> dp = new HashMap<String, Object>();
		GradlassWebParam params = (GradlassWebParam) this.getParam();
		Gradlass bo = (Gradlass) BOFactory.build(GradlassBO.class, this.getDBAccessUser());
		GradlassVO vo = bo.doFindByPk(Long.valueOf(params.get_pk()));
		short remain=vo.getCsPeopleremain();
		if(remain<vo.getCsPeoplecount()){
			remain++;
			vo.setUpdateTime(new Date());
			vo.setCsPeopleremain(Short.valueOf(remain));
			}else{
				System.out.println("人数已满");
			}	
		vo=((GradlassBO) bo).doUpdateNew(vo);
		dp.put(Constants.AC, Constants.AC_success);
		dp.put(Constants.AC_msg, "");
		dp.put("datas", vo);
		return null;
	}
	
	/**
	 * 下线
	 */
	public String doGetOffLine() throws Exception {
		Map<String, Object> dp = new HashMap<String, Object>();
		GradlassWebParam params = (GradlassWebParam) this.getParam();
		Gradlass bo = (Gradlass) BOFactory.build(GradlassBO.class, this.getDBAccessUser());
		GradlassVO vo = bo.doFindByPk(Long.valueOf(params.get_pk()));
		int flag=Integer.parseInt(params.get_flag());
		if(flag==0){
			vo.setCsStatus(-1);
		}else{
			vo.setCsStatus(0);
		}
		vo=((GradlassBO) bo).doUpdateNew(vo);
		dp.put(Constants.AC, Constants.AC_success);
		dp.put(Constants.AC_msg, "");
		dp.put("datas", vo);
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
			Gradlass bo = (Gradlass) BOFactory.build(GradlassBO.class, this.getDBAccessUser());
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
	
	public String doStatisticsIncome() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		GradlassWebParam params = (GradlassWebParam) this.getParam();
		Gradlass bo = (Gradlass) BOFactory.build(GradlassBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuerySumIncome(params);
		List<GradlassVO> al=dp.getDatas();
		map.put("datas",al);
		PageUtils.writePage(dp, response);
		return null;
	}
	public String doGetExport() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		GradlassWebParam params = (GradlassWebParam) this.getParam();
		Gradlass bo = (Gradlass) BOFactory.build(GradlassBO.class,
				this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		GradlassDAO dao = (GradlassDAO) DAOFactory.build(GradlassDAO.class, this.getDBAccessUser());
		dao.extport(dp);
		return null;		
	}
}