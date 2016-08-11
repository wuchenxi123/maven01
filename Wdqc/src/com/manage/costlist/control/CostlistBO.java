package com.manage.costlist.control;

import java.io.Serializable;
import java.util.List;

import com.manage.campus.persistent.CampusDAO;
import com.manage.campus.persistent.CampusVO;
import com.manage.costlist.persistent.CostlistDBParam;
import com.manage.costlist.persistent.CostlistDAO;
import com.manage.costlist.persistent.CostlistVO;
import com.manage.costlist.web.CostlistForm;
import com.manage.gradlass.persistent.GradlassDAO;
import com.manage.gradlass.persistent.GradlassVO;
import com.manage.member.persistent.MemberDAO;
import com.manage.member.persistent.MemberVO;
import com.manage.student.persistent.StudentVO;
import com.manage.studentclass.persistent.StudentclassVO;
import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: CostlistBO
 * @author Hujj
 * @version 1.0
 */
public class CostlistBO extends AbstractControlBean implements
		Costlist {

	public CostlistVO doCreate(CostlistVO vo) throws Exception {
		try {
			CostlistDAO dao = (CostlistDAO) DAOFactory.build(CostlistDAO.class, user);
			// TODO set the pk */
			return (CostlistVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(CostlistVO vo) throws Exception {
		try {
			CostlistDAO dao = (CostlistDAO) DAOFactory.build(CostlistDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CostlistDAO dao = (CostlistDAO) DAOFactory.build(CostlistDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CostlistVO doUpdate(CostlistVO vo) throws Exception {
		try {
			CostlistDAO dao = (CostlistDAO) DAOFactory.build(CostlistDAO.class,user);
			return (CostlistVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CostlistVO doFindByPk(Serializable pk) throws Exception {
		CostlistDAO dao = (CostlistDAO) DAOFactory.build(CostlistDAO.class,user);
		return (CostlistVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CostlistDBParam params)
			throws Exception {
		CostlistDAO dao = (CostlistDAO) DAOFactory.build(CostlistDAO.class,user);
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				CostlistVO o = (CostlistVO) vo;
				this.fillUser(o);
				this.fillGrad(o);			
			}
		}
		return dp;
	}
	
	public CostlistForm doQueryCost(CostlistDBParam params)
			throws Exception {
		CostlistDAO dao = (CostlistDAO) DAOFactory.build(CostlistDAO.class,user);
		DataPackage dp = dao.query(params);
		int sum=0;
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				CostlistVO o = (CostlistVO) vo;
				sum=sum+o.getCltSum();
			}
		}
		CostlistForm form=new CostlistForm();
		form.setCostcum(sum);
		return form;
	}
	private CostlistVO fillGrad(CostlistVO vo) throws Exception {
		GradlassDAO dao = (GradlassDAO) DAOFactory.build(GradlassDAO.class, user);
		GradlassVO c = (GradlassVO) dao.findByPk(Long.valueOf(vo.getCsId()));
		vo.setCsname(c.getCsName());
		vo.setCscharge(String.valueOf(c.getCsCharge()));
		return vo;
	}
	private CostlistVO fillUser(CostlistVO vo) throws Exception {
		MemberDAO dao = (MemberDAO) DAOFactory.build(MemberDAO.class, user);
		MemberVO c = (MemberVO) dao.findByPk(Integer.valueOf(vo.getCreator()));
		vo.setMember(c.getMbPetName());
		return vo;
	}
	public void doDel(List<String> ids) throws Exception {
		CostlistDAO dao = (CostlistDAO) DAOFactory.build(
				CostlistDAO.class, user);
		dao.doDel(ids);
	}
}
