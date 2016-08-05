package com.manage.group.control;

import java.io.Serializable;

import com.manage.group.persistent.GroupDBParam;
import com.manage.group.persistent.GroupVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Group
 * @author 
 * @version 1.0
 */
public interface Group extends AbstractControl {
    public GroupVO doCreate(GroupVO vo)
        throws Exception;

    public void doRemoveByVO(GroupVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public GroupVO doUpdate(GroupVO vo)
        throws Exception;

    public GroupVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(GroupDBParam params)
        throws Exception;

}
