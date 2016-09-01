package com.manage.gradlass.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.control.BOFactory;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.campus.persistent.CampusDAO;
import com.manage.campus.persistent.CampusVO;
import com.manage.classroom.persistent.ClassroomDAO;
import com.manage.classroom.persistent.ClassroomVO;
import com.manage.costlist.control.Costlist;
import com.manage.costlist.control.CostlistBO;
import com.manage.costlist.persistent.CostlistVO;
import com.manage.costlist.web.CostlistWebParam;
import com.manage.course.persistent.CourseDAO;
import com.manage.course.persistent.CourseVO;
import com.manage.gradlass.persistent.GradlassDAO;
import com.manage.gradlass.persistent.GradlassDBParam;
import com.manage.gradlass.persistent.GradlassVO;
import com.manage.gradlass.web.GradlassWebParam;
import com.manage.gradlassTeacher.persistent.GradlassTeacherDAO;
import com.manage.gradlassTeacher.persistent.GradlassTeacherVO;
import com.manage.gradlassTeacher.web.GradlassTeacherWebParam;
import com.manage.student.persistent.StudentDAO;
import com.manage.student.persistent.StudentVO;
import com.manage.student.web.StudentWebParam;
import com.manage.studentclass.control.Studentclass;
import com.manage.studentclass.control.StudentclassBO;
import com.manage.studentclass.persistent.StudentclassDAO;
import com.manage.studentclass.persistent.StudentclassVO;
import com.manage.studentclass.web.StudentclassWebParam;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = -6541298178894978947L;
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
			vo=this.doUpdate(go,1);
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
				if(teaAll.size()>0&&teaAll.get(0).getTeId()!=null){
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
					this.fillStudent(o);
				}
				if(o.getCsWeekend()!=null){
					o.setTimeFrame(o.getCsDateStartHour() + ":"
							+ o.getCsDateStartMinute() + "--"
							+ o.getCsDateEndHour() + ":" + o.getCsDateEndMinute());
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
			System.out.println(vo.getCsId());
			for (int i = 0; i < list.size(); i++) {
				System.out.println(String.valueOf(list.get(i).getTeacherid()));
				params.set_ne_teId(String.valueOf(list.get(i).getTeacherid()));
				teachers = teadao.query(params);
				teaList.add((TeacherVO) teachers.getDatas().get(0));
				
			}
			vo.setTeaList(teaList);
		}

		return vo;
	}
	private GradlassVO fillStudent(GradlassVO vo) throws Exception {
		DataPackage students = null;
		List<StudentVO> stuList=new ArrayList<StudentVO>();
		StudentclassDAO dao = (StudentclassDAO) DAOFactory.build(
				StudentclassDAO.class, user);
		StudentclassWebParam scparams = new StudentclassWebParam();
		scparams.set_ne_csId(String.valueOf(vo.getGradlassTeacher()));
		DataPackage stus = dao.query(scparams);
		List<StudentclassVO> list = stus.getDatas();
		if(list.size()>0&&list!=null&&list.get(0).getCsId()!=null){
			StudentDAO studao = (StudentDAO) DAOFactory.build(StudentDAO.class,user);
			StudentWebParam params = new StudentWebParam();
			System.out.println(vo.getCsId());
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getStId()!=null){
					params.set_ne_stId(String.valueOf(list.get(i).getStId()));
					students = studao.query(params);
					stuList.add((StudentVO) students.getDatas().get(0));
				}
			}
		}
			vo.setStudentList(stuList);
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
	public DataPackage doQuerySumIncome(GradlassWebParam params)throws Exception {
		GradlassDAO dao = (GradlassDAO) DAOFactory.build(GradlassDAO.class,
				user);
		DataPackage dp = dao.query(params);
		
		StudentclassWebParam stparams = new StudentclassWebParam();
		Studentclass scbo = (Studentclass) BOFactory.build(StudentclassBO.class, user);
		
		CostlistWebParam clparams = new CostlistWebParam();
		Costlist clbo = (Costlist) BOFactory.build(CostlistBO.class, user);
		
		double sum;
		if (dp.getRowCount() > 0) {
			for (Object vo : dp.getDatas()) {
				sum=0;
				GradlassVO o = (GradlassVO) vo;
				stparams.set_ne_csId(o.getCsId().toString());
				DataPackage stdp = scbo.doQuery(stparams);
				List<StudentclassVO> scAll=stdp.getDatas();
				if(scAll!=null&&scAll.size()>0){
					for (StudentclassVO studentclassVO : scAll) {
						clparams.set_ne_csId(o.getCsId().toString());
						clparams.set_ne_stId(studentclassVO.getStId().toString());
						DataPackage cldp = clbo.doQuery(clparams);
						if(cldp.getDatas().size()>0){
							CostlistVO clvo=(CostlistVO)cldp.getDatas().get(0);
							sum=sum+clvo.getCltSum();
						}
						
					}
					o.setSumIncome(sum);
				}
				o.setSumIncome(sum);
			}
		}
		return dao.query(params);
	}
}
