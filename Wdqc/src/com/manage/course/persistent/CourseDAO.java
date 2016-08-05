package com.manage.course.persistent;

import com.core.jop.infrastructure.db.AbstractDAO;

/**
 * Title: CourseDAO
 * @author 
 * @version 1.0
 */
public class CourseDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public CourseDAO(){
        super(CourseVO.class);
    }
}
