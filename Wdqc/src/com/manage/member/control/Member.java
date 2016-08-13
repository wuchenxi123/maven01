package com.manage.member.control;

import java.io.Serializable;
import java.util.List;

import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.member.persistent.MemberDBParam;
import com.manage.member.persistent.MemberVO;

/**
 * Title: Member
 * @author Hujj
 * @version 1.0
 */
public interface Member extends AbstractControl {
    public MemberVO doCreate(MemberVO vo)
        throws Exception;

    public void doRemoveByVO(MemberVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public MemberVO doUpdate(MemberVO vo)
        throws Exception;

    public MemberVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(MemberDBParam params)
        throws Exception;
    public void doDel(List<String> ids)
            throws Exception;
}
