package com.manage.campus.control;

import java.io.Serializable;

import com.manage.campus.persistent.CampusDBParam;
import com.manage.campus.persistent.CampusDAO;
import com.manage.campus.persistent.CampusVO;
import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: CampusBO
 * @author Hujj
 * @version 1.0
 */
public class CampusBO extends AbstractControlBean implements
		Campus {

	public CampusVO doCreate(CampusVO vo) throws Exception {
		try {
			CampusDAO dao = (CampusDAO) DAOFactory.build(CampusDAO.class, user);
			// TODO set the pk */
			return (CampusVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(CampusVO vo) throws Exception {
		try {
			CampusDAO dao = (CampusDAO) DAOFactory.build(CampusDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CampusDAO dao = (CampusDAO) DAOFactory.build(CampusDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CampusVO doUpdate(CampusVO vo) throws Exception {
		try {
			CampusDAO dao = (CampusDAO) DAOFactory.build(CampusDAO.class,user);
			return (CampusVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CampusVO doFindByPk(Serializable pk) throws Exception {
		CampusDAO dao = (CampusDAO) DAOFactory.build(CampusDAO.class,user);
		return (CampusVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CampusDBParam params)
			throws Exception {
		CampusDAO dao = (CampusDAO) DAOFactory.build(CampusDAO.class,user);
		return dao.query(params);
	}
}
