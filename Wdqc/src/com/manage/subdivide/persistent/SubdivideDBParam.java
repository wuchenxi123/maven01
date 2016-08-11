package com.manage.subdivide.persistent;

import com.core.jop.infrastructure.db.DBQueryParam;

/**
 * Title: SubdivideDBParam
 * @author Hujj
 * @version 1.0
 */
public class SubdivideDBParam extends DBQueryParam {
    private String _ne_msSdid;
    private String _ne_msGpid;
    private String _se_sdName;
    private String _sk_sdName;

	/**
     * @return Returns the _ne_msSdid.
     */
    public String get_ne_msSdid() {
        return this._ne_msSdid;
    }
    /**
     * @param _sk_companyname The _ne_msSdid to set.
     */
    public void set_ne_msSdid(String _ne_msSdid) {
        this._ne_msSdid = _ne_msSdid;
    }

	/**
     * @return Returns the _ne_msGpid.
     */
    public String get_ne_msGpid() {
        return this._ne_msGpid;
    }
    /**
     * @param _sk_companyname The _ne_msGpid to set.
     */
    public void set_ne_msGpid(String _ne_msGpid) {
        this._ne_msGpid = _ne_msGpid;
    }

	/**
     * @return Returns the _se_sdName.
     */
    public String get_se_sdName() {
        return this._se_sdName;
    }
    /**
     * @param _sk_companyname The _se_sdName to set.
     */
    public void set_se_sdName(String _se_sdName) {
        this._se_sdName = _se_sdName;
    }

	/**
     * @return Returns the _sk_sdName.
     */
    public String get_sk_sdName() {
        return this._sk_sdName;
    }
    /**
     * @param _sk_companyname The _sk_sdName to set.
     */
    public void set_sk_sdName(String _sk_sdName) {
        this._sk_sdName = _sk_sdName;
    }

}
