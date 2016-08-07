package com.manage.member.control;

import java.io.Serializable;
import java.util.List;

import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.classroom.persistent.ClassroomDAO;
import com.manage.member.persistent.MemberDAO;
import com.manage.member.persistent.MemberDBParam;
import com.manage.member.persistent.MemberVO;

/**
 * Title: MemberBO
 * @author Hujj
 * @version 1.0
 */
public class MemberBO extends AbstractControlBean implements
		Member {

	public MemberVO doCreate(MemberVO vo) throws Exception {
		try {
			MemberDAO dao = (MemberDAO) DAOFactory.build(MemberDAO.class, user);
			// TODO set the pk */
			return (MemberVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(MemberVO vo) throws Exception {
		try {
			MemberDAO dao = (MemberDAO) DAOFactory.build(MemberDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			MemberDAO dao = (MemberDAO) DAOFactory.build(MemberDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public MemberVO doUpdate(MemberVO vo) throws Exception {
		try {
			MemberDAO dao = (MemberDAO) DAOFactory.build(MemberDAO.class,user);
			return (MemberVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public MemberVO doFindByPk(Serializable pk) throws Exception {
		MemberDAO dao = (MemberDAO) DAOFactory.build(MemberDAO.class,user);
		return (MemberVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(MemberDBParam params)
			throws Exception {
		MemberDAO dao = (MemberDAO) DAOFactory.build(MemberDAO.class,user);
		return dao.query(params);
	}
	public void doDel(List<String> ids)throws Exception {
		try {
			if(ids!=null&&ids.size()>0){
				MemberDAO dao = (MemberDAO) DAOFactory.build(MemberDAO.class,user);
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
