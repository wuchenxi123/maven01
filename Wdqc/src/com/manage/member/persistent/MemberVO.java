package com.manage.member.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MemberVO extends BaseVO implements Serializable {

    /** identifier field */
    private Integer mbId;

    /** persistent field */
    private String mbName;

    /** nullable persistent field */
    private String mbPetName;

    /** persistent field */
    private String mbPassword;

    /** nullable persistent field */
    private String mbEmail;

    /** nullable persistent field */
    private String mbAvatar;

    /** nullable persistent field */
    private String mbAvatarTmp;

    /** nullable persistent field */
    private String mbPhone;

    /** nullable persistent field */
    private String mbSex;

    /** nullable persistent field */
    private Integer mbType;

    /** nullable persistent field */
    private String mbQuestion;

    /** nullable persistent field */
    private String mbAnswer;

    /** persistent field */
    private java.util.Date mbRegisterDate;

    /** nullable persistent field */
    private java.util.Date mbLastloginDate;

    /** full constructor */
    public MemberVO(java.lang.Integer mbId, java.lang.String mbName, java.lang.String mbPetName, java.lang.String mbPassword, java.lang.String mbEmail, java.lang.String mbAvatar, java.lang.String mbAvatarTmp, java.lang.String mbPhone, java.lang.String mbSex, java.lang.Integer mbType, java.lang.String mbQuestion, java.lang.String mbAnswer, java.util.Date mbRegisterDate, java.util.Date mbLastloginDate) {
        this.mbId = mbId;
        this.mbName = mbName;
        this.mbPetName = mbPetName;
        this.mbPassword = mbPassword;
        this.mbEmail = mbEmail;
        this.mbAvatar = mbAvatar;
        this.mbAvatarTmp = mbAvatarTmp;
        this.mbPhone = mbPhone;
        this.mbSex = mbSex;
        this.mbType = mbType;
        this.mbQuestion = mbQuestion;
        this.mbAnswer = mbAnswer;
        this.mbRegisterDate = mbRegisterDate;
        this.mbLastloginDate = mbLastloginDate;
    }

    /** default constructor */
    public MemberVO() {
    }

    /** minimal constructor */
    public MemberVO(java.lang.Integer mbId, java.lang.String mbName, java.lang.String mbPassword, java.util.Date mbRegisterDate) {
        this.mbId = mbId;
        this.mbName = mbName;
        this.mbPassword = mbPassword;
        this.mbRegisterDate = mbRegisterDate;
    }

    public java.lang.Integer getMbId() {
        return this.mbId;
    }

	public void setMbId(Integer mbId) {
		this.mbId = mbId;
	}

    public java.lang.String getMbName() {
        return this.mbName;
    }

    public void setMbName(java.lang.String mbName) {
        this.mbName = mbName;
    }

    public java.lang.String getMbPetName() {
        return this.mbPetName;
    }

    public void setMbPetName(java.lang.String mbPetName) {
        this.mbPetName = mbPetName;
    }

    public java.lang.String getMbPassword() {
        return this.mbPassword;
    }

    public void setMbPassword(java.lang.String mbPassword) {
        this.mbPassword = mbPassword;
    }

    public java.lang.String getMbEmail() {
        return this.mbEmail;
    }

    public void setMbEmail(java.lang.String mbEmail) {
        this.mbEmail = mbEmail;
    }

    public java.lang.String getMbAvatar() {
        return this.mbAvatar;
    }

    public void setMbAvatar(java.lang.String mbAvatar) {
        this.mbAvatar = mbAvatar;
    }

    public java.lang.String getMbAvatarTmp() {
        return this.mbAvatarTmp;
    }

    public void setMbAvatarTmp(java.lang.String mbAvatarTmp) {
        this.mbAvatarTmp = mbAvatarTmp;
    }

    public java.lang.String getMbPhone() {
        return this.mbPhone;
    }

    public void setMbPhone(java.lang.String mbPhone) {
        this.mbPhone = mbPhone;
    }

    public java.lang.String getMbSex() {
        return this.mbSex;
    }

    public void setMbSex(java.lang.String mbSex) {
        this.mbSex = mbSex;
    }

    public java.lang.Integer getMbType() {
        return this.mbType;
    }

    public void setMbType(java.lang.Integer mbType) {
        this.mbType = mbType;
    }

    public java.lang.String getMbQuestion() {
        return this.mbQuestion;
    }

    public void setMbQuestion(java.lang.String mbQuestion) {
        this.mbQuestion = mbQuestion;
    }

    public java.lang.String getMbAnswer() {
        return this.mbAnswer;
    }

    public void setMbAnswer(java.lang.String mbAnswer) {
        this.mbAnswer = mbAnswer;
    }

    public java.util.Date getMbRegisterDate() {
        return this.mbRegisterDate;
    }

    public void setMbRegisterDate(java.util.Date mbRegisterDate) {
        this.mbRegisterDate = mbRegisterDate;
    }

    public java.util.Date getMbLastloginDate() {
        return this.mbLastloginDate;
    }

    public void setMbLastloginDate(java.util.Date mbLastloginDate) {
        this.mbLastloginDate = mbLastloginDate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("mbId", getMbId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MemberVO) ) return false;
        MemberVO castOther = (MemberVO) other;
        return new EqualsBuilder()
            .append(this.getMbId(), castOther.getMbId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getMbId())
            .toHashCode();
    }


}
