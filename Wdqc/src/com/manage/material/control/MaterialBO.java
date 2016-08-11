package com.manage.material.control;

import java.io.Serializable;
import java.util.List;

import com.manage.course.persistent.CourseDAO;
import com.manage.course.persistent.CourseVO;
import com.manage.material.persistent.MaterialDBParam;
import com.manage.material.persistent.MaterialDAO;
import com.manage.material.persistent.MaterialVO;
import com.manage.member.persistent.MemberDAO;
import com.manage.member.persistent.MemberVO;
import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: MaterialBO
 * @author Hujj
 * @version 1.0
 */
public class MaterialBO extends AbstractControlBean implements
		Material {

	public MaterialVO doCreate(MaterialVO vo) throws Exception {
		try {
			MaterialDAO dao = (MaterialDAO) DAOFactory.build(MaterialDAO.class, user);
			// TODO set the pk */
			return (MaterialVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(MaterialVO vo) throws Exception {
		try {
			MaterialDAO dao = (MaterialDAO) DAOFactory.build(MaterialDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			MaterialDAO dao = (MaterialDAO) DAOFactory.build(MaterialDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public MaterialVO doUpdate(MaterialVO vo) throws Exception {
		try {
			MaterialDAO dao = (MaterialDAO) DAOFactory.build(MaterialDAO.class,user);
			return (MaterialVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public MaterialVO doFindByPk(Serializable pk) throws Exception {
		MaterialDAO dao = (MaterialDAO) DAOFactory.build(MaterialDAO.class,user);
		return (MaterialVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(MaterialDBParam params)
			throws Exception {
		MaterialDAO dao = (MaterialDAO) DAOFactory.build(MaterialDAO.class,user);
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				MaterialVO o = (MaterialVO) vo;
				this.fillCourse(o);
				this.fillUser(o);
				
			}
		}
		return dao.query(params);
	}
	public MaterialVO fillCourse(MaterialVO vo) throws Exception{
		CourseDAO dao = (CourseDAO) DAOFactory.build(CourseDAO.class,user);
		CourseVO c = (CourseVO) dao.findByPk(Integer.valueOf(vo.getCoId()));
		vo.setCoursename(c.getCoName());
		return vo;
		
	}
	private MaterialVO fillUser(MaterialVO vo) throws Exception {
		MemberDAO dao = (MemberDAO) DAOFactory.build(MemberDAO.class, user);
		if(vo.getCreator()==null){
			String c=null;
			vo.setCreatorname(c);
		}else{
			MemberVO c = (MemberVO) dao.findByPk(Integer.valueOf(vo.getCreator()));
			vo.setCreatorname(c.getMbPetName());
		}
		return vo;
	}
	public void doDel(List<String> ids) throws Exception {
		MaterialDAO dao = (MaterialDAO) DAOFactory.build(
				MaterialDAO.class, user);
		dao.doDel(ids);
	}
}
