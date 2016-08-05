package com.manage.coursegroup.persistent;

import com.core.jop.infrastructure.db.AbstractDAO;

/**
 * Title: courseGroupDAO
 * @author 
 * @version 1.0
 */
public class CourseGroupDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public CourseGroupDAO(){
        super(CourseGroupVO.class);
    }
}
