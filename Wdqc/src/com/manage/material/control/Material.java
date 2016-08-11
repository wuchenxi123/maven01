package com.manage.material.control;

import java.io.Serializable;
import java.util.List;

import com.manage.material.persistent.MaterialDBParam;
import com.manage.material.persistent.MaterialVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Material
 * @author Hujj
 * @version 1.0
 */
public interface Material extends AbstractControl {
    public MaterialVO doCreate(MaterialVO vo)
        throws Exception;

    public void doRemoveByVO(MaterialVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public MaterialVO doUpdate(MaterialVO vo)
        throws Exception;

    public MaterialVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(MaterialDBParam params)
        throws Exception;
	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void doDel(List<String> ids) throws Exception;
}
