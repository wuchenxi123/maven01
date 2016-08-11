package com.manage.campus.persistent;

import com.core.jop.infrastructure.db.DBQueryParam;

/**
 * Title: CampusDBParam
 * @author Hujj
 * @version 1.0
 */
public class CampusDBParam extends DBQueryParam {
    private String _ne_cpId;
    private String _sk_cpName;
    private String _dnm_cpRecorddate;
    private String _de_cpRecorddate;
    private String _dnl_cpRecorddate;

	/**
     * @return Returns the _ne_cpId.
     */
    public String get_ne_cpId() {
        return this._ne_cpId;
    }
    /**
     * @param _sk_companyname The _ne_cpId to set.
     */
    public void set_ne_cpId(String _ne_cpId) {
        this._ne_cpId = _ne_cpId;
    }

	/**
     * @return Returns the _sk_cpName.
     */
    public String get_sk_cpName() {
        return this._sk_cpName;
    }
    /**
     * @param _sk_companyname The _sk_cpName to set.
     */
    public void set_sk_cpName(String _sk_cpName) {
        this._sk_cpName = _sk_cpName;
    }

	/**
     * @return Returns the _dnm_cpRecorddate.
     */
    public String get_dnm_cpRecorddate() {
        return this._dnm_cpRecorddate;
    }
    /**
     * @param _sk_companyname The _dnm_cpRecorddate to set.
     */
    public void set_dnm_cpRecorddate(String _dnm_cpRecorddate) {
        this._dnm_cpRecorddate = _dnm_cpRecorddate;
    }

	/**
     * @return Returns the _de_cpRecorddate.
     */
    public String get_de_cpRecorddate() {
        return this._de_cpRecorddate;
    }
    /**
     * @param _sk_companyname The _de_cpRecorddate to set.
     */
    public void set_de_cpRecorddate(String _de_cpRecorddate) {
        this._de_cpRecorddate = _de_cpRecorddate;
    }

	/**
     * @return Returns the _dnl_cpRecorddate.
     */
    public String get_dnl_cpRecorddate() {
        return this._dnl_cpRecorddate;
    }
    /**
     * @param _sk_companyname The _dnl_cpRecorddate to set.
     */
    public void set_dnl_cpRecorddate(String _dnl_cpRecorddate) {
        this._dnl_cpRecorddate = _dnl_cpRecorddate;
    }

}
