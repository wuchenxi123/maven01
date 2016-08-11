package com.manage.classroom.control;

import java.io.Serializable;
import java.util.List;

import com.manage.advisory.persistent.AdvisoryDAO;
import com.manage.campus.persistent.CampusDAO;
import com.manage.campus.persistent.CampusVO;
import com.manage.classroom.persistent.ClassroomDBParam;
import com.manage.classroom.persistent.ClassroomDAO;
import com.manage.classroom.persistent.ClassroomVO;
import com.manage.student.persistent.StudentVO;
import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: ClassroomBO
 * 
 * @author Hujj
 * @version 1.0
 */
public class ClassroomBO extends AbstractControlBean implements Classroom {

	public ClassroomVO doCreate(ClassroomVO vo) throws Exception {
		try {
			ClassroomDAO dao = (ClassroomDAO) DAOFactory.build(
					ClassroomDAO.class, user);
			// TODO set the pk */
			return (ClassroomVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(ClassroomVO vo) throws Exception {
		try {
			ClassroomDAO dao = (ClassroomDAO) DAOFactory.build(
					ClassroomDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ClassroomDAO dao = (ClassroomDAO) DAOFactory.build(
					ClassroomDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public ClassroomVO doUpdate(ClassroomVO vo) throws Exception {
		try {
			ClassroomDAO dao = (ClassroomDAO) DAOFactory.build(
					ClassroomDAO.class, user);
			return (ClassroomVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public ClassroomVO doFindByPk(Serializable pk) throws Exception {
		ClassroomDAO dao = (ClassroomDAO) DAOFactory.build(ClassroomDAO.class,
				user);
		return (ClassroomVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ClassroomDBParam params) throws Exception {
		ClassroomDAO dao = (ClassroomDAO) DAOFactory.build(ClassroomDAO.class,
				user);
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				ClassroomVO o = (ClassroomVO) vo;
				this.fillCampus(o);
			}
		}
		return dao.query(params);
	}

	private ClassroomVO fillCampus(ClassroomVO vo) throws Exception {
		CampusDAO dao = (CampusDAO) DAOFactory.build(CampusDAO.class, user);
		CampusVO c = (CampusVO) dao.findByPk(Long.valueOf(vo.getCrCampus()));
		vo.setCampus(c);
		return vo;
	}

	public void doDel(List<String> ids) throws Exception {
		try {
			ClassroomDAO dao = (ClassroomDAO) DAOFactory.build(ClassroomDAO.class,
					user);
			for (int i = 0; i < ids.size(); i++) {
				dao.removeByPk(Long.valueOf(ids.get(i)));
			}
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
}
