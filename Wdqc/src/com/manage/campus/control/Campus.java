package com.manage.campus.control;

import java.io.Serializable;

import com.manage.campus.persistent.CampusDBParam;
import com.manage.campus.persistent.CampusVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Campus
 * @author Hujj
 * @version 1.0
 */
public interface Campus extends AbstractControl {
    public CampusVO doCreate(CampusVO vo)
        throws Exception;

    public void doRemoveByVO(CampusVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CampusVO doUpdate(CampusVO vo)
        throws Exception;

    public CampusVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(CampusDBParam params)
        throws Exception;

}
