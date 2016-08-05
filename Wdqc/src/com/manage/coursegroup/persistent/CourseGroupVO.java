package com.manage.coursegroup.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CourseGroupVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long cgpId;

    /** persistent field */
    private Integer courseid;

    /** persistent field */
    private Integer groupid;

    /** full constructor */
    public CourseGroupVO(java.lang.Long cgpId, java.lang.Integer courseid, java.lang.Integer groupid) {
        this.cgpId = cgpId;
        this.courseid = courseid;
        this.groupid = groupid;
    }

    /** default constructor */
    public CourseGroupVO() {
    }

    public java.lang.Long getCgpId() {
        return this.cgpId;
    }

    public void setCgpId(java.lang.Long cgpId) {
        this.cgpId = cgpId;
    }

    public java.lang.Integer getCourseid() {
        return this.courseid;
    }

    public void setCourseid(java.lang.Integer courseid) {
        this.courseid = courseid;
    }

    public java.lang.Integer getGroupid() {
        return this.groupid;
    }

    public void setGroupid(java.lang.Integer groupid) {
        this.groupid = groupid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cgpId", getCgpId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CourseGroupVO) ) return false;
        CourseGroupVO castOther = (CourseGroupVO) other;
        return new EqualsBuilder()
            .append(this.getCgpId(), castOther.getCgpId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCgpId())
            .toHashCode();
    }

}
