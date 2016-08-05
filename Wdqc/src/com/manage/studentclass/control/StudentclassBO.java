package com.manage.studentclass.control;

import java.io.Serializable;
import java.util.List;

import com.manage.gradlass.persistent.GradlassDAO;
import com.manage.gradlass.persistent.GradlassVO;
import com.manage.student.persistent.StudentDAO;
import com.manage.student.persistent.StudentVO;
import com.manage.studentclass.persistent.StudentclassDBParam;
import com.manage.studentclass.persistent.StudentclassDAO;
import com.manage.studentclass.persistent.StudentclassVO;
import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: StudentclassBO
 * @author Hujj
 * @version 1.0
 */
public class StudentclassBO extends AbstractControlBean implements
		Studentclass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StudentclassVO doCreate(StudentclassVO vo) throws Exception {
		try {
			StudentclassDAO dao = (StudentclassDAO) DAOFactory.build(StudentclassDAO.class, user);
			// TODO set the pk */
			return (StudentclassVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(StudentclassVO vo) throws Exception {
		try {
			StudentclassDAO dao = (StudentclassDAO) DAOFactory.build(StudentclassDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			StudentclassDAO dao = (StudentclassDAO) DAOFactory.build(StudentclassDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StudentclassVO doUpdate(StudentclassVO vo) throws Exception {
		try {
			StudentclassDAO dao = (StudentclassDAO) DAOFactory.build(StudentclassDAO.class,user);
			return (StudentclassVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StudentclassVO doFindByPk(Serializable pk) throws Exception {
		StudentclassDAO dao = (StudentclassDAO) DAOFactory.build(StudentclassDAO.class,user);
		return (StudentclassVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(StudentclassDBParam params)
			throws Exception {
		StudentclassDAO dao = (StudentclassDAO) DAOFactory.build(StudentclassDAO.class,user);
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				StudentclassVO o = (StudentclassVO) vo;
				this.fillGrad(o);	
				this.fillStudent(o);
			}
		}
		return dp;
	}
	private StudentclassVO fillGrad(StudentclassVO vo) throws Exception {
		GradlassDAO dao = (GradlassDAO) DAOFactory.build(GradlassDAO.class, user);
		GradlassVO c = (GradlassVO) dao.findByPk(Long.valueOf(vo.getCsId()));
		vo.setGradlass(c);
		return vo;
	}
	private StudentclassVO fillStudent(StudentclassVO vo) throws Exception {
		StudentDAO dao = (StudentDAO) DAOFactory.build(StudentDAO.class, user);
		StudentVO c = (StudentVO) dao.findByPk(Long.valueOf(vo.getStId()));
		vo.setStudent(c);
		return vo;
	}
	public void doDel(List<String> ids) throws Exception {
		StudentclassDAO dao = (StudentclassDAO) DAOFactory.build(
				StudentclassDAO.class, user);
		dao.doDel(ids);
	}
}
