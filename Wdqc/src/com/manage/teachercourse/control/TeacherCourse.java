package com.manage.teachercourse.control;

import java.io.Serializable;
import java.util.List;

import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.teachercourse.persistent.TeacherCourseDBParam;
import com.manage.teachercourse.persistent.TeacherCourseVO;


/**
 * Title: TeacherCourse
 * @author 
 * @version 1.0
 */
public interface TeacherCourse extends AbstractControl {
    public TeacherCourseVO doCreate(TeacherCourseVO vo)
        throws Exception;

    public void doRemoveByVO(TeacherCourseVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public TeacherCourseVO doUpdate(TeacherCourseVO vo)
        throws Exception;

    public TeacherCourseVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(TeacherCourseDBParam params)
        throws Exception;

	public void doDel(List<String> list) throws Exception;

}
