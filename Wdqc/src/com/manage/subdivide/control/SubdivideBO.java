package com.manage.subdivide.control;

import java.io.Serializable;

import com.manage.subdivide.persistent.SubdivideDBParam;
import com.manage.subdivide.persistent.SubdivideDAO;
import com.manage.subdivide.persistent.SubdivideVO;
import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: SubdivideBO
 * @author Hujj
 * @version 1.0
 */
public class SubdivideBO extends AbstractControlBean implements
		Subdivide {

	public SubdivideVO doCreate(SubdivideVO vo) throws Exception {
		try {
			SubdivideDAO dao = (SubdivideDAO) DAOFactory.build(SubdivideDAO.class, user);
			// TODO set the pk */
			return (SubdivideVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(SubdivideVO vo) throws Exception {
		try {
			SubdivideDAO dao = (SubdivideDAO) DAOFactory.build(SubdivideDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SubdivideDAO dao = (SubdivideDAO) DAOFactory.build(SubdivideDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public SubdivideVO doUpdate(SubdivideVO vo) throws Exception {
		try {
			SubdivideDAO dao = (SubdivideDAO) DAOFactory.build(SubdivideDAO.class,user);
			return (SubdivideVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public SubdivideVO doFindByPk(Serializable pk) throws Exception {
		SubdivideDAO dao = (SubdivideDAO) DAOFactory.build(SubdivideDAO.class,user);
		return (SubdivideVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SubdivideDBParam params)
			throws Exception {
		SubdivideDAO dao = (SubdivideDAO) DAOFactory.build(SubdivideDAO.class,user);
		return dao.query(params);
	}
}
