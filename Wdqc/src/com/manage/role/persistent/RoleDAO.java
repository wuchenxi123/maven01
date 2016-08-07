package com.manage.role.persistent;

import com.core.jop.infrastructure.db.AbstractDAO;

/**
 * Title: RoleDAO
 * @author chenlei
 * @version 1.0
 */
public class RoleDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public RoleDAO(){
        super(RoleVO.class);
    }
}
