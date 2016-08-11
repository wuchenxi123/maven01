package com.manage.campus.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CampusVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long cpId;

    /** nullable persistent field */
    private String cpName;

    /** nullable persistent field */
    private java.util.Date cpRecorddate;

    /** full constructor */
    public CampusVO(java.lang.Long cpId, java.lang.String cpName, java.util.Date cpRecorddate) {
        this.cpId = cpId;
        this.cpName = cpName;
        this.cpRecorddate = cpRecorddate;
    }

    /** default constructor */
    public CampusVO() {
    }

    /** minimal constructor */
    public CampusVO(java.lang.Long cpId) {
        this.cpId = cpId;
    }

    public java.lang.Long getCpId() {
        return this.cpId;
    }

    public void setCpId(java.lang.Long cpId) {
        this.cpId = cpId;
    }

    public java.lang.String getCpName() {
        return this.cpName;
    }

    public void setCpName(java.lang.String cpName) {
        this.cpName = cpName;
    }

    public java.util.Date getCpRecorddate() {
        return this.cpRecorddate;
    }

    public void setCpRecorddate(java.util.Date cpRecorddate) {
        this.cpRecorddate = cpRecorddate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cpId", getCpId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CampusVO) ) return false;
        CampusVO castOther = (CampusVO) other;
        return new EqualsBuilder()
            .append(this.getCpId(), castOther.getCpId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCpId())
            .toHashCode();
    }

}
