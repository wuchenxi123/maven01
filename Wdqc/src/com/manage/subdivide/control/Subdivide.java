package com.manage.subdivide.control;

import java.io.Serializable;

import com.manage.subdivide.persistent.SubdivideDBParam;
import com.manage.subdivide.persistent.SubdivideVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Subdivide
 * @author Hujj
 * @version 1.0
 */
public interface Subdivide extends AbstractControl {
    public SubdivideVO doCreate(SubdivideVO vo)
        throws Exception;

    public void doRemoveByVO(SubdivideVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SubdivideVO doUpdate(SubdivideVO vo)
        throws Exception;

    public SubdivideVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(SubdivideDBParam params)
        throws Exception;

}
