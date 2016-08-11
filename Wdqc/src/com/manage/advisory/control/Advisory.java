package com.manage.advisory.control;

import java.io.Serializable;
import java.util.List;

import com.manage.advisory.persistent.AdvisoryDBParam;
import com.manage.advisory.persistent.AdvisoryVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Advisory
 * @author Hujj
 * @version 1.0
 */
public interface Advisory extends AbstractControl {
    public AdvisoryVO doCreate(AdvisoryVO vo)
        throws Exception;

    public void doRemoveByVO(AdvisoryVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AdvisoryVO doUpdate(AdvisoryVO vo)
        throws Exception;

    public AdvisoryVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(AdvisoryDBParam params)
        throws Exception;
    
	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void doDel(List<String> ids) throws Exception;

}
