package com.manage.message.persistent;

import com.core.jop.infrastructure.db.AbstractDAO;

/**
 * Title: MessageDAO
 * @author chenlei
 * @version 1.0
 */
public class MessageDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public MessageDAO(){
        super(MessageVO.class);
    }
}
