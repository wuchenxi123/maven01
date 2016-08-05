package com.manage.coursegroup.control;

import java.io.Serializable;

import com.manage.coursegroup.persistent.CourseGroupDBParam;
import com.manage.coursegroup.persistent.CourseGroupVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: courseGroup
 * @author 
 * @version 1.0
 */
public interface CourseGroup extends AbstractControl {
    public CourseGroupVO doCreate(CourseGroupVO vo)
        throws Exception;

    public void doRemoveByVO(CourseGroupVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CourseGroupVO doUpdate(CourseGroupVO vo)
        throws Exception;

    public CourseGroupVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(CourseGroupDBParam params)
        throws Exception;

}
