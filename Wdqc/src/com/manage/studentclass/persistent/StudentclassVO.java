package com.manage.studentclass.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import com.manage.gradlass.persistent.GradlassVO;
import com.manage.student.persistent.StudentVO;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class StudentclassVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long scId;

    /** nullable persistent field */
    private Integer stId;

    /** nullable persistent field */
    private Integer csId;

    /** nullable persistent field */
    private Integer creator;

    /** nullable persistent field */
    private java.util.Date createTime;
    
    /** nullable persistent field */
    private GradlassVO gradlass;
    
    /** nullable persistent field */
    private StudentVO student;

    /** full constructor */
    public StudentclassVO(java.lang.Long scId, java.lang.Integer stId, java.lang.Integer csId, java.lang.Integer creator, java.util.Date createTime) {
        this.scId = scId;
        this.stId = stId;
        this.csId = csId;
        this.creator = creator;
        this.createTime = createTime;
    }

    /** default constructor */
    public StudentclassVO() {
    }

    /** minimal constructor */
    public StudentclassVO(java.lang.Long scId) {
        this.scId = scId;
    }

    public java.lang.Long getScId() {
        return this.scId;
    }

    public void setScId(java.lang.Long scId) {
        this.scId = scId;
    }

    public java.lang.Integer getStId() {
        return this.stId;
    }

    public void setStId(java.lang.Integer stId) {
        this.stId = stId;
    }

    public java.lang.Integer getCsId() {
        return this.csId;
    }

    public void setCsId(java.lang.Integer csId) {
        this.csId = csId;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("scId", getScId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StudentclassVO) ) return false;
        StudentclassVO castOther = (StudentclassVO) other;
        return new EqualsBuilder()
            .append(this.getScId(), castOther.getScId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getScId())
            .toHashCode();
    }

	public GradlassVO getGradlass() {
		return gradlass;
	}

	public void setGradlass(GradlassVO gradlass) {
		this.gradlass = gradlass;
	}

	public StudentVO getStudent() {
		return student;
	}

	public void setStudent(StudentVO student) {
		this.student = student;
	}

}
