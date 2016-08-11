package com.manage.classroom.control;

import java.io.Serializable;
import java.util.List;

import com.manage.classroom.persistent.ClassroomDBParam;
import com.manage.classroom.persistent.ClassroomVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Classroom
 * @author Hujj
 * @version 1.0
 */
public interface Classroom extends AbstractControl {
    public ClassroomVO doCreate(ClassroomVO vo)
        throws Exception;

    public void doRemoveByVO(ClassroomVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ClassroomVO doUpdate(ClassroomVO vo)
        throws Exception;

    public ClassroomVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ClassroomDBParam params)
        throws Exception;

	public void doDel(List<String> list) throws Exception;


}
