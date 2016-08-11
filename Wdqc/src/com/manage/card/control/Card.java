package com.manage.card.control;

import java.io.Serializable;

import com.manage.card.persistent.CardDBParam;
import com.manage.card.persistent.CardVO;
import com.core.jop.infrastructure.control.AbstractControl;
import com.core.jop.infrastructure.db.DBAccessUser;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: Card
 * @author Hujj
 * @version 1.0
 */
public interface Card extends AbstractControl {
    public CardVO doCreate(CardVO vo)
        throws Exception;

    public void doRemoveByVO(CardVO vo)
        throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CardVO doUpdate(CardVO vo)
        throws Exception;

    public CardVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(CardDBParam params)
        throws Exception;

}
