package com.manage.course.control;

import java.io.Serializable;
import java.util.List;

import com.manage.course.persistent.CourseDBParam;
import com.manage.course.persistent.CourseVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Course
 * @author Hujj
 * @version 1.0
 */
public interface Course extends AbstractControl {
    public CourseVO doCreate(CourseVO vo)
        throws Exception;

    public void doRemoveByVO(CourseVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CourseVO doUpdate(CourseVO vo)
        throws Exception;

    public CourseVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(CourseDBParam params)
        throws Exception;

	public void doDel(List<String> list) throws Exception;

}
