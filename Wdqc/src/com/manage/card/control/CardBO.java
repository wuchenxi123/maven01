package com.manage.card.control;

import java.io.Serializable;

import com.manage.card.persistent.CardDBParam;
import com.manage.card.persistent.CardDAO;
import com.manage.card.persistent.CardVO;
import com.core.jop.infrastructure.control.AbstractControlBean;
import com.core.jop.infrastructure.db.DAOFactory;
import com.core.jop.infrastructure.db.DataPackage;

/**
 * Title: CardBO
 * @author Hujj
 * @version 1.0
 */
public class CardBO extends AbstractControlBean implements
		Card {

	public CardVO doCreate(CardVO vo) throws Exception {
		try {
			CardDAO dao = (CardDAO) DAOFactory.build(CardDAO.class, user);
			// TODO set the pk */
			return (CardVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByVO(CardVO vo) throws Exception {
		try {
			CardDAO dao = (CardDAO) DAOFactory.build(CardDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CardDAO dao = (CardDAO) DAOFactory.build(CardDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CardVO doUpdate(CardVO vo) throws Exception {
		try {
			CardDAO dao = (CardDAO) DAOFactory.build(CardDAO.class,user);
			return (CardVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CardVO doFindByPk(Serializable pk) throws Exception {
		CardDAO dao = (CardDAO) DAOFactory.build(CardDAO.class,user);
		return (CardVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CardDBParam params)
			throws Exception {
		CardDAO dao = (CardDAO) DAOFactory.build(CardDAO.class,user);
		return dao.query(params);
	}
}
