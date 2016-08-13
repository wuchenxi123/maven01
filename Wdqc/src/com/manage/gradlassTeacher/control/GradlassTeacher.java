package com.manage.gradlassTeacher.control;

import java.io.Serializable;
import java.util.List;

import com.manage.gradlassTeacher.persistent.GradlassTeacherDBParam;
import com.manage.gradlassTeacher.persistent.GradlassTeacherVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: GradlassTeacher
 * @author 
 * @version 1.0
 */
public interface GradlassTeacher extends AbstractControl {
    public GradlassTeacherVO doCreate(GradlassTeacherVO vo)
        throws Exception;

    public void doRemoveByVO(GradlassTeacherVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public GradlassTeacherVO doUpdate(GradlassTeacherVO vo)
        throws Exception;

    public GradlassTeacherVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(GradlassTeacherDBParam params)
        throws Exception;
	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void doDel(List<String> ids) throws Exception;
}
