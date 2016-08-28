package com.manage.message.control;

import java.io.Serializable;
import java.util.List;

import com.manage.message.persistent.MessageDBParam;
import com.manage.message.persistent.MessageVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Message
 * @author chenlei
 * @version 1.0
 */
public interface Message extends AbstractControl {
    public MessageVO doCreate(MessageVO vo)
        throws Exception;

    public void doRemoveByVO(MessageVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public MessageVO doUpdate(MessageVO vo)
        throws Exception;

    public MessageVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(MessageDBParam params)
        throws Exception;

	public void doDel(List<String> list) throws Exception;

}
