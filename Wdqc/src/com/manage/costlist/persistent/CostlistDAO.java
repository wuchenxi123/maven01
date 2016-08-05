package com.manage.costlist.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import com.core.jop.infrastructure.db.AbstractDAO;
import com.core.jop.infrastructure.db.hibernate3.Hibernate3SessionManager;

/**
 * Title: CostlistDAO
 * @author Hujj
 * @version 1.0
 */
public class CostlistDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public CostlistDAO(){
        super(CostlistVO.class);
    }
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
		try {
			ds = con.prepareStatement("delete from ms_costlist where clt_id = ?");
			
			for (int i = 0; i < list.size(); i++) {
				Integer sbId = Integer.valueOf(list.get(i).trim());
				ds.setInt(1, sbId);
				ds.addBatch();
				
				
			}
			
			boolean ac = con.getAutoCommit();
			if (ac) {
				con.setAutoCommit(false);
			}
			
			ds.executeBatch();
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
