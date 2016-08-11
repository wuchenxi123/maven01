package com.manage.classroom.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import com.manage.campus.persistent.CampusVO;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ClassroomVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long crId;

    /** nullable persistent field */
    private String crName;

    /** nullable persistent field */
    private Short crCapacity;

    /** nullable persistent field */
    private String crCampus;

    /** nullable persistent field */
    private java.util.Date msStartDate;

    /** nullable persistent field */
    private java.util.Date msEndDate;

    private CampusVO campus;
   

    public ClassroomVO(Long crId, String crName, Short crCapacity,
			String crCampus, Date msStartDate, Date msEndDate, CampusVO campus) {
		super();
		this.crId = crId;
		this.crName = crName;
		this.crCapacity = crCapacity;
		this.crCampus = crCampus;
		this.msStartDate = msStartDate;
		this.msEndDate = msEndDate;
		this.campus = campus;
	}

	/** default constructor */
    public ClassroomVO() {
    }

    /** minimal constructor */
    public ClassroomVO(java.lang.Long crId) {
        this.crId = crId;
    }

    public java.lang.Long getCrId() {
        return this.crId;
    }

    public void setCrId(java.lang.Long crId) {
        this.crId = crId;
    }

    public java.lang.String getCrName() {
        return this.crName;
    }

    public void setCrName(java.lang.String crName) {
        this.crName = crName;
    }

    public java.lang.Short getCrCapacity() {
        return this.crCapacity;
    }

    public void setCrCapacity(java.lang.Short crCapacity) {
        this.crCapacity = crCapacity;
    }

    public java.lang.String getCrCampus() {
        return this.crCampus;
    }

    public void setCrCampus(java.lang.String crCampus) {
        this.crCampus = crCampus;
    }

    public java.util.Date getMsStartDate() {
        return this.msStartDate;
    }

    public void setMsStartDate(java.util.Date msStartDate) {
        this.msStartDate = msStartDate;
    }

    public java.util.Date getMsEndDate() {
        return this.msEndDate;
    }

    public void setMsEndDate(java.util.Date msEndDate) {
        this.msEndDate = msEndDate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("crId", getCrId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ClassroomVO) ) return false;
        ClassroomVO castOther = (ClassroomVO) other;
        return new EqualsBuilder()
            .append(this.getCrId(), castOther.getCrId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCrId())
            .toHashCode();
    }

	public CampusVO getCampus() {
		return campus;
	}

	public void setCampus(CampusVO campus) {
		this.campus = campus;
	}

}
