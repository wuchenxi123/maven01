package com.manage.teachercourse.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import com.core.jop.infrastructure.db.AbstractDAO;
import com.core.jop.infrastructure.db.hibernate3.Hibernate3SessionManager;

/**
 * Title: courseGroupDAO
 * @author 
 * @version 1.0
 */
public class TeacherCourseDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public TeacherCourseDAO(){
        super(TeacherCourseVO.class);
    }

	public void doBatchUpdate(List<TeacherCourseVO> list, Integer teId) throws SQLException{
		// TODO Auto-generated method stub
		/**
	     * 批量更新多个应用
	     * @param list
	     * @throws SQLException
	     */
	    	Hibernate3SessionManager sm = (Hibernate3SessionManager) this
					.getSessionManager();
			Connection con = ((Session) sm.getCurrentSession()).connection();
//			PreparedStatement ds = null;
			PreparedStatement dsi = null;
			try {
//				ds = con.prepareStatement("delete from ms_teacher_course where te_id = ?");
				dsi = con.prepareStatement("insert into ms_teacher_course(te_id,co_id) values(?,?)");
				
				for (TeacherCourseVO teacherCourseVO : list) {
					dsi.setInt(1, teacherCourseVO.getTeid());
					dsi.setInt(2, teacherCourseVO.getCoid());
					dsi.addBatch();
				}
				boolean ac = con.getAutoCommit();
				if (ac) {
					con.setAutoCommit(false);
				}
//				if(teId!=0){
//					ds.setInt(1, teId);
//					ds.execute();
//				}
				dsi.executeBatch();
				con.commit();
				con.setAutoCommit(ac);
			} catch (Exception e) {
				e.printStackTrace();
				con.rollback();
			} finally {
				if (null!=dsi) {
//					ds.close();
					dsi.close();
				}
			}
	    }
}
