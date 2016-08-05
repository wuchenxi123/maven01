package com.manage.student.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.campus.persistent.CampusVO;
import com.manage.gradlass.persistent.GradlassVO;
import com.manage.member.persistent.MemberVO;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class StudentVO extends BaseVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long stId;

    /** nullable persistent field */
    private Integer csId;

    /** nullable persistent field */
    private Integer cltId;

    /** nullable persistent field */
    private Integer slId;

    /** nullable persistent field */
    private String stAvatar;

    /** nullable persistent field */
    private String stAvatarTmp;

    /** nullable persistent field */
    private String stSex;

    /** nullable persistent field */
    private String stName;

    /** nullable persistent field */
    private String stAge;

    /** nullable persistent field */
    private String stMobile;
    
    /** nullable persistent field */
    private String stEmail;
    
    /** nullable persistent field */
    private String stLocationSchool;

    /** nullable persistent field */
    private String stHobbies;

    /** nullable persistent field */
    private String stRemark;

    /** nullable persistent field */
    private String stGradeClass;

    /** nullable persistent field */
    private String stClassCount;

    /** nullable persistent field */
    private Double stRealityTuition;

    /** nullable persistent field */
    private String stStatus;

    /** nullable persistent field */
    private String stType;

    /** nullable persistent field */
    private java.util.Date stTransactionDate;

    /** nullable persistent field */
    private String stReside;

    /** nullable persistent field */
    private java.util.Date stBirthday;

    /** nullable persistent field */
    private String stMotherMobile;

    /** nullable persistent field */
    private String stFatherMobile;

    /** nullable persistent field */
    private String stMagcardNumber;

    /** nullable persistent field */
    private String salerName;

    /** nullable persistent field */
    private String stOtherInformtion;

    /** nullable persistent field */
    private Integer stCostid;

    /** nullable persistent field */
    private Integer stCommunicateid;

    /** nullable persistent field */
    private Integer stSlotcardid;

    /** nullable persistent field */
    private java.util.Date createTime;

    /** nullable persistent field */
    private Integer creator;

    /** nullable persistent field */
    private java.util.Date updateTime;

    /** nullable persistent field */
    private Integer updator;
    
    private String creatorname;
    
    private String gradlass;
    
    private String campus;
    
    
    /*private DataPackage grad;*/
    /** full constructor */
    public StudentVO(java.lang.Long stId, java.lang.Integer csId, java.lang.Integer cltId, java.lang.Integer slId, java.lang.String stAvatar, java.lang.String stAvatarTmp, java.lang.String stSex, java.lang.String stName, java.lang.String stAge, java.lang.String stMobile, java.lang.String stLocationSchool, java.lang.String stHobbies, java.lang.String stRemark, java.lang.String stGradeClass, java.lang.String stClassCount, java.lang.Double stRealityTuition, java.lang.String stStatus, java.lang.String stType, java.util.Date stTransactionDate, java.lang.String stReside, java.util.Date stBirthday, java.lang.String stMotherMobile, java.lang.String stFatherMobile, java.lang.String stMagcardNumber, java.lang.String salerName, java.lang.String stOtherInformtion, java.lang.Integer stCostid, java.lang.Integer stCommunicateid, java.lang.Integer stSlotcardid) {
        this.stId = stId;
        this.csId = csId;
        this.cltId = cltId;
        this.slId = slId;
        this.stAvatar = stAvatar;
        this.stAvatarTmp = stAvatarTmp;
        this.stSex = stSex;
        this.stName = stName;
        this.stAge = stAge;
        this.stMobile = stMobile;
        this.stLocationSchool = stLocationSchool;
        this.stHobbies = stHobbies;
        this.stRemark = stRemark;
        this.stGradeClass = stGradeClass;
        this.stClassCount = stClassCount;
        this.stRealityTuition = stRealityTuition;
        this.stStatus = stStatus;
        this.stType = stType;
        this.stTransactionDate = stTransactionDate;
        this.stReside = stReside;
        this.stBirthday = stBirthday;
        this.stMotherMobile = stMotherMobile;
        this.stFatherMobile = stFatherMobile;
        this.stMagcardNumber = stMagcardNumber;
        this.salerName = salerName;
        this.stOtherInformtion = stOtherInformtion;
        this.stCostid = stCostid;
        this.stCommunicateid = stCommunicateid;
        this.stSlotcardid = stSlotcardid;
    }

    /** default constructor */
    public StudentVO() {
    }

    /** minimal constructor */
    public StudentVO(java.lang.Long stId) {
        this.stId = stId;
    }

    public java.lang.Long getStId() {
        return this.stId;
    }

    public void setStId(java.lang.Long stId) {
        this.stId = stId;
    }

    public java.lang.Integer getCsId() {
        return this.csId;
    }

    public void setCsId(java.lang.Integer csId) {
        this.csId = csId;
    }

    public java.lang.Integer getCltId() {
        return this.cltId;
    }

    public void setCltId(java.lang.Integer cltId) {
        this.cltId = cltId;
    }

    public java.lang.Integer getSlId() {
        return this.slId;
    }

    public void setSlId(java.lang.Integer slId) {
        this.slId = slId;
    }

    public java.lang.String getStAvatar() {
        return this.stAvatar;
    }

    public void setStAvatar(java.lang.String stAvatar) {
        this.stAvatar = stAvatar;
    }

    public java.lang.String getStAvatarTmp() {
        return this.stAvatarTmp;
    }

    public void setStAvatarTmp(java.lang.String stAvatarTmp) {
        this.stAvatarTmp = stAvatarTmp;
    }

    public java.lang.String getStSex() {
        return this.stSex;
    }

    public void setStSex(java.lang.String stSex) {
        this.stSex = stSex;
    }

    public java.lang.String getStName() {
        return this.stName;
    }

    public void setStName(java.lang.String stName) {
        this.stName = stName;
    }

    public java.lang.String getStAge() {
        return this.stAge;
    }

    public void setStAge(java.lang.String stAge) {
        this.stAge = stAge;
    }

    public java.lang.String getStMobile() {
        return this.stMobile;
    }

    public void setStMobile(java.lang.String stMobile) {
        this.stMobile = stMobile;
    }

    public java.lang.String getStLocationSchool() {
        return this.stLocationSchool;
    }

    public void setStLocationSchool(java.lang.String stLocationSchool) {
        this.stLocationSchool = stLocationSchool;
    }

    public java.lang.String getStHobbies() {
        return this.stHobbies;
    }

    public void setStHobbies(java.lang.String stHobbies) {
        this.stHobbies = stHobbies;
    }

    public java.lang.String getStRemark() {
        return this.stRemark;
    }

    public void setStRemark(java.lang.String stRemark) {
        this.stRemark = stRemark;
    }

    public java.lang.String getStGradeClass() {
        return this.stGradeClass;
    }

    public void setStGradeClass(java.lang.String stGradeClass) {
        this.stGradeClass = stGradeClass;
    }

    public java.lang.String getStClassCount() {
        return this.stClassCount;
    }

    public void setStClassCount(java.lang.String stClassCount) {
        this.stClassCount = stClassCount;
    }

    public java.lang.Double getStRealityTuition() {
        return this.stRealityTuition;
    }

    public void setStRealityTuition(java.lang.Double stRealityTuition) {
        this.stRealityTuition = stRealityTuition;
    }

    public java.lang.String getStStatus() {
        return this.stStatus;
    }

    public void setStStatus(java.lang.String stStatus) {
        this.stStatus = stStatus;
    }

    public java.lang.String getStType() {
        return this.stType;
    }

    public void setStType(java.lang.String stType) {
        this.stType = stType;
    }

    public java.util.Date getStTransactionDate() {
        return this.stTransactionDate;
    }

    public void setStTransactionDate(java.util.Date stTransactionDate) {
        this.stTransactionDate = stTransactionDate;
    }

    public java.lang.String getStReside() {
        return this.stReside;
    }

    public void setStReside(java.lang.String stReside) {
        this.stReside = stReside;
    }

    public java.util.Date getStBirthday() {
        return this.stBirthday;
    }

    public void setStBirthday(java.util.Date stBirthday) {
        this.stBirthday = stBirthday;
    }

    public java.lang.String getStMotherMobile() {
        return this.stMotherMobile;
    }

    public void setStMotherMobile(java.lang.String stMotherMobile) {
        this.stMotherMobile = stMotherMobile;
    }

    public java.lang.String getStFatherMobile() {
        return this.stFatherMobile;
    }

    public void setStFatherMobile(java.lang.String stFatherMobile) {
        this.stFatherMobile = stFatherMobile;
    }

    public java.lang.String getStMagcardNumber() {
        return this.stMagcardNumber;
    }

    public void setStMagcardNumber(java.lang.String stMagcardNumber) {
        this.stMagcardNumber = stMagcardNumber;
    }

    public java.lang.String getSalerName() {
        return this.salerName;
    }

    public void setSalerName(java.lang.String salerName) {
        this.salerName = salerName;
    }

    public java.lang.String getStOtherInformtion() {
        return this.stOtherInformtion;
    }

    public void setStOtherInformtion(java.lang.String stOtherInformtion) {
        this.stOtherInformtion = stOtherInformtion;
    }

    public java.lang.Integer getStCostid() {
        return this.stCostid;
    }

    public void setStCostid(java.lang.Integer stCostid) {
        this.stCostid = stCostid;
    }

    public java.lang.Integer getStCommunicateid() {
        return this.stCommunicateid;
    }

    public void setStCommunicateid(java.lang.Integer stCommunicateid) {
        this.stCommunicateid = stCommunicateid;
    }

    public java.lang.Integer getStSlotcardid() {
        return this.stSlotcardid;
    }

    public void setStSlotcardid(java.lang.Integer stSlotcardid) {
        this.stSlotcardid = stSlotcardid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("stId", getStId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StudentVO) ) return false;
        StudentVO castOther = (StudentVO) other;
        return new EqualsBuilder()
            .append(this.getStId(), castOther.getStId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getStId())
            .toHashCode();
    }

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdator() {
		return updator;
	}

	public void setUpdator(Integer updator) {
		this.updator = updator;
	}


	public String getStEmail() {
		return stEmail;
	}

	public void setStEmail(String stEmail) {
		this.stEmail = stEmail;
	}

/*	public DataPackage getGrad() {
		return grad;
	}

	public void setGrad(DataPackage grad) {
		this.grad = grad;
	}*/

	public String getCreatorname() {
		return creatorname;
	}

	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public void setGradlass(String gradlass) {
		this.gradlass = gradlass;
	}

}
