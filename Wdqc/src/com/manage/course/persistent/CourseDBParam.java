package com.manage.course.persistent;

import com.core.jop.infrastructure.db.DBQueryParam;

/**
 * Title: CourseDBParam
 * @author 
 * @version 1.0
 */
public class CourseDBParam extends DBQueryParam {
    private String _ne_coId;
    private String _se_coName;
    private String _sk_coName;
    private String _dnm_createtime;
    private String _dnl_createtime;
    private String _ne_creator;
    private String _dnm_updatetime;
    private String _dnl_updatetime;
    private String _ne_updator;
    private String _ne_coClassify;

	/**
     * @return Returns the _ne_coId.
     */
    public String get_ne_coId() {
        return this._ne_coId;
    }
    /**
     * @param _sk_companyname The _ne_coId to set.
     */
    public void set_ne_coId(String _ne_coId) {
        this._ne_coId = _ne_coId;
    }

	/**
     * @return Returns the _se_coName.
     */
    public String get_se_coName() {
        return this._se_coName;
    }
    /**
     * @param _sk_companyname The _se_coName to set.
     */
    public void set_se_coName(String _se_coName) {
        this._se_coName = _se_coName;
    }

	/**
     * @return Returns the _sk_coName.
     */
    public String get_sk_coName() {
        return this._sk_coName;
    }
    /**
     * @param _sk_companyname The _sk_coName to set.
     */
    public void set_sk_coName(String _sk_coName) {
        this._sk_coName = _sk_coName;
    }

	/**
     * @return Returns the _dnm_createtime.
     */
    public String get_dnm_createtime() {
        return this._dnm_createtime;
    }
    /**
     * @param _sk_companyname The _dnm_createtime to set.
     */
    public void set_dnm_createtime(String _dnm_createtime) {
        this._dnm_createtime = _dnm_createtime;
    }

	/**
     * @return Returns the _dnl_createtime.
     */
    public String get_dnl_createtime() {
        return this._dnl_createtime;
    }
    /**
     * @param _sk_companyname The _dnl_createtime to set.
     */
    public void set_dnl_createtime(String _dnl_createtime) {
        this._dnl_createtime = _dnl_createtime;
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
     * @return Returns the _dnm_updatetime.
     */
    public String get_dnm_updatetime() {
        return this._dnm_updatetime;
    }
    /**
     * @param _sk_companyname The _dnm_updatetime to set.
     */
    public void set_dnm_updatetime(String _dnm_updatetime) {
        this._dnm_updatetime = _dnm_updatetime;
    }

	/**
     * @return Returns the _dnl_updatetime.
     */
    public String get_dnl_updatetime() {
        return this._dnl_updatetime;
    }
    /**
     * @param _sk_companyname The _dnl_updatetime to set.
     */
    public void set_dnl_updatetime(String _dnl_updatetime) {
        this._dnl_updatetime = _dnl_updatetime;
    }

	/**
     * @return Returns the _ne_updator.
     */
    public String get_ne_updator() {
        return this._ne_updator;
    }
    /**
     * @param _sk_companyname The _ne_updator to set.
     */
    public void set_ne_updator(String _ne_updator) {
        this._ne_updator = _ne_updator;
    }

	/**
     * @return Returns the _ne_coClassify.
     */
    public String get_ne_coClassify() {
        return this._ne_coClassify;
    }
    /**
     * @param _sk_companyname The _ne_coClassify to set.
     */
    public void set_ne_coClassify(String _ne_coClassify) {
        this._ne_coClassify = _ne_coClassify;
    }

}
