package com.manage.role.control;

import java.io.Serializable;

import com.manage.role.persistent.RoleDBParam;
import com.manage.role.persistent.RoleDAO;
import com.manage.role.persistent.RoleVO;
import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: RoleBO
 * @author chenlei
 * @version 1.0
 */
public class RoleBO extends AbstractControlBean implements
		Role {

	public RoleVO doCreate(RoleVO vo) throws Exception {
		try {
			RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class, user);
			// TODO set the pk */
			return (RoleVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(RoleVO vo) throws Exception {
		try {
			RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public RoleVO doUpdate(RoleVO vo) throws Exception {
		try {
			RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class,user);
			return (RoleVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public RoleVO doFindByPk(Serializable pk) throws Exception {
		RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class,user);
		return (RoleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RoleDBParam params)
			throws Exception {
		RoleDAO dao = (RoleDAO) DAOFactory.build(RoleDAO.class,user);
		return dao.query(params);
	}
}
