package com.manage.member.persistent;

import com.core.jop.infrastructure.db.AbstractDAO;

/**
 * Title: MemberDAO
 * @author Hujj
 * @version 1.0
 */
public class MemberDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public MemberDAO(){
        super(MemberVO.class);
    }
}
