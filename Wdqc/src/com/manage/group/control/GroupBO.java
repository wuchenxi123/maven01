package com.manage.group.control;

import java.io.Serializable;

import com.manage.group.persistent.GroupDBParam;
import com.manage.group.persistent.GroupDAO;
import com.manage.group.persistent.GroupVO;
import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: GroupBO
 * @author 
 * @version 1.0
 */
public class GroupBO extends AbstractControlBean implements
		Group {

	public GroupVO doCreate(GroupVO vo) throws Exception {
		try {
			GroupDAO dao = (GroupDAO) DAOFactory.build(GroupDAO.class, user);
			// TODO set the pk */
			return (GroupVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(GroupVO vo) throws Exception {
		try {
			GroupDAO dao = (GroupDAO) DAOFactory.build(GroupDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			GroupDAO dao = (GroupDAO) DAOFactory.build(GroupDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public GroupVO doUpdate(GroupVO vo) throws Exception {
		try {
			GroupDAO dao = (GroupDAO) DAOFactory.build(GroupDAO.class,user);
			return (GroupVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public GroupVO doFindByPk(Serializable pk) throws Exception {
		GroupDAO dao = (GroupDAO) DAOFactory.build(GroupDAO.class,user);
		return (GroupVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(GroupDBParam params)
			throws Exception {
		GroupDAO dao = (GroupDAO) DAOFactory.build(GroupDAO.class,user);
		return dao.query(params);
	}
	
}
