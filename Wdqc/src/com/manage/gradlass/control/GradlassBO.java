package com.manage.gradlass.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.campus.persistent.CampusDAO;
import com.manage.campus.persistent.CampusVO;
import com.manage.classroom.persistent.ClassroomDAO;
import com.manage.classroom.persistent.ClassroomVO;
import com.manage.course.persistent.CourseDAO;
import com.manage.course.persistent.CourseVO;
import com.manage.gradlass.persistent.GradlassDAO;
import com.manage.gradlass.persistent.GradlassDBParam;
import com.manage.gradlass.persistent.GradlassVO;
import com.manage.gradlassTeacher.persistent.GradlassTeacherDAO;
import com.manage.gradlassTeacher.persistent.GradlassTeacherVO;
import com.manage.gradlassTeacher.web.GradlassTeacherWebParam;
import com.manage.teacher.persistent.TeacherDAO;
import com.manage.teacher.persistent.TeacherVO;
import com.manage.teacher.web.TeacherWebParam;

/**
 * Title: GradlassBO
 * 
 * @author Hujj
 * @version 1.0
 */
public class GradlassBO extends AbstractControlBean implements Gradlass {
	public GradlassVO doCreate(GradlassVO vo) throws Exception {
		try {
			GradlassDAO dao = (GradlassDAO) DAOFactory.build(GradlassDAO.class,
					user);
			GradlassTeacherDAO gtdao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class,
					user);
			GradlassVO go=(GradlassVO) dao.create(vo);
			List<TeacherVO> teaAll=go.getTeaList();
			System.out.println(teaAll);
			if(teaAll.size()>0&&teaAll!=null&&teaAll.get(0).getTeId()!=null){
				for (TeacherVO teacherVO : teaAll) {
					GradlassTeacherVO gto=new GradlassTeacherVO();
					gto.setGradlassid(go.getCsId().intValue());
					gto.setTeacherid(teacherVO.getTeId().intValue());
					gtdao.create(gto);
				}
			}
			vo.setGradlassTeacher(go.getCsId().intValue());
//			vo=this.doUpdate(go,1);
			return go;
			
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
	
	public void doRemoveByVO(GradlassVO vo) throws Exception {
		try {
			GradlassDAO dao = (GradlassDAO) DAOFactory.build(GradlassDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			GradlassDAO dao = (GradlassDAO) DAOFactory.build(GradlassDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public GradlassVO doUpdate(GradlassVO vo,int flag) throws Exception {
		try {
			GradlassDAO dao = (GradlassDAO) DAOFactory.build(GradlassDAO.class,
					user);
			GradlassTeacherDAO gtdao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class,
					user);
			// TODO set the pk */
			GradlassVO go=(GradlassVO) dao.update(vo);
			if(flag!=1){
				List<TeacherVO> teaAll=go.getTeaList();
				List<GradlassTeacherVO> list=new ArrayList<GradlassTeacherVO>();
				if(teaAll.size()>0&&teaAll!=null){
					for (TeacherVO teacherVO : teaAll) {
						GradlassTeacherVO gto=new GradlassTeacherVO();
						gto.setGradlassid(go.getCsId().intValue());
						gto.setTeacherid(teacherVO.getTeId().intValue());
						list.add(gto);
					}
					gtdao.doBatchUpdate(list,vo.getCsId().intValue());
				}
			}
			return go;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
	public GradlassVO doUpdateNew(GradlassVO vo) throws Exception {
		try {
			GradlassDAO dao = (GradlassDAO) DAOFactory.build(GradlassDAO.class,user);
			return (GradlassVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
	public GradlassVO doFindByPk(Serializable pk) throws Exception {
		GradlassDAO dao = (GradlassDAO) DAOFactory.build(GradlassDAO.class,
				user);
		return (GradlassVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(GradlassDBParam params) throws Exception {
		GradlassDAO dao = (GradlassDAO) DAOFactory.build(GradlassDAO.class,
				user);
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				GradlassVO o = (GradlassVO) vo;
				if(o.getCoId()!=null){
					this.fillCourse(o);
				}
				if(o.getCrId()!=null){
					this.fillClassroom(o);
				}
				if(o.getCpId()!=null){
					this.fillCampus(o);	
				}
				if(o.getGradlassTeacher()!=null){
					this.fillTeacher(o);
				}
				if(("1").equals(o.getCsOpendatestatus())){
				if(o.getCsWeekend()!=null){
					o.setTimeFrame(o.getCsWeekend() + "-"
							+ o.getCsDateStartHour() + ":"
							+ o.getCsDateStartMinute() + "--"
							+ o.getCsDateEndHour() + ":" + o.getCsDateEndMinute());
					}
				}
			}
		}

		return dao.query(params);
	}

	private GradlassVO fillCourse(GradlassVO vo) throws Exception {
		CourseDAO dao = (CourseDAO) DAOFactory.build(CourseDAO.class, user);
		CourseVO c = (CourseVO) dao.findByPk(Integer.valueOf(vo.getCoId()));
		vo.setCoName(c.getCoName());
		return vo;
	}

	private GradlassVO fillClassroom(GradlassVO vo) throws Exception {
		ClassroomDAO dao = (ClassroomDAO) DAOFactory.build(ClassroomDAO.class,
				user);
		ClassroomVO c = (ClassroomVO) dao.findByPk(Long.valueOf(vo.getCrId()));
		vo.setCrName(c.getCrName());
		return vo;
	}

	private GradlassVO fillCampus(GradlassVO vo) throws Exception {
		CampusDAO dao = (CampusDAO) DAOFactory.build(CampusDAO.class, user);	
		if(vo.getCpId()==null){
			String c=null;
			vo.setCpName(c);
		}
		else{
		CampusVO c = (CampusVO) dao.findByPk(Long.valueOf(vo.getCpId()));
		vo.setCpName(c.getCpName());
		}
		return vo;
	}

	private GradlassVO fillTeacher(GradlassVO vo) throws Exception {
		String teacherName = "";
		DataPackage teachers = null;
		List<TeacherVO> teaList=new ArrayList<TeacherVO>();
		if (vo.getGradlassTeacher() > 0) {
			GradlassTeacherDAO dao = (GradlassTeacherDAO) DAOFactory.build(
					GradlassTeacherDAO.class, user);
			GradlassTeacherWebParam gtparams = new GradlassTeacherWebParam();
			gtparams.set_ne_gradlassid(String.valueOf(vo.getGradlassTeacher()));
			DataPackage teas = dao.query(gtparams);
			List<GradlassTeacherVO> list = teas.getDatas();
			TeacherDAO teadao = (TeacherDAO) DAOFactory.build(TeacherDAO.class,user);
			TeacherWebParam params = new TeacherWebParam();

			for (int i = 0; i < list.size(); i++) {
				System.out.println(String.valueOf(list.get(i).getTeacherid()));
				params.set_ne_teId(String.valueOf(list.get(i).getTeacherid()));
				teachers = teadao.query(params);
				System.out.println(teachers.getDatas().get(0));
				teaList.add((TeacherVO) teachers.getDatas().get(0));
				
			}
			vo.setTeaList(teaList);
//			vo.getD().setDatas(teaList);
		}

		return vo;
	}

	/**
	 * 删除
	 */
	public void doDel(List<String> ids) throws Exception {
		GradlassDAO dao = (GradlassDAO) DAOFactory.build(
				GradlassDAO.class, user);
		dao.doDel(ids);
	}
}
