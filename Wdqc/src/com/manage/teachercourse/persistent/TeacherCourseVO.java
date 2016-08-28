package com.manage.teachercourse.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.core.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class TeacherCourseVO extends BaseVO implements Serializable {

    /** identifier field */
    private Integer tcId;

    /** persistent field */
    private Integer teid;

    /** persistent field */
    private Integer coid;

    private String coursename;
   
   
	public TeacherCourseVO(Integer tcId, Integer teid, Integer coid, String coursename) {
		super();
		this.tcId = tcId;
		this.teid = teid;
		this.coid = coid;
		this.coursename = coursename;
	}
	/** default constructor */
    public TeacherCourseVO() {
    }
    public Integer getTcId() {
		return tcId;
	}
	public void setTcId(Integer tcId) {
		this.tcId = tcId;
	}
	public Integer getTeid() {
		return teid;
	}
	public void setTeid(Integer teid) {
		this.teid = teid;
	}
	public Integer getCoid() {
		return coid;
	}
	public void setCoid(Integer coid) {
		this.coid = coid;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("tcId", getTcId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TeacherCourseVO) ) return false;
        TeacherCourseVO castOther = (TeacherCourseVO) other;
        return new EqualsBuilder()
            .append(this.getTcId(), castOther.getTcId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getTcId())
            .toHashCode();
    }
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

}
