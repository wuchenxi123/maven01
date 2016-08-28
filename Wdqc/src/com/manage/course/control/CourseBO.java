package com.manage.course.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.advisory.persistent.AdvisoryVO;
import com.manage.course.persistent.CourseDAO;
import com.manage.course.persistent.CourseDBParam;
import com.manage.course.persistent.CourseVO;
import com.manage.coursegroup.persistent.CourseGroupDAO;
import com.manage.coursegroup.persistent.CourseGroupVO;
import com.manage.coursegroup.web.CourseGroupWebParam;
import com.manage.group.persistent.GroupDAO;
import com.manage.group.persistent.GroupVO;
import com.manage.group.web.GroupWebParam;
import com.manage.member.persistent.MemberDAO;
import com.manage.member.persistent.MemberVO;

/**
 * Title: CourseBO
 * @author Hujj
 * @version 1.0
 */
public class CourseBO extends AbstractControlBean implements
		Course {

	public CourseVO doCreate(CourseVO vo) throws Exception {
		try {
			CourseDAO dao = (CourseDAO) DAOFactory.build(CourseDAO.class, user);
			// TODO set the pk */
			return (CourseVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(CourseVO vo) throws Exception {
		try {
			CourseDAO dao = (CourseDAO) DAOFactory.build(CourseDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CourseDAO dao = (CourseDAO) DAOFactory.build(CourseDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CourseVO doUpdate(CourseVO vo) throws Exception {
		try {
			CourseDAO dao = (CourseDAO) DAOFactory.build(CourseDAO.class,user);
			return (CourseVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CourseVO doFindByPk(Serializable pk) throws Exception {
		CourseDAO dao = (CourseDAO) DAOFactory.build(CourseDAO.class,user);
		return (CourseVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CourseDBParam params)
			throws Exception {
		CourseDAO dao = (CourseDAO) DAOFactory.build(CourseDAO.class,user);
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				CourseVO o = (CourseVO) vo;
				this.fillUser(o);
			}
		}
		return dao.query(params);
	}
	private CourseVO fillClassify(CourseVO vo) throws Exception {
		DataPackage classify = null;
		List<GroupVO> gs=new ArrayList<GroupVO>();
			CourseGroupDAO dao = (CourseGroupDAO) DAOFactory.build(
					CourseGroupDAO.class, user);
			CourseGroupWebParam cgparams = new CourseGroupWebParam();
			cgparams.set_ne_courseid(String.valueOf(vo.getCoId()));
			DataPackage cous = dao.query(cgparams);
			List<CourseGroupVO> list = cous.getDatas();
			GroupDAO groupdao = (GroupDAO) DAOFactory.build(GroupDAO.class,
					user);
			GroupWebParam params = new GroupWebParam();

			for (int i = 0; i <= list.size()-1; i++) {
				params.set_ne_groupId(String.valueOf(list.get(i).getGroupid()));
				classify = groupdao.query(params);
				gs.add((GroupVO)classify.getDatas().get(0));
			}
		vo.setGs(gs);
		vo.setDp(classify);
		return vo;
	}
	private CourseVO fillUser(CourseVO vo) throws Exception {
		MemberDAO dao = (MemberDAO) DAOFactory.build(MemberDAO.class, user);
		if(vo.getCreator()==null){
			String c=null;
			vo.setCreatername(c);
		}else{
			MemberVO c = (MemberVO) dao.findByPk(Integer.valueOf(vo.getCreator()));
			vo.setCreatername(c.getMbPetName());
		}
		return vo;
	}
	public void doDel(List<String> list) throws Exception {
		try {
			CourseDAO dao = (CourseDAO) DAOFactory.build(CourseDAO.class,user);
			for (int i = 0; i < list.size(); i++) {
				dao.removeByPk(Integer.valueOf(list.get(i)));
			}
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
}
