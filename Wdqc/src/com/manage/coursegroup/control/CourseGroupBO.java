package com.manage.coursegroup.control;

import java.io.Serializable;

import com.manage.coursegroup.persistent.CourseGroupDBParam;
import com.manage.coursegroup.persistent.CourseGroupDAO;
import com.manage.coursegroup.persistent.CourseGroupVO;
import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: courseGroupBO
 * @author 
 * @version 1.0
 */
public class CourseGroupBO extends AbstractControlBean implements
		CourseGroup {

	public CourseGroupVO doCreate(CourseGroupVO vo) throws Exception {
		try {
			CourseGroupDAO dao = (CourseGroupDAO) DAOFactory.build(CourseGroupDAO.class, user);
			// TODO set the pk */
			return (CourseGroupVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(CourseGroupVO vo) throws Exception {
		try {
			CourseGroupDAO dao = (CourseGroupDAO) DAOFactory.build(CourseGroupDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CourseGroupDAO dao = (CourseGroupDAO) DAOFactory.build(CourseGroupDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CourseGroupVO doUpdate(CourseGroupVO vo) throws Exception {
		try {
			CourseGroupDAO dao = (CourseGroupDAO) DAOFactory.build(CourseGroupDAO.class,user);
			return (CourseGroupVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CourseGroupVO doFindByPk(Serializable pk) throws Exception {
		CourseGroupDAO dao = (CourseGroupDAO) DAOFactory.build(CourseGroupDAO.class,user);
		return (CourseGroupVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CourseGroupDBParam params)
			throws Exception {
		CourseGroupDAO dao = (CourseGroupDAO) DAOFactory.build(CourseGroupDAO.class,user);
		return dao.query(params);
	}
}
