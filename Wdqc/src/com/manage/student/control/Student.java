package com.manage.student.control;

import java.io.Serializable;
import java.util.List;

import com.manage.student.persistent.StudentDBParam;
import com.manage.student.persistent.StudentVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Student
 * @author Hujj
 * @version 1.0
 */
public interface Student extends AbstractControl {
    public StudentVO doCreate(StudentVO vo)
        throws Exception;

    public void doRemoveByVO(StudentVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public StudentVO doUpdate(StudentVO vo)
        throws Exception;

    public StudentVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(StudentDBParam params)
        throws Exception;
	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void doDel(List<String> ids) throws Exception;
}
