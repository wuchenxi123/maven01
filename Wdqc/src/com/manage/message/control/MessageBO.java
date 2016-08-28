package com.manage.message.control;

import java.io.Serializable;
import java.util.List;

import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.course.persistent.CourseDAO;
import com.manage.course.persistent.CourseVO;
import com.manage.member.persistent.MemberDAO;
import com.manage.member.persistent.MemberVO;
import com.manage.message.persistent.MessageDAO;
import com.manage.message.persistent.MessageDBParam;
import com.manage.message.persistent.MessageVO;

/**
 * Title: MessageBO
 * @author chenlei
 * @version 1.0
 */
public class MessageBO extends AbstractControlBean implements
		Message {

	public MessageVO doCreate(MessageVO vo) throws Exception {
		try {
			MessageDAO dao = (MessageDAO) DAOFactory.build(MessageDAO.class, user);
			// TODO set the pk */
			return (MessageVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(MessageVO vo) throws Exception {
		try {
			MessageDAO dao = (MessageDAO) DAOFactory.build(MessageDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			MessageDAO dao = (MessageDAO) DAOFactory.build(MessageDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public MessageVO doUpdate(MessageVO vo) throws Exception {
		try {
			MessageDAO dao = (MessageDAO) DAOFactory.build(MessageDAO.class,user);
			return (MessageVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public MessageVO doFindByPk(Serializable pk) throws Exception {
		MessageDAO dao = (MessageDAO) DAOFactory.build(MessageDAO.class,user);
		return (MessageVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(MessageDBParam params)
			throws Exception {
		MessageDAO dao = (MessageDAO) DAOFactory.build(MessageDAO.class,user);
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				MessageVO o = (MessageVO) vo;
				this.fillUser(o);
			}
		}
		return dao.query(params);
	}
	private MessageVO fillUser(MessageVO vo) throws Exception {
		MemberDAO dao = (MemberDAO) DAOFactory.build(MemberDAO.class, user);
		if(vo.getMgCreator()==null){
			String c=null;
			vo.setMgCreatorname(c);
		}else{
			MemberVO c = (MemberVO) dao.findByPk(Integer.valueOf(vo.getMgCreator()));
			vo.setMgCreatorname(c.getMbPetName());
		}
		return vo;
	}
	public void doDel(List<String> list) throws Exception {
		try {
			MessageDAO dao = (MessageDAO) DAOFactory.build(MessageDAO.class,user);
			for (int i = 0; i < list.size(); i++) {
				dao.removeByPk(Integer.valueOf(list.get(i)));
			}
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
}
