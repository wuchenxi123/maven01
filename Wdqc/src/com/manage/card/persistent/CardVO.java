package com.manage.card.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CardVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long scId;

    /** nullable persistent field */
    private Integer stId;

    /** nullable persistent field */
    private String scType;

    /** nullable persistent field */
    private java.util.Date scDate;

    /** persistent field */
    private java.util.Date scTime;

    /** nullable persistent field */
    private Short scWeek;

    /** nullable persistent field */
    private java.util.Date scInterval;

    /** full constructor */
    public CardVO(java.lang.Long scId, java.lang.Integer stId, java.lang.String scType, java.util.Date scDate, java.util.Date scTime, java.lang.Short scWeek, java.util.Date scInterval) {
        this.scId = scId;
        this.stId = stId;
        this.scType = scType;
        this.scDate = scDate;
        this.scTime = scTime;
        this.scWeek = scWeek;
        this.scInterval = scInterval;
    }

    /** default constructor */
    public CardVO() {
    }

    /** minimal constructor */
    public CardVO(java.lang.Long scId, java.util.Date scTime) {
        this.scId = scId;
        this.scTime = scTime;
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

    public java.lang.String getScType() {
        return this.scType;
    }

    public void setScType(java.lang.String scType) {
        this.scType = scType;
    }

    public java.util.Date getScDate() {
        return this.scDate;
    }

    public void setScDate(java.util.Date scDate) {
        this.scDate = scDate;
    }

    public java.util.Date getScTime() {
        return this.scTime;
    }

    public void setScTime(java.util.Date scTime) {
        this.scTime = scTime;
    }

    public java.lang.Short getScWeek() {
        return this.scWeek;
    }

    public void setScWeek(java.lang.Short scWeek) {
        this.scWeek = scWeek;
    }

    public java.util.Date getScInterval() {
        return this.scInterval;
    }

    public void setScInterval(java.util.Date scInterval) {
        this.scInterval = scInterval;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("scId", getScId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CardVO) ) return false;
        CardVO castOther = (CardVO) other;
        return new EqualsBuilder()
            .append(this.getScId(), castOther.getScId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getScId())
            .toHashCode();
    }

}
