package com.manage.studentclass.control;

import java.io.Serializable;
import java.util.List;

import com.manage.studentclass.persistent.StudentclassDBParam;
import com.manage.studentclass.persistent.StudentclassVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Studentclass
 * @author Hujj
 * @version 1.0
 */
public interface Studentclass extends AbstractControl {
    public StudentclassVO doCreate(StudentclassVO vo)
        throws Exception;

    public void doRemoveByVO(StudentclassVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public StudentclassVO doUpdate(StudentclassVO vo)
        throws Exception;

    public StudentclassVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(StudentclassDBParam params)
        throws Exception;
    /**
	 * 批量删除
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void doDel(List<String> ids) throws Exception;

}
