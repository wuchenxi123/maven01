package com.manage.gradlass.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.core.jop.infrastructure.db.AbstractDAO;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.hibernate3.Hibernate3SessionManager;
import com.manage.gradlassTeacher.persistent.GradlassTeacherDAO;
import com.manage.gradlassTeacher.persistent.GradlassTeacherVO;
import com.manage.teacher.persistent.TeacherVO;

/**
 * Title: GradlassDAO
 * @author Hujj
 * @version 1.0
 */
public class GradlassDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public GradlassDAO(){
        super(GradlassVO.class);
    }
    
    /**
     * 批量添加多个应用
     * @param list
     * @throws SQLException
     */
    /*
    public GradlassVO doCreate(GradlassVO vo,DBAccessUser user) throws SQLException {
    	Hibernate3SessionManager sm = (Hibernate3SessionManager) this
				.getSessionManager();
		Connection con = ((Session) sm.getCurrentSession()).connection();
		con.setAutoCommit(false);
		sm.setSessionFactory((SessionFactory) con);
		GradlassDAO dao = (GradlassDAO) DAOFactory.build(GradlassDAO.class,
				user);
		GradlassTeacherDAO gtdao = (GradlassTeacherDAO) DAOFactory.build(GradlassTeacherDAO.class,
				user);
		dao.setSessionManager(sm);
		
		gtdao.setSessionManager(sm);
		PreparedStatement ds = null;
		PreparedStatement dsi = null;
		try {
			GradlassVO gvo=(GradlassVO) dao.create(vo);
			ds = con.prepareStatement("insert into ms_gradlass " +
					"(co_id,co_classify,cr_id,cs_name,cp_id,gradlassTeacher," +
					"cs_charge,cs_classHour,cs_everyClass,cs_openDateStart,cs_openDateEnd," +
					"cs_openDateStatus,cs_classroomId,cs_weekend,cs_dateStartHour," +
					"cs_dateStartMinute,cs_dateEndHour ,cs_dateEndMinute,cs_peopleCount," +
					"cs_arriveInform,cs_remark,cs_tuition) " +
					"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
			for (int i = 1; i <= 22; i++) {
				ds.setInt(i, vo.getCoId());
				ds.setInt(i, vo.getCoClassify());
				ds.setInt(i, vo.getCrId());
				ds.setString(i, vo.getCsName());
				ds.setInt(i, vo.getCpId());
				ds.setInt(i, vo.getGradlassTeacher());
				ds.setDouble(i, vo.get);
			}
			List<TeacherVO> teaAll=vo.getTeaList();
			if(teaAll.size()>0&&teaAll!=null){
				for (TeacherVO teacherVO : teaAll) {
					GradlassTeacherVO gto=new GradlassTeacherVO();
					gto.setGradlassid(vo.getCsId().intValue());
					gto.setTeacherid(teacherVO.getTeId().intValue());
					gtdao.create(gto);
				}
			}
			boolean ac = con.getAutoCommit();
			if (ac) {
				con.setAutoCommit(false);
			}
			int a=3;
			 int b=0;
			 
				int c=a/b;
				System.out.println(c);
			con.commit();
			con.setAutoCommit(ac);
			return gvo;
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			return null;
		} finally {
//			if (null != ds) {
//				ds.close();
//			}
		}
		
    }
    */
    /**
     * 批量删除多个应用
     * @param list
     * @throws SQLException
     */
    public void doDel(List<String> list) throws SQLException {
    	Hibernate3SessionManager sm = (Hibernate3SessionManager) this
				.getSessionManager();
		Connection con = ((Session) sm.getCurrentSession()).connection();
		PreparedStatement ds = null;
		PreparedStatement dsi = null;
		PreparedStatement dsii = null;
		PreparedStatement dsiii = null;
		try {
			ds = con.prepareStatement("delete from ms_class_teacher where gradlassId = ?");
			dsi = con.prepareStatement("delete from ms_gradlass where cs_id = ?");
			dsii = con.prepareStatement("delete from ms_studentclass where cs_id = ?");
			dsiii = con.prepareStatement("delete from ms_costlist where cs_id = ?");
			for (int i = 0; i < list.size(); i++) {
				Integer sbId = Integer.valueOf(list.get(i).trim());
				ds.setInt(1, sbId);
				ds.addBatch();
				
				dsi.setInt(1, sbId);
				dsi.addBatch();
				
				dsii.setInt(1, sbId);
				dsii.addBatch();
				
				dsiii.setInt(1, sbId);
				dsiii.addBatch();
			}
			
			boolean ac = con.getAutoCommit();
			if (ac) {
				con.setAutoCommit(false);
			}
			ds.executeBatch();
			dsii.executeBatch();
			
			dsiii.executeBatch();
			dsi.executeBatch();
			
			con.commit();
			con.setAutoCommit(ac);
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			if (null != ds) {
				ds.close();
			}
		}
    }
}
