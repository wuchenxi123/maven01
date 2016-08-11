package com.manage.teacher.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.gradlass.persistent.GradlassDAO;
import com.manage.gradlass.persistent.GradlassVO;
import com.manage.gradlass.web.GradlassWebParam;
import com.manage.gradlassTeacher.persistent.GradlassTeacherDAO;
import com.manage.gradlassTeacher.persistent.GradlassTeacherVO;
import com.manage.gradlassTeacher.web.GradlassTeacherWebParam;
import com.manage.teacher.persistent.TeacherDAO;
import com.manage.teacher.persistent.TeacherDBParam;
import com.manage.teacher.persistent.TeacherVO;

/**
 * Title: TeacherBO
 * @author 
 * @version 1.0
 */
public class TeacherBO extends AbstractControlBean implements
		Teacher {

	public TeacherVO doCreate(TeacherVO vo) throws Exception {
		try {
			TeacherDAO dao = (TeacherDAO) DAOFactory.build(TeacherDAO.class, user);
			// TODO set the pk */
			return (TeacherVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(TeacherVO vo) throws Exception {
		try {
			TeacherDAO dao = (TeacherDAO) DAOFactory.build(TeacherDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			TeacherDAO dao = (TeacherDAO) DAOFactory.build(TeacherDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public TeacherVO doUpdate(TeacherVO vo) throws Exception {
		try {
			TeacherDAO dao = (TeacherDAO) DAOFactory.build(TeacherDAO.class,user);
			return (TeacherVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public TeacherVO doFindByPk(Serializable pk) throws Exception {
		TeacherDAO dao = (TeacherDAO) DAOFactory.build(TeacherDAO.class,user);
		return (TeacherVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(TeacherDBParam params)
			throws Exception {
		TeacherDAO dao = (TeacherDAO) DAOFactory.build(TeacherDAO.class,user);
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				TeacherVO o = (TeacherVO) vo;
				if(o.getGradlassteacher()!=null&&o.getGradlassteacher()>0){
					this.fillGradlass(o);
				}
			}
		}

		return dao.query(params);
	}
	private TeacherVO fillGradlass(TeacherVO vo) throws Exception {
		DataPackage gradlass = null;
		List<GradlassVO> gradList=new ArrayList<GradlassVO>();
		if (vo.getGradlassteacher() > 0) {
			GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(
					GradlassTeacherDAO.class, user);
			GradlassTeacherWebParam gtparams = new GradlassTeacherWebParam();
			gtparams.set_ne_teacherid(String.valueOf(vo.getGradlassteacher()));
			DataPackage grads = dao.query(gtparams);
			List<GradlassTeacherVO> list = grads.getDatas();
			GradlassDAO graddao = (GradlassDAO) DAOFactory.build(GradlassDAO.class,user);
			GradlassWebParam params = new GradlassWebParam();

			for (int i = 0; i < list.size(); i++) {
				params.set_ne_csId(String.valueOf(list.get(i).getGradlassid()));
				gradlass = graddao.query(params);
				gradList.add((GradlassVO) gradlass.getDatas().get(0));
				
			}
			vo.setGradlassList(gradList);
			System.out.println(gradList.size());
			vo.setTeGradlasscount((short) gradList.size());
		}
		return vo;
	}

	public void doDel(List<String> ids) throws Exception {
		TeacherDAO dao = (TeacherDAO) DAOFactory.build(
				TeacherDAO.class, user);
		dao.doDel(ids);
	}
	


}
