package com.manage.costlist.web;

import com.manage.costlist.persistent.CostlistVO;

/**
 * Title: CostlistForm
 * @author Hujj
 * @version 1.0
 */
public class CostlistForm extends CostlistVO {
	private int costcum;

	public int getCostcum() {
		return costcum;
	}

	public void setCostcum(int costcum) {
		this.costcum = costcum;
	}
}
