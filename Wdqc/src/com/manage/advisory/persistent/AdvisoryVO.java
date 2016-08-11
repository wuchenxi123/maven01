package com.manage.advisory.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AdvisoryVO extends BaseVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Integer adId;

    /** nullable persistent field */
    private String adName;

    /** nullable persistent field */
    private Integer adSex;
    
    private String coursename;
    
    private String creatorname;

    /** nullable persistent field */
    private String adPhone;

    /** nullable persistent field */
    private String adEmial;

    /** nullable persistent field */
    private String adHobbies;

    /** nullable persistent field */
    private String adAddress;

    /** nullable persistent field */
    private String adRemark;

    /** nullable persistent field */
    private Integer adWays;

    /** nullable persistent field */
    private Integer adCourse;

    /** nullable persistent field */
    private String adContent;

    /** nullable persistent field */
    private Integer adIntention;

    /** nullable persistent field */
    private String adRemarks;

    /** nullable persistent field */
    private java.util.Date createTime;

    /** nullable persistent field */
    private Integer creator;

    /** nullable persistent field */
    private java.util.Date updateTime;

    /** nullable persistent field */
    private Integer updator;

    /** full constructor */
    public AdvisoryVO(java.lang.String adName, java.lang.Integer adSex, java.lang.String adPhone, java.lang.String adEmial, java.lang.String adHobbies, java.lang.String adAddress, java.lang.String adRemark, java.lang.Integer adWays, java.lang.Integer adCourse, java.lang.String adContent, java.lang.Integer adIntention, java.lang.String adRemarks, java.util.Date createTime, java.lang.Integer creator, java.util.Date updateTime, java.lang.Integer updator) {
        this.adName = adName;
        this.adSex = adSex;
        this.adPhone = adPhone;
        this.adEmial = adEmial;
        this.adHobbies = adHobbies;
        this.adAddress = adAddress;
        this.adRemark = adRemark;
        this.adWays = adWays;
        this.adCourse = adCourse;
        this.adContent = adContent;
        this.adIntention = adIntention;
        this.adRemarks = adRemarks;
        this.createTime = createTime;
        this.creator = creator;
        this.updateTime = updateTime;
        this.updator = updator;
    }

    /** default constructor */
    public AdvisoryVO() {
    }

    public java.lang.Integer getAdId() {
        return this.adId;
    }

    public void setAdId(java.lang.Integer adId) {
        this.adId = adId;
    }

    public java.lang.String getAdName() {
        return this.adName;
    }

    public void setAdName(java.lang.String adName) {
        this.adName = adName;
    }

    public java.lang.Integer getAdSex() {
        return this.adSex;
    }

    public void setAdSex(java.lang.Integer adSex) {
        this.adSex = adSex;
    }

    public java.lang.String getAdPhone() {
        return this.adPhone;
    }

    public void setAdPhone(java.lang.String adPhone) {
        this.adPhone = adPhone;
    }

    public java.lang.String getAdEmial() {
        return this.adEmial;
    }

    public void setAdEmial(java.lang.String adEmial) {
        this.adEmial = adEmial;
    }

    public java.lang.String getAdHobbies() {
        return this.adHobbies;
    }

    public void setAdHobbies(java.lang.String adHobbies) {
        this.adHobbies = adHobbies;
    }

    public java.lang.String getAdAddress() {
        return this.adAddress;
    }

    public void setAdAddress(java.lang.String adAddress) {
        this.adAddress = adAddress;
    }

    public java.lang.String getAdRemark() {
        return this.adRemark;
    }

    public void setAdRemark(java.lang.String adRemark) {
        this.adRemark = adRemark;
    }

    public java.lang.Integer getAdWays() {
        return this.adWays;
    }

    public void setAdWays(java.lang.Integer adWays) {
        this.adWays = adWays;
    }

    public java.lang.Integer getAdCourse() {
        return this.adCourse;
    }

    public void setAdCourse(java.lang.Integer adCourse) {
        this.adCourse = adCourse;
    }

    public java.lang.String getAdContent() {
        return this.adContent;
    }

    public void setAdContent(java.lang.String adContent) {
        this.adContent = adContent;
    }

    public java.lang.Integer getAdIntention() {
        return this.adIntention;
    }

    public void setAdIntention(java.lang.Integer adIntention) {
        this.adIntention = adIntention;
    }

    public java.lang.String getAdRemarks() {
        return this.adRemarks;
    }

    public void setAdRemarks(java.lang.String adRemarks) {
        this.adRemarks = adRemarks;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.lang.Integer getCreator() {
        return this.creator;
    }

    public void setCreator(java.lang.Integer creator) {
        this.creator = creator;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public java.lang.Integer getUpdator() {
        return this.updator;
    }

    public void setUpdator(java.lang.Integer updator) {
        this.updator = updator;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("adId", getAdId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AdvisoryVO) ) return false;
        AdvisoryVO castOther = (AdvisoryVO) other;
        return new EqualsBuilder()
            .append(this.getAdId(), castOther.getAdId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAdId())
            .toHashCode();
    }

	public String getCreatorname() {
		return creatorname;
	}

	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

}
