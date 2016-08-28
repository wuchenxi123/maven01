package com.manage.advisory.control;

import java.io.Serializable;
import java.util.List;

import com.manage.advisory.persistent.AdvisoryDBParam;
import com.manage.advisory.persistent.AdvisoryDAO;
import com.manage.advisory.persistent.AdvisoryVO;
import com.manage.course.persistent.CourseDAO;
import com.manage.course.persistent.CourseVO;
import com.manage.member.persistent.MemberDAO;
import com.manage.member.persistent.MemberVO;
import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: AdvisoryBO
 * @author Hujj
 * @version 1.0
 */
public class AdvisoryBO extends AbstractControlBean implements
		Advisory {

	public AdvisoryVO doCreate(AdvisoryVO vo) throws Exception {
		try {
			AdvisoryDAO dao = (AdvisoryDAO) DAOFactory.build(AdvisoryDAO.class, user);
			// TODO set the pk */
			return (AdvisoryVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(AdvisoryVO vo) throws Exception {
		try {
			AdvisoryDAO dao = (AdvisoryDAO) DAOFactory.build(AdvisoryDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AdvisoryDAO dao = (AdvisoryDAO) DAOFactory.build(AdvisoryDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public AdvisoryVO doUpdate(AdvisoryVO vo) throws Exception {
		try {
			AdvisoryDAO dao = (AdvisoryDAO) DAOFactory.build(AdvisoryDAO.class,user);
			return (AdvisoryVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public AdvisoryVO doFindByPk(Serializable pk) throws Exception {
		AdvisoryDAO dao = (AdvisoryDAO) DAOFactory.build(AdvisoryDAO.class,user);
		Object vo= dao.findByPk(pk);
		AdvisoryVO o = (AdvisoryVO) vo;
		this.fillCourse(o);
		return (AdvisoryVO) vo;
	}

	public DataPackage doQuery(AdvisoryDBParam params)
			throws Exception {
		AdvisoryDAO dao = (AdvisoryDAO) DAOFactory.build(AdvisoryDAO.class,user);
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				AdvisoryVO o = (AdvisoryVO) vo;
				this.fillCourse(o);
				this.fillUser(o);
				
			}
		}
		return dao.query(params);
	}
	public void doDel(List<String> ids) throws Exception {
		AdvisoryDAO dao = (AdvisoryDAO) DAOFactory.build(
				AdvisoryDAO.class, user);
		dao.doDel(ids);
	}
	
	private AdvisoryVO fillCourse(AdvisoryVO vo) throws Exception {
		CourseDAO dao = (CourseDAO) DAOFactory.build(CourseDAO.class, user);
		CourseVO c = (CourseVO) dao.findByPk(Integer.valueOf(vo.getAdCourse()));
		vo.setCoursename(c.getCoName());
		return vo;
	}
	private AdvisoryVO fillUser(AdvisoryVO vo) throws Exception {
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
}
