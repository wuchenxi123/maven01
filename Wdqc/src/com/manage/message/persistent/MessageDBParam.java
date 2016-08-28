package com.manage.message.persistent;

import com.core.jop.infrastructure.db.DBQueryParam;

/**
 * Title: MessageDBParam
 * @author chenlei
 * @version 1.0
 */
public class MessageDBParam extends DBQueryParam {
    private String _ne_mgId;
    private String _sk_mgTitle;
    private String _nk_mgContent;
    private String _se_mgType;
    private String _sk_mgType;
    private String _ne_mgCreator;
    private String _dnm_mgCreattime;
    private String _de_mgCreattime;
    private String _dnl_mgCreattime;

	/**
     * @return Returns the _ne_mgId.
     */
    public String get_ne_mgId() {
        return this._ne_mgId;
    }
    /**
     * @param _sk_companyname The _ne_mgId to set.
     */
    public void set_ne_mgId(String _ne_mgId) {
        this._ne_mgId = _ne_mgId;
    }

	/**
     * @return Returns the _sk_mgTitle.
     */
    public String get_sk_mgTitle() {
        return this._sk_mgTitle;
    }
    /**
     * @param _sk_companyname The _sk_mgTitle to set.
     */
    public void set_sk_mgTitle(String _sk_mgTitle) {
        this._sk_mgTitle = _sk_mgTitle;
    }

	/**
     * @return Returns the _nk_mgContent.
     */
    public String get_nk_mgContent() {
        return this._nk_mgContent;
    }
    /**
     * @param _sk_companyname The _nk_mgContent to set.
     */
    public void set_nk_mgContent(String _nk_mgContent) {
        this._nk_mgContent = _nk_mgContent;
    }

	/**
     * @return Returns the _se_mgType.
     */
    public String get_se_mgType() {
        return this._se_mgType;
    }
    /**
     * @param _sk_companyname The _se_mgType to set.
     */
    public void set_se_mgType(String _se_mgType) {
        this._se_mgType = _se_mgType;
    }

	/**
     * @return Returns the _sk_mgType.
     */
    public String get_sk_mgType() {
        return this._sk_mgType;
    }
    /**
     * @param _sk_companyname The _sk_mgType to set.
     */
    public void set_sk_mgType(String _sk_mgType) {
        this._sk_mgType = _sk_mgType;
    }

	/**
     * @return Returns the _ne_mgCreator.
     */
    public String get_ne_mgCreator() {
        return this._ne_mgCreator;
    }
    /**
     * @param _sk_companyname The _ne_mgCreator to set.
     */
    public void set_ne_mgCreator(String _ne_mgCreator) {
        this._ne_mgCreator = _ne_mgCreator;
    }

	/**
     * @return Returns the _dnm_mgCreattime.
     */
    public String get_dnm_mgCreattime() {
        return this._dnm_mgCreattime;
    }
    /**
     * @param _sk_companyname The _dnm_mgCreattime to set.
     */
    public void set_dnm_mgCreattime(String _dnm_mgCreattime) {
        this._dnm_mgCreattime = _dnm_mgCreattime;
    }

	/**
     * @return Returns the _de_mgCreattime.
     */
    public String get_de_mgCreattime() {
        return this._de_mgCreattime;
    }
    /**
     * @param _sk_companyname The _de_mgCreattime to set.
     */
    public void set_de_mgCreattime(String _de_mgCreattime) {
        this._de_mgCreattime = _de_mgCreattime;
    }

	/**
     * @return Returns the _dnl_mgCreattime.
     */
    public String get_dnl_mgCreattime() {
        return this._dnl_mgCreattime;
    }
    /**
     * @param _sk_companyname The _dnl_mgCreattime to set.
     */
    public void set_dnl_mgCreattime(String _dnl_mgCreattime) {
        this._dnl_mgCreattime = _dnl_mgCreattime;
    }

}
