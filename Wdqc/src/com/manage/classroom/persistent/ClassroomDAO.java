package com.manage.classroom.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import com.core.jop.infrastructure.db.AbstractDAO;
import com.core.jop.infrastructure.db.hibernate3.Hibernate3SessionManager;

/**
 * Title: ClassroomDAO
 * @author Hujj
 * @version 1.0
 */
public class ClassroomDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ClassroomDAO(){
        super(ClassroomVO.class);
    }
}
