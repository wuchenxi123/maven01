package com.manage.message.web;

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
import com.manage.advisory.web.AdvisoryAction;
import com.manage.message.control.Message;
import com.manage.message.control.MessageBO;
import com.manage.message.persistent.MessageDBParam;
import com.manage.message.persistent.MessageVO;
import com.util.Constants;

/**
 * Title: MessageAction
 * @author chenlei
 * @version 1.0
 */
public class MessageAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9130697403964290494L;
	private final Log log = LogFactory.getLog(MessageAction.class);
	public MessageAction() {
		super();

		//????????��?����??��?????
		this.setForm(new MessageForm());
		this.setParam(new MessageWebParam());

        //???��VO?��
        setClsVO(MessageVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"mgId"};
		this.setClsControl(Message.class);
		this.setClsQueryParam(MessageDBParam.class) ;

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
		MessageWebParam params = (MessageWebParam) this.getParam();
		Message bo = (Message) BOFactory.build(MessageBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		PageUtils.writePage(new DataTablePage(dp), response, "yyyy-MM-dd HH:mm:ss");
		return null;
	}
	public String doShow() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		this.setParam4DataTable();
		MessageWebParam params = (MessageWebParam) this.getParam();
		Message bo = (Message) BOFactory.build(MessageBO.class, this.getDBAccessUser());
		DataPackage dp = bo.doQuery(params);
		List<MessageVO> al=dp.getDatas();
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
			MessageForm form = (MessageForm) getForm();
			MessageVO vo = new MessageVO();
			BeanUtils.copyProperties(vo, form);
			Message bo = (Message) BOFactory.build(MessageBO.class, this.getDBAccessUser());
			if (null == vo.getMgId()) {
				vo.setMgCreator(this.getDBAccessUser().getOperid());
				vo.setMgCreattime(new Date());
				vo = bo.doCreate(vo);
			} else {
				vo.setMgCreator(this.getDBAccessUser().getOperid());
				vo.setMgCreattime(new Date());
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
		MessageWebParam params = (MessageWebParam) this.getParam();
		Message bo = (Message) BOFactory.build(MessageBO.class, this.getDBAccessUser());
		MessageVO form = bo.doFindByPk(Integer.valueOf(params.get_pk()));
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
			Message bo = (Message) BOFactory.build(MessageBO.class, this.getDBAccessUser());
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