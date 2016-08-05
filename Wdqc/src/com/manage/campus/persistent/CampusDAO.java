package com.manage.campus.persistent;

import com.core.jop.infrastructure.db.AbstractDAO;

/**
 * Title: CampusDAO
 * @author Hujj
 * @version 1.0
 */
public class CampusDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public CampusDAO(){
        super(CampusVO.class);
    }
}
