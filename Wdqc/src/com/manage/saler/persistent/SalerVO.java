package com.manage.saler.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SalerVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long slId;

    /** nullable persistent field */
    private String cpId;

    /** nullable persistent field */
    private String slName;

    /** nullable persistent field */
    private Integer slAcheive;

    /** full constructor */
    public SalerVO(java.lang.Long slId, java.lang.String cpId, java.lang.String slName, java.lang.Integer slAcheive) {
        this.slId = slId;
        this.cpId = cpId;
        this.slName = slName;
        this.slAcheive = slAcheive;
    }

    /** default constructor */
    public SalerVO() {
    }

    /** minimal constructor */
    public SalerVO(java.lang.Long slId) {
        this.slId = slId;
    }

    public java.lang.Long getSlId() {
        return this.slId;
    }

    public void setSlId(java.lang.Long slId) {
        this.slId = slId;
    }

    public java.lang.String getCpId() {
        return this.cpId;
    }

    public void setCpId(java.lang.String cpId) {
        this.cpId = cpId;
    }

    public java.lang.String getSlName() {
        return this.slName;
    }

    public void setSlName(java.lang.String slName) {
        this.slName = slName;
    }

    public java.lang.Integer getSlAcheive() {
        return this.slAcheive;
    }

    public void setSlAcheive(java.lang.Integer slAcheive) {
        this.slAcheive = slAcheive;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("slId", getSlId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SalerVO) ) return false;
        SalerVO castOther = (SalerVO) other;
        return new EqualsBuilder()
            .append(this.getSlId(), castOther.getSlId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSlId())
            .toHashCode();
    }

}
