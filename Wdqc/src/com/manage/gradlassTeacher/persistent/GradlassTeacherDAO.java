package com.manage.gradlassTeacher.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import com.core.jop.infrastructure.db.AbstractDAO;
import com.core.jop.infrastructure.db.hibernate3.Hibernate3SessionManager;

/**
 * Title: GradlassTeacherDAO
 * @author 
 * @version 1.0
 */
public class GradlassTeacherDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public GradlassTeacherDAO(){
        super(GradlassTeacherVO.class);
    }
    /**
     * 批量更新多个应用
     * @param list
     * @throws SQLException
     */
    public void doBatchUpdate(List<GradlassTeacherVO> list,int i) throws SQLException {
    	Hibernate3SessionManager sm = (Hibernate3SessionManager) this
				.getSessionManager();
		Connection con = ((Session) sm.getCurrentSession()).connection();
		PreparedStatement ds = null;
		PreparedStatement dsi = null;
		try {
			ds = con.prepareStatement("delete from ms_class_teacher where gradlassId = ?");
			dsi = con.prepareStatement("insert into ms_class_teacher(teacherId,gradlassId) values(?,?)");
			
			for (GradlassTeacherVO gradlassTeacherVO : list) {
				dsi.setInt(1, gradlassTeacherVO.getTeacherid());
				dsi.setInt(2, gradlassTeacherVO.getGradlassid());
				dsi.addBatch();
			}
			boolean ac = con.getAutoCommit();
			if (ac) {
				con.setAutoCommit(false);
			}
			if(i!=0){
				ds.setInt(1, i);
				ds.execute();
			}
			dsi.executeBatch();
			con.commit();
			con.setAutoCommit(ac);
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			if (null != ds||null!=dsi) {
				ds.close();
				dsi.close();
			}
		}
    }
}
