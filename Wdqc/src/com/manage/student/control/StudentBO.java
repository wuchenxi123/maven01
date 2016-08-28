package com.manage.student.control;

import java.io.Serializable;
import java.util.List;

import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.campus.persistent.CampusDAO;
import com.manage.campus.persistent.CampusVO;
import com.manage.member.persistent.MemberDAO;
import com.manage.member.persistent.MemberVO;
import com.manage.saler.persistent.SalerDAO;
import com.manage.saler.persistent.SalerVO;
import com.manage.student.persistent.StudentDAO;
import com.manage.student.persistent.StudentDBParam;
import com.manage.student.persistent.StudentVO;

/**
 * Title: StudentBO
 * @author Hujj
 * @version 1.0
 */
public class StudentBO extends AbstractControlBean implements
		Student {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StudentVO doCreate(StudentVO vo) throws Exception {
		try {
			StudentDAO dao = (StudentDAO) DAOFactory.build(StudentDAO.class, user);
			// TODO set the pk */
			return (StudentVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(StudentVO vo) throws Exception {
		try {
			StudentDAO dao = (StudentDAO) DAOFactory.build(StudentDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			StudentDAO dao = (StudentDAO) DAOFactory.build(StudentDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StudentVO doUpdate(StudentVO vo) throws Exception {
		try {
			StudentDAO dao = (StudentDAO) DAOFactory.build(StudentDAO.class,user);
			return (StudentVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StudentVO doFindByPk(Serializable pk) throws Exception {
		StudentDAO dao = (StudentDAO) DAOFactory.build(StudentDAO.class,user);
		return (StudentVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(StudentDBParam params)
			throws Exception {
		StudentDAO dao = (StudentDAO) DAOFactory.build(StudentDAO.class,user);
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				StudentVO o = (StudentVO) vo;
				this.fillUser(o);
				this.fillCampus(o);
				this.fillSaler(o);
				/*this.fillCostinfo(o);*/
			/*	this.fillGrad(o);*/
				/*this.fillGradlass(o);*/
				
			}
		}
		return dao.query(params);
	}
	public void doDel(List<String> ids) throws Exception {
		StudentDAO dao = (StudentDAO) DAOFactory.build(
				StudentDAO.class, user);
		dao.doDel(ids);
	}
	
	private StudentVO fillUser(StudentVO vo) throws Exception {
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
/*	private StudentVO fillCostinfo(StudentVO vo) throws Exception {
		CostinfoDAO dao = (CostinfoDAO) DAOFactory.build(CostinfoDAO.class, user);
		CostinfoWebParam params = new CostinfoWebParam();
		params.set_ne_stId(String.valueOf(vo.getStId()));
		DataPackage c = dao.query(params);
		vo.setCostinfo(c);
		return vo;
	}*/
	private StudentVO fillCampus(StudentVO vo) throws Exception {
		CampusDAO dao = (CampusDAO) DAOFactory.build(CampusDAO.class, user);
		CampusVO c = (CampusVO) dao.findByPk(Long.valueOf(vo.getStLocationSchool()));
		vo.setCampus(c.getCpName());
		return vo;
	}
	
	private StudentVO fillSaler(StudentVO vo) throws Exception {
		SalerDAO dao = (SalerDAO) DAOFactory.build(SalerDAO.class, user);
		SalerVO c = (SalerVO) dao.findByPk(Long.valueOf(vo.getSlId()));
		vo.setSalerName(c.getSlName());
		return vo;
	}
	/*private StudentVO fillGrad(StudentVO vo) throws Exception {
		Studentclass bo = (Studentclass) BOFactory.build(StudentclassBO.class, user);
		StudentclassWebParam params = new StudentclassWebParam();
		params.set_ne_stId(String.valueOf(vo.getStId()));
		DataPackage c = bo.doQuery(params);
		vo.setGrad(c);
		return vo;
	}*/
	
	
}
