package com.manage.saler.control;

import java.io.Serializable;

import com.manage.saler.persistent.SalerDBParam;
import com.manage.saler.persistent.SalerVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Saler
 * @author Hujj
 * @version 1.0
 */
public interface Saler extends AbstractControl {
    public SalerVO doCreate(SalerVO vo)
        throws Exception;

    public void doRemoveByVO(SalerVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SalerVO doUpdate(SalerVO vo)
        throws Exception;

    public SalerVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(SalerDBParam params)
        throws Exception;

}
