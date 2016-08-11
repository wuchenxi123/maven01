package com.manage.studentclass.persistent;

import com.core.jop.infrastructure.db.DBQueryParam;

/**
 * Title: StudentclassDBParam
 * @author Hujj
 * @version 1.0
 */
public class StudentclassDBParam extends DBQueryParam {
    private String _ne_scId;
    private String _ne_stId;
    private String _ne_csId;
    private String _ne_creator;
    private String _dnm_createTime;
    private String _de_createTime;
    private String _dnl_createTime;

	/**
     * @return Returns the _ne_scId.
     */
    public String get_ne_scId() {
        return this._ne_scId;
    }
    /**
     * @param _sk_companyname The _ne_scId to set.
     */
    public void set_ne_scId(String _ne_scId) {
        this._ne_scId = _ne_scId;
    }

	/**
     * @return Returns the _ne_stId.
     */
    public String get_ne_stId() {
        return this._ne_stId;
    }
    /**
     * @param _sk_companyname The _ne_stId to set.
     */
    public void set_ne_stId(String _ne_stId) {
        this._ne_stId = _ne_stId;
    }

	/**
     * @return Returns the _ne_csId.
     */
    public String get_ne_csId() {
        return this._ne_csId;
    }
    /**
     * @param _sk_companyname The _ne_csId to set.
     */
    public void set_ne_csId(String _ne_csId) {
        this._ne_csId = _ne_csId;
    }

	/**
     * @return Returns the _ne_creator.
     */
    public String get_ne_creator() {
        return this._ne_creator;
    }
    /**
     * @param _sk_companyname The _ne_creator to set.
     */
    public void set_ne_creator(String _ne_creator) {
        this._ne_creator = _ne_creator;
    }

	/**
     * @return Returns the _dnm_createTime.
     */
    public String get_dnm_createTime() {
        return this._dnm_createTime;
    }
    /**
     * @param _sk_companyname The _dnm_createTime to set.
     */
    public void set_dnm_createTime(String _dnm_createTime) {
        this._dnm_createTime = _dnm_createTime;
    }

	/**
     * @return Returns the _de_createTime.
     */
    public String get_de_createTime() {
        return this._de_createTime;
    }
    /**
     * @param _sk_companyname The _de_createTime to set.
     */
    public void set_de_createTime(String _de_createTime) {
        this._de_createTime = _de_createTime;
    }

	/**
     * @return Returns the _dnl_createTime.
     */
    public String get_dnl_createTime() {
        return this._dnl_createTime;
    }
    /**
     * @param _sk_companyname The _dnl_createTime to set.
     */
    public void set_dnl_createTime(String _dnl_createTime) {
        this._dnl_createTime = _dnl_createTime;
    }

}
