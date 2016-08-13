package com.manage.role.control;

import java.io.Serializable;

import com.manage.role.persistent.RoleDBParam;
import com.manage.role.persistent.RoleVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Role
 * @author chenlei
 * @version 1.0
 */
public interface Role extends AbstractControl {
    public RoleVO doCreate(RoleVO vo)
        throws Exception;

    public void doRemoveByVO(RoleVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RoleVO doUpdate(RoleVO vo)
        throws Exception;

    public RoleVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(RoleDBParam params)
        throws Exception;

}
