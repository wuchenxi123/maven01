package com.manage.member.persistent;

import com.core.jop.infrastructure.db.DBQueryParam;

/**
 * Title: MemberDBParam
 * @author Hujj
 * @version 1.0
 */
public class MemberDBParam extends DBQueryParam {
    private String _ne_mbId;
    private String _se_mbName;
    private String _se_mbEmail;
    private String _se_mbPhone;
    private String _se_mbSex;
    private String _ne_mbType;
    private String _se_mbAnswer;
    private String _se_mbPassword;

	/**
     * @return Returns the _ne_mbId.
     */
    public String get_ne_mbId() {
        return this._ne_mbId;
    }
    /**
     * @param _sk_companyname The _ne_mbId to set.
     */
    public void set_ne_mbId(String _ne_mbId) {
        this._ne_mbId = _ne_mbId;
    }

	/**
     * @return Returns the _se_mbName.
     */
    public String get_se_mbName() {
        return this._se_mbName;
    }
    /**
     * @param _sk_companyname The _se_mbName to set.
     */
    public void set_se_mbName(String _se_mbName) {
        this._se_mbName = _se_mbName;
    }

	/**
     * @return Returns the _se_mbEmail.
     */
    public String get_se_mbEmail() {
        return this._se_mbEmail;
    }
    /**
     * @param _sk_companyname The _se_mbEmail to set.
     */
    public void set_se_mbEmail(String _se_mbEmail) {
        this._se_mbEmail = _se_mbEmail;
    }

	/**
     * @return Returns the _se_mbPhone.
     */
    public String get_se_mbPhone() {
        return this._se_mbPhone;
    }
    /**
     * @param _sk_companyname The _se_mbPhone to set.
     */
    public void set_se_mbPhone(String _se_mbPhone) {
        this._se_mbPhone = _se_mbPhone;
    }

	/**
     * @return Returns the _se_mbSex.
     */
    public String get_se_mbSex() {
        return this._se_mbSex;
    }
    /**
     * @param _sk_companyname The _se_mbSex to set.
     */
    public void set_se_mbSex(String _se_mbSex) {
        this._se_mbSex = _se_mbSex;
    }

	/**
     * @return Returns the _ne_mbType.
     */
    public String get_ne_mbType() {
        return this._ne_mbType;
    }
    /**
     * @param _sk_companyname The _ne_mbType to set.
     */
    public void set_ne_mbType(String _ne_mbType) {
        this._ne_mbType = _ne_mbType;
    }

	/**
     * @return Returns the _se_mbAnswer.
     */
    public String get_se_mbAnswer() {
        return this._se_mbAnswer;
    }
    /**
     * @param _sk_companyname The _se_mbAnswer to set.
     */
    public void set_se_mbAnswer(String _se_mbAnswer) {
        this._se_mbAnswer = _se_mbAnswer;
    }
	public String get_se_mbPassword() {
		return _se_mbPassword;
	}
	public void set_se_mbPassword(String _se_mbPassword) {
		this._se_mbPassword = _se_mbPassword;
	}

}
