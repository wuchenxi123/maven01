package com.manage.message.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MessageVO extends BaseVO implements Serializable {

    /** identifier field */
    private Integer mgId;

    /** nullable persistent field */
    private String mgTitle;

    /** nullable persistent field */
    private String mgContent;

    /** nullable persistent field */
    private String mgType;

    /** nullable persistent field */
    private Integer mgCreator;
    private String mgCreatorname;
    /** nullable persistent field */
    private java.util.Date mgCreattime;

    /** full constructor */
    public MessageVO(java.lang.String mgTitle, java.lang.String mgContent, java.lang.String mgType, java.lang.Integer mgCreator, java.util.Date mgCreattime) {
        this.mgTitle = mgTitle;
        this.mgContent = mgContent;
        this.mgType = mgType;
        this.mgCreator = mgCreator;
        this.mgCreattime = mgCreattime;
    }

    /** default constructor */
    public MessageVO() {
    }

    public java.lang.Integer getMgId() {
        return this.mgId;
    }

    public void setMgId(java.lang.Integer mgId) {
        this.mgId = mgId;
    }

    public java.lang.String getMgTitle() {
        return this.mgTitle;
    }

    public void setMgTitle(java.lang.String mgTitle) {
        this.mgTitle = mgTitle;
    }

    public java.lang.String getMgContent() {
        return this.mgContent;
    }

    public void setMgContent(java.lang.String mgContent) {
        this.mgContent = mgContent;
    }

    public java.lang.String getMgType() {
        return this.mgType;
    }

    public void setMgType(java.lang.String mgType) {
        this.mgType = mgType;
    }

    public java.lang.Integer getMgCreator() {
        return this.mgCreator;
    }

    public void setMgCreator(java.lang.Integer mgCreator) {
        this.mgCreator = mgCreator;
    }

    public java.util.Date getMgCreattime() {
        return this.mgCreattime;
    }

    public void setMgCreattime(java.util.Date mgCreattime) {
        this.mgCreattime = mgCreattime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("mgId", getMgId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MessageVO) ) return false;
        MessageVO castOther = (MessageVO) other;
        return new EqualsBuilder()
            .append(this.getMgId(), castOther.getMgId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getMgId())
            .toHashCode();
    }

	public String getMgCreatorname() {
		return mgCreatorname;
	}

	public void setMgCreatorname(String mgCreatorname) {
		this.mgCreatorname = mgCreatorname;
	}

	
	

}
