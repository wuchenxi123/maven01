package com.manage.gradlassTeacher.control;

import java.io.Serializable;
import java.util.List;

import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.advisory.persistent.AdvisoryVO;
import com.manage.gradlass.control.GradlassBO;
import com.manage.gradlass.persistent.GradlassDBParam;
import com.manage.gradlassTeacher.persistent.GradlassTeacherDAO;
import com.manage.gradlassTeacher.persistent.GradlassTeacherDBParam;
import com.manage.gradlassTeacher.persistent.GradlassTeacherVO;
import com.manage.teacher.persistent.TeacherDAO;
import com.manage.teacher.persistent.TeacherVO;

/**
 * Title: GradlassTeacherBO
 * 
 * @author
 * @version 1.0
 */
public class GradlassTeacherBO extends AbstractControlBean implements GradlassTeacher {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GradlassTeacherVO doCreate(GradlassTeacherVO vo) throws Exception {
		try {
			GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class, user);
			// TODO set the pk */
			return (GradlassTeacherVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(GradlassTeacherVO vo) throws Exception {
		try {
			GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public GradlassTeacherVO doUpdate(GradlassTeacherVO vo) throws Exception {
		try {
			GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class, user);
			return (GradlassTeacherVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public GradlassTeacherVO doFindByPk(Serializable pk) throws Exception {
		GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class, user);
		return (GradlassTeacherVO) dao.findByPk(pk);
	}

	public DataPackage doQuerys(GradlassTeacherDBParam params) throws Exception {
		DataPackage dpgd = new DataPackage();
		GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class, user);
		DataPackage gt = dao.query(params);
		GradlassDBParam gd = new GradlassDBParam();
		GradlassBO gbo = new GradlassBO();
		if (gt.getDatas().size() > 0 && gt.getDatas() != null) {
			for (int i = 0; i < gt.getDatas().size(); i++) {
				GradlassTeacherVO gtvo = (GradlassTeacherVO) gt.getDatas().get(i);
				gtvo.getGradlassid();
				gd.set_ne_csId(gtvo.getGradlassid().toString());
				dpgd = gbo.doQuery(gd);
			}

		}
		return dpgd;
	}

	public DataPackage doQuery(GradlassTeacherDBParam params) throws Exception {
		GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class, user);
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				GradlassTeacherVO o = (GradlassTeacherVO) vo;
				this.fillTeacher(o);
				
			}
		}
		return dp;
	}

	public void doDel(List<String> ids) throws Exception {
		GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class, user);
		dao.doDel(ids);
	}

	public GradlassTeacherVO fillTeacher(GradlassTeacherVO vo) throws Exception {
		TeacherDAO dao = (TeacherDAO) DAOFactory.build(TeacherDAO.class, user);
		if (vo.getTeacherid() == null) {
			String c = null;
			vo.setTeachername(c);
		} else {
			TeacherVO c = (TeacherVO) dao.findByPk(vo.getTeacherid());
			vo.setTeachername(c.getTeName());
		}
		return vo;

	}
}
