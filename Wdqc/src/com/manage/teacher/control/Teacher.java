package com.manage.teacher.control;

import java.io.Serializable;
import java.util.List;

import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.teacher.persistent.TeacherDBParam;
import com.manage.teacher.persistent.TeacherVO;

/**
 * Title: Teacher
 * @author 
 * @version 1.0
 */
public interface Teacher extends AbstractControl {
    public TeacherVO doCreate(TeacherVO vo)
        throws Exception;

    public void doRemoveByVO(TeacherVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public TeacherVO doUpdate(TeacherVO vo)
        throws Exception;

    public TeacherVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(TeacherDBParam params)
        throws Exception;

	public void doDel(List<String> list) throws Exception;;
}
