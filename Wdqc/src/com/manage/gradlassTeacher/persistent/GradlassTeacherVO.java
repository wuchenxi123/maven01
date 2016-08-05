package com.manage.gradlassTeacher.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class GradlassTeacherVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long ctId;

    /** persistent field */
    private Integer teacherid;

    /** persistent field */
    private Integer gradlassid;

    /** full constructor */
    public GradlassTeacherVO(java.lang.Long ctId, java.lang.Integer teacherid, java.lang.Integer gradlassid) {
        this.ctId = ctId;
        this.teacherid = teacherid;
        this.gradlassid = gradlassid;
    }

    /** default constructor */
    public GradlassTeacherVO() {
    }

    public java.lang.Long getCtId() {
        return this.ctId;
    }

    public void setCtId(java.lang.Long ctId) {
        this.ctId = ctId;
    }

    public java.lang.Integer getTeacherid() {
        return this.teacherid;
    }

    public void setTeacherid(java.lang.Integer teacherid) {
        this.teacherid = teacherid;
    }

    public java.lang.Integer getGradlassid() {
        return this.gradlassid;
    }

    public void setGradlassid(java.lang.Integer gradlassid) {
        this.gradlassid = gradlassid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctId", getCtId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof GradlassTeacherVO) ) return false;
        GradlassTeacherVO castOther = (GradlassTeacherVO) other;
        return new EqualsBuilder()
            .append(this.getCtId(), castOther.getCtId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtId())
            .toHashCode();
    }

}
