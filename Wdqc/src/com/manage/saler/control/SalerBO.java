package com.manage.saler.control;

import java.io.Serializable;

import com.manage.saler.persistent.SalerDBParam;
import com.manage.saler.persistent.SalerDAO;
import com.manage.saler.persistent.SalerVO;
import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: SalerBO
 * @author Hujj
 * @version 1.0
 */
public class SalerBO extends AbstractControlBean implements
		Saler {

	public SalerVO doCreate(SalerVO vo) throws Exception {
		try {
			SalerDAO dao = (SalerDAO) DAOFactory.build(SalerDAO.class, user);
			// TODO set the pk */
			return (SalerVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(SalerVO vo) throws Exception {
		try {
			SalerDAO dao = (SalerDAO) DAOFactory.build(SalerDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SalerDAO dao = (SalerDAO) DAOFactory.build(SalerDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public SalerVO doUpdate(SalerVO vo) throws Exception {
		try {
			SalerDAO dao = (SalerDAO) DAOFactory.build(SalerDAO.class,user);
			return (SalerVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public SalerVO doFindByPk(Serializable pk) throws Exception {
		SalerDAO dao = (SalerDAO) DAOFactory.build(SalerDAO.class,user);
		return (SalerVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SalerDBParam params)
			throws Exception {
		SalerDAO dao = (SalerDAO) DAOFactory.build(SalerDAO.class,user);
		return dao.query(params);
	}
}
