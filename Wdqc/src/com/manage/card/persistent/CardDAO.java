package com.manage.card.persistent;

import com.core.jop.infrastructure.db.AbstractDAO;

/**
 * Title: CardDAO
 * @author Hujj
 * @version 1.0
 */
public class CardDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public CardDAO(){
        super(CardVO.class);
    }
}
