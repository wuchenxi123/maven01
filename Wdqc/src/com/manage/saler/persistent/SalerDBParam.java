package com.manage.saler.persistent;

import com.core.jop.infrastructure.db.DBQueryParam;

/**
 * Title: SalerDBParam
 * @author Hujj
 * @version 1.0
 */
public class SalerDBParam extends DBQueryParam {
    private String _ne_slId;
    private String _ne_cpId;
    private String _se_slName;
    private String _sk_slName;
    private String _ne_slAcheive;

	/**
     * @return Returns the _ne_slId.
     */
    public String get_ne_slId() {
        return this._ne_slId;
    }
    /**
     * @param _sk_companyname The _ne_slId to set.
     */
    public void set_ne_slId(String _ne_slId) {
        this._ne_slId = _ne_slId;
    }

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
     * @return Returns the _se_slName.
     */
    public String get_se_slName() {
        return this._se_slName;
    }
    /**
     * @param _sk_companyname The _se_slName to set.
     */
    public void set_se_slName(String _se_slName) {
        this._se_slName = _se_slName;
    }

	/**
     * @return Returns the _sk_slName.
     */
    public String get_sk_slName() {
        return this._sk_slName;
    }
    /**
     * @param _sk_companyname The _sk_slName to set.
     */
    public void set_sk_slName(String _sk_slName) {
        this._sk_slName = _sk_slName;
    }

	/**
     * @return Returns the _ne_slAcheive.
     */
    public String get_ne_slAcheive() {
        return this._ne_slAcheive;
    }
    /**
     * @param _sk_companyname The _ne_slAcheive to set.
     */
    public void set_ne_slAcheive(String _ne_slAcheive) {
        this._ne_slAcheive = _ne_slAcheive;
    }

}
