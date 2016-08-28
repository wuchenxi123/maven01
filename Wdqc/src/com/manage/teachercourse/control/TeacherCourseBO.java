package com.manage.teachercourse.control;

import java.io.Serializable;
import java.util.List;

import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.course.persistent.CourseDAO;
import com.manage.course.persistent.CourseVO;
import com.manage.teachercourse.persistent.TeacherCourseDAO;
import com.manage.teachercourse.persistent.TeacherCourseDBParam;
import com.manage.teachercourse.persistent.TeacherCourseVO;


/**
 * Title: TeacherCourseBO
 * @author 
 * @version 1.0
 */
public class TeacherCourseBO extends AbstractControlBean implements
		TeacherCourse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4241208703731746323L;
	public TeacherCourseVO doCreate(TeacherCourseVO vo) throws Exception {
		try {
			TeacherCourseDAO dao = (TeacherCourseDAO) DAOFactory.build(TeacherCourseDAO.class, user);
			// TODO set the pk */
			return (TeacherCourseVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(TeacherCourseVO vo) throws Exception {
		try {
			TeacherCourseDAO dao = (TeacherCourseDAO) DAOFactory.build(TeacherCourseDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			TeacherCourseDAO dao = (TeacherCourseDAO) DAOFactory.build(TeacherCourseDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public TeacherCourseVO doUpdate(TeacherCourseVO vo) throws Exception {
		try {
			TeacherCourseDAO dao = (TeacherCourseDAO) DAOFactory.build(TeacherCourseDAO.class,user);
			return (TeacherCourseVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public TeacherCourseVO doFindByPk(Serializable pk) throws Exception {
		TeacherCourseDAO dao = (TeacherCourseDAO) DAOFactory.build(TeacherCourseDAO.class,user);
		return (TeacherCourseVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(TeacherCourseDBParam params)
			throws Exception {
		TeacherCourseDAO dao = (TeacherCourseDAO) DAOFactory.build(TeacherCourseDAO.class,user);
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				TeacherCourseVO o = (TeacherCourseVO) vo;
				this.fillCourse(o);
			}
		}
		return dp;
	}
	public TeacherCourseVO fillCourse(TeacherCourseVO vo) throws Exception {
		CourseDAO dao = (CourseDAO) DAOFactory.build(CourseDAO.class, user);
		if (vo.getCoid() == null) {
			String c = null;
			vo.setCoursename(c);
		} else {
			CourseVO c = (CourseVO) dao.findByPk(vo.getCoid());
			vo.setCoursename(c.getCoName());
		}
		return vo;

	}
	public void doDel(List<String> ids)throws Exception {
		try {
			if(ids!=null&&ids.size()>0){
				TeacherCourseDAO dao = (TeacherCourseDAO) DAOFactory.build(TeacherCourseDAO.class,user);
				for (int i = 0; i < ids.size(); i++) {
					dao.removeByPk(Integer.valueOf(ids.get(i)));
				}
			}
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
}
