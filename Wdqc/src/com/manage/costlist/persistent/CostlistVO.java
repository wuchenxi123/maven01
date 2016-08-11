package com.manage.costlist.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import com.manage.gradlass.persistent.GradlassVO;
import com.manage.member.persistent.MemberVO;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CostlistVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long cltId;

    /** nullable persistent field */
    private Integer stId;

    /** nullable persistent field */
    private Integer csId;

    /** nullable persistent field */
    private Integer cltType;

    /** nullable persistent field */
    private String cltRemark;

    /** nullable persistent field */
    private Integer cltReduce;

    /** nullable persistent field */
    private String cltSaleboolname;

    /** nullable persistent field */
    private Integer cltSaletextbookid;

    /** nullable persistent field */
    private Integer cltApply;

    /** nullable persistent field */
    private Integer cltSpeical;

    /** nullable persistent field */
    private Integer cltSum;

    /** nullable persistent field */
    private Integer creator;

    /** nullable persistent field */
    private java.util.Date createTime;
    
/*    *//** nullable persistent field *//*
    private GradlassVO gradlass;*/
    
    private String member;
    
    private String csname;
    
    private String cscharge;

    /** full constructor */
    public CostlistVO(java.lang.Integer stId, java.lang.Integer csId, java.lang.Integer cltType, java.lang.String cltRemark, java.lang.Integer cltReduce, java.lang.String cltSaleboolname, java.lang.Integer cltSaletextbookid, java.lang.Integer cltApply, java.lang.Integer cltSpeical, java.lang.Integer cltSum, java.lang.Integer creator, java.util.Date createTime) {
        this.stId = stId;
        this.csId = csId;
        this.cltType = cltType;
        this.cltRemark = cltRemark;
        this.cltReduce = cltReduce;
        this.cltSaleboolname = cltSaleboolname;
        this.cltSaletextbookid = cltSaletextbookid;
        this.cltApply = cltApply;
        this.cltSpeical = cltSpeical;
        this.cltSum = cltSum;
        this.creator = creator;
        this.createTime = createTime;
    }

    /** default constructor */
    public CostlistVO() {
    }

    public java.lang.Long getCltId() {
        return this.cltId;
    }

    public void setCltId(java.lang.Long cltId) {
        this.cltId = cltId;
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

    public java.lang.Integer getCltType() {
        return this.cltType;
    }

    public void setCltType(java.lang.Integer cltType) {
        this.cltType = cltType;
    }

    public java.lang.String getCltRemark() {
        return this.cltRemark;
    }

    public void setCltRemark(java.lang.String cltRemark) {
        this.cltRemark = cltRemark;
    }

    public java.lang.Integer getCltReduce() {
        return this.cltReduce;
    }

    public void setCltReduce(java.lang.Integer cltReduce) {
        this.cltReduce = cltReduce;
    }

    public java.lang.String getCltSaleboolname() {
        return this.cltSaleboolname;
    }

    public void setCltSaleboolname(java.lang.String cltSaleboolname) {
        this.cltSaleboolname = cltSaleboolname;
    }

    public java.lang.Integer getCltSaletextbookid() {
        return this.cltSaletextbookid;
    }

    public void setCltSaletextbookid(java.lang.Integer cltSaletextbookid) {
        this.cltSaletextbookid = cltSaletextbookid;
    }

    public java.lang.Integer getCltApply() {
        return this.cltApply;
    }

    public void setCltApply(java.lang.Integer cltApply) {
        this.cltApply = cltApply;
    }

    public java.lang.Integer getCltSpeical() {
        return this.cltSpeical;
    }

    public void setCltSpeical(java.lang.Integer cltSpeical) {
        this.cltSpeical = cltSpeical;
    }

    public java.lang.Integer getCltSum() {
        return this.cltSum;
    }

    public void setCltSum(java.lang.Integer cltSum) {
        this.cltSum = cltSum;
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
            .append("cltId", getCltId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CostlistVO) ) return false;
        CostlistVO castOther = (CostlistVO) other;
        return new EqualsBuilder()
            .append(this.getCltId(), castOther.getCltId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCltId())
            .toHashCode();
    }
/*
	public GradlassVO getGradlass() {
		return gradlass;
	}

	public void setGradlass(GradlassVO gradlass) {
		this.gradlass = gradlass;
	}*/

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public String getCscharge() {
		return cscharge;
	}

	public void setCscharge(String cscharge) {
		this.cscharge = cscharge;
	}




}
