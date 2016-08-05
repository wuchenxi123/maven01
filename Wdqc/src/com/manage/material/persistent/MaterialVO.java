package com.manage.material.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import com.manage.course.persistent.CourseVO;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MaterialVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long mtlId;

    /** nullable persistent field */
    private Integer coId;

    /** nullable persistent field */
    private String mtlName;

    /** nullable persistent field */
    private Double mtlPrice;

    /** nullable persistent field */
    private Integer mtlVolume;

    /** nullable persistent field */
    private Integer mtlSaled;

    /** nullable persistent field */
    private Integer mtlRemain;

    /** nullable persistent field */
    private Integer creator;

    /** nullable persistent field */
    private java.util.Date createTime;

    /** nullable persistent field */
    private Integer updator;

    /** nullable persistent field */
    private java.util.Date updateTime;
    
    private String coursename;
    
    private String creatorname;

    /** full constructor */
    public MaterialVO(java.lang.Integer coId, java.lang.String mtlName, java.lang.Double mtlPrice, java.lang.Integer mtlVolume, java.lang.Integer mtlSaled, java.lang.Integer mtlRemain, java.lang.Integer creator, java.util.Date createTime, java.lang.Integer updator, java.util.Date updateTime) {
        this.coId = coId;
        this.mtlName = mtlName;
        this.mtlPrice = mtlPrice;
        this.mtlVolume = mtlVolume;
        this.mtlSaled = mtlSaled;
        this.mtlRemain = mtlRemain;
        this.creator = creator;
        this.createTime = createTime;
        this.updator = updator;
        this.updateTime = updateTime;
    }

    /** default constructor */
    public MaterialVO() {
    }

    public java.lang.Long getMtlId() {
        return this.mtlId;
    }

    public void setMtlId(java.lang.Long mtlId) {
        this.mtlId = mtlId;
    }

    public java.lang.Integer getCoId() {
        return this.coId;
    }

    public void setCoId(java.lang.Integer coId) {
        this.coId = coId;
    }

    public java.lang.String getMtlName() {
        return this.mtlName;
    }

    public void setMtlName(java.lang.String mtlName) {
        this.mtlName = mtlName;
    }

    public java.lang.Double getMtlPrice() {
        return this.mtlPrice;
    }

    public void setMtlPrice(java.lang.Double mtlPrice) {
        this.mtlPrice = mtlPrice;
    }

    public java.lang.Integer getMtlVolume() {
        return this.mtlVolume;
    }

    public void setMtlVolume(java.lang.Integer mtlVolume) {
        this.mtlVolume = mtlVolume;
    }

    public java.lang.Integer getMtlSaled() {
        return this.mtlSaled;
    }

    public void setMtlSaled(java.lang.Integer mtlSaled) {
        this.mtlSaled = mtlSaled;
    }

    public java.lang.Integer getMtlRemain() {
        return this.mtlRemain;
    }

    public void setMtlRemain(java.lang.Integer mtlRemain) {
        this.mtlRemain = mtlRemain;
    }

    public java.lang.Integer getCreator() {
        return this.creator;
    }

    public void setCreator(java.lang.Integer creator) {
        this.creator = creator;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.lang.Integer getUpdator() {
        return this.updator;
    }

    public void setUpdator(java.lang.Integer updator) {
        this.updator = updator;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("mtlId", getMtlId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MaterialVO) ) return false;
        MaterialVO castOther = (MaterialVO) other;
        return new EqualsBuilder()
            .append(this.getMtlId(), castOther.getMtlId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getMtlId())
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
