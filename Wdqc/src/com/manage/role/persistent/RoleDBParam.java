package com.manage.role.persistent;

import com.core.jop.infrastructure.db.DBQueryParam;

/**
 * Title: RoleDBParam
 * @author chenlei
 * @version 1.0
 */
public class RoleDBParam extends DBQueryParam {
    private String _ne_roleId;
    private String _se_roleName;
    private String _sk_roleName;

	/**
     * @return Returns the _ne_roleId.
     */
    public String get_ne_roleId() {
        return this._ne_roleId;
    }
    /**
     * @param _sk_companyname The _ne_roleId to set.
     */
    public void set_ne_roleId(String _ne_roleId) {
        this._ne_roleId = _ne_roleId;
    }

	/**
     * @return Returns the _se_roleName.
     */
    public String get_se_roleName() {
        return this._se_roleName;
    }
    /**
     * @param _sk_companyname The _se_roleName to set.
     */
    public void set_se_roleName(String _se_roleName) {
        this._se_roleName = _se_roleName;
    }

	/**
     * @return Returns the _sk_roleName.
     */
    public String get_sk_roleName() {
        return this._sk_roleName;
    }
    /**
     * @param _sk_companyname The _sk_roleName to set.
     */
    public void set_sk_roleName(String _sk_roleName) {
        this._sk_roleName = _sk_roleName;
    }

}
