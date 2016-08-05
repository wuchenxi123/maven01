package com.manage.gradlassTeacher.control;

import java.io.Serializable;

import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.gradlass.control.Gradlass;
import com.manage.gradlass.control.GradlassBO;
import com.manage.gradlass.persistent.GradlassDBParam;
import com.manage.gradlass.web.GradlassWebParam;
import com.manage.gradlassTeacher.persistent.GradlassTeacherDAO;
import com.manage.gradlassTeacher.persistent.GradlassTeacherDBParam;
import com.manage.gradlassTeacher.persistent.GradlassTeacherVO;

/**
 * Title: GradlassTeacherBO
 * @author 
 * @version 1.0
 */
public class GradlassTeacherBO extends AbstractControlBean implements
		GradlassTeacher {

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
			GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public GradlassTeacherVO doUpdate(GradlassTeacherVO vo) throws Exception {
		try {
			GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class,user);
			return (GradlassTeacherVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
	
	public GradlassTeacherVO doFindByPk(Serializable pk) throws Exception {
		GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class,user);
		return (GradlassTeacherVO) dao.findByPk(pk);
	}

	public DataPackage doQuerys(GradlassTeacherDBParam params)
			throws Exception {
		DataPackage dpgd=new DataPackage();
		GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class,user);
		DataPackage gt=dao.query(params);
		GradlassDBParam gd=new GradlassDBParam();
		GradlassBO gbo=new GradlassBO();
		if(gt.getDatas().size()>0&&gt.getDatas()!=null){
			for (int i = 0; i < gt.getDatas().size(); i++) {
				GradlassTeacherVO gtvo=(GradlassTeacherVO) gt.getDatas().get(i);
				gtvo.getGradlassid();
				gd.set_ne_csId(gtvo.getGradlassid().toString());
				dpgd=gbo.doQuery(gd);
			}
			
		}
		return dpgd;
	}
	public DataPackage doQuery(GradlassTeacherDBParam params)
			throws Exception {
		GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class,user);
		return dao.query(params);
	}
}
