package com.manage.subdivide.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SubdivideVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long msSdid;

    /** nullable persistent field */
    private Short msGpid;

    /** nullable persistent field */
    private String sdName;

    /** full constructor */
    public SubdivideVO(java.lang.Long msSdid, java.lang.Short msGpid, java.lang.String sdName) {
        this.msSdid = msSdid;
        this.msGpid = msGpid;
        this.sdName = sdName;
    }

    /** default constructor */
    public SubdivideVO() {
    }

    /** minimal constructor */
    public SubdivideVO(java.lang.Long msSdid) {
        this.msSdid = msSdid;
    }

    public java.lang.Long getMsSdid() {
        return this.msSdid;
    }

    public void setMsSdid(java.lang.Long msSdid) {
        this.msSdid = msSdid;
    }

    public java.lang.Short getMsGpid() {
        return this.msGpid;
    }

    public void setMsGpid(java.lang.Short msGpid) {
        this.msGpid = msGpid;
    }

    public java.lang.String getSdName() {
        return this.sdName;
    }

    public void setSdName(java.lang.String sdName) {
        this.sdName = sdName;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("msSdid", getMsSdid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SubdivideVO) ) return false;
        SubdivideVO castOther = (SubdivideVO) other;
        return new EqualsBuilder()
            .append(this.getMsSdid(), castOther.getMsSdid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getMsSdid())
            .toHashCode();
    }

}
