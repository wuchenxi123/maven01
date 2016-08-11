package com.manage.advisory.web;

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

import com.manage.advisory.persistent.AdvisoryVO ;
import com.core.jop.common.utils.bean.BeanUtils;
import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.core.jop.ui.struts2.BaseAction ;
import com.core.sys.util.PageUtils;
import com.core.sys.util.object.DataTablePage;
import com.manage.advisory.control.Advisory ;
import com.manage.advisory.control.AdvisoryBO;
import com.util.Constants;

/**
 * Title: AdvisoryAction
 * @author Hujj
 * @version 1.0
 */
public class AdvisoryAction extends BaseAction{
	private static final long serialVersionUID = -5478057802776844675L;
	private final Log log = LogFactory.getLog(AdvisoryAction.class);
	public AdvisoryAction() {
		super();

		//????????��?����??��?????
		this.setForm(new AdvisoryForm());
		this.setParam(new AdvisoryWebParam());

        //???��VO?��
        setClsVO(AdvisoryVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"adId"};
		this.setClsControl(Advisory.class);

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
		AdvisoryWebParam params = (AdvisoryWebParam) this.getParam();
		Advisory bo = (Advisory) BOFactory.build(AdvisoryBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd HH:mm:ss");
		return null;
	}
	/**
	 * 保存
	 */

	public String doSave() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> dp = new HashMap<String, Object>();
		try {
			AdvisoryForm form = (AdvisoryForm) getForm();
			AdvisoryVO vo = new AdvisoryVO();
			BeanUtils.copyProperties(vo, form);
			Advisory bo = (Advisory) BOFactory.build(AdvisoryBO.class, this.getDBAccessUser());
			if (null == vo.getAdId()) {
				/*vo.setCreator(this.getDBAccessUser().getOperid());*/
				vo.setCreateTime(new Date());
				vo = bo.doCreate(vo);
			} else {
				vo.setUpdator(this.getDBAccessUser().getOperid());
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
	 * 编辑
	 */
	public String doEdit() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		AdvisoryWebParam params = (AdvisoryWebParam) this.getParam();
		Advisory bo = (Advisory) BOFactory.build(AdvisoryBO.class, this.getDBAccessUser());
		AdvisoryVO form = bo.doFindByPk(Integer.valueOf(params.get_pk()));
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
			Advisory bo = (Advisory) BOFactory.build(AdvisoryBO.class, this.getDBAccessUser());
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