package com.manage.gradlass.control;

import java.io.Serializable;
import java.util.List;

import com.manage.gradlass.persistent.GradlassDBParam;
import com.manage.gradlass.persistent.GradlassVO;
import com.manage.gradlass.web.GradlassWebParam;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Gradlass
 * @author Hujj
 * @version 1.0
 */
public interface Gradlass extends AbstractControl {
    public GradlassVO doCreate(GradlassVO vo)
        throws Exception;

    public void doRemoveByVO(GradlassVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public GradlassVO doUpdate(GradlassVO vo,int flag)
        throws Exception;

    public GradlassVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(GradlassDBParam params)
        throws Exception;
    /**
	 * 批量删除
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void doDel(List<String> ids) throws Exception;

	public DataPackage doQuerySumIncome(GradlassWebParam params)throws Exception;
}
