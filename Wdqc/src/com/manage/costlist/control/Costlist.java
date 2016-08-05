package com.manage.costlist.control;

import java.io.Serializable;
import java.util.List;

import com.manage.costlist.persistent.CostlistDBParam;
import com.manage.costlist.persistent.CostlistVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Costlist
 * @author Hujj
 * @version 1.0
 */
public interface Costlist extends AbstractControl {
    public CostlistVO doCreate(CostlistVO vo)
        throws Exception;

    public void doRemoveByVO(CostlistVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CostlistVO doUpdate(CostlistVO vo)
        throws Exception;

    public CostlistVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(CostlistDBParam params)
        throws Exception;
	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void doDel(List<String> ids) throws Exception;
}
