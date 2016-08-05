package com.manage.course.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import com.core.jop.infrastructure.db.DataPackage;
import com.manage.group.persistent.GroupVO;
import com.manage.member.persistent.MemberVO;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CourseVO extends BaseVO implements Serializable {

    /** identifier field */
    private Integer coId;

    /** nullable persistent field */
    private String coName;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private Integer creator;

    /** nullable persistent field */
    private java.util.Date updatetime;

    /** nullable persistent field */
    private Integer updator;

    /** nullable persistent field */
    private Integer coClassify;
    
    private String creatername;
     
    private MemberVO member;
    private List<GroupVO> gs=null;
    private DataPackage dp;
    /** full constructor */
    public CourseVO(java.lang.String coName, java.util.Date createtime, java.lang.Integer creator, java.util.Date updatetime, java.lang.Integer updator, java.lang.Integer coClassify) {
        this.coName = coName;
        this.createtime = createtime;
        this.creator = creator;
        this.updatetime = updatetime;
        this.updator = updator;
        this.coClassify = coClassify;
    }

    /** default constructor */
    public CourseVO() {
    }

    public java.lang.Integer getCoId() {
        return this.coId;
    }

    public void setCoId(java.lang.Integer coId) {
        this.coId = coId;
    }

    public java.lang.String getCoName() {
        return this.coName;
    }

    public void setCoName(java.lang.String coName) {
        this.coName = coName;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.Integer getCreator() {
        return this.creator;
    }

    public void setCreator(java.lang.Integer creator) {
        this.creator = creator;
    }

    public java.util.Date getUpdatetime() {
        return this.updatetime;
    }

    public void setUpdatetime(java.util.Date updatetime) {
        this.updatetime = updatetime;
    }

    public java.lang.Integer getUpdator() {
        return this.updator;
    }

    public void setUpdator(java.lang.Integer updator) {
        this.updator = updator;
    }

    public java.lang.Integer getCoClassify() {
        return this.coClassify;
    }

    public void setCoClassify(java.lang.Integer coClassify) {
        this.coClassify = coClassify;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("coId", getCoId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CourseVO) ) return false;
        CourseVO castOther = (CourseVO) other;
        return new EqualsBuilder()
            .append(this.getCoId(), castOther.getCoId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCoId())
            .toHashCode();
    }

	public List<GroupVO> getGs() {
		return gs;
	}

	public void setGs(List<GroupVO> gs) {
		this.gs = gs;
	}

	public DataPackage getDp() {
		return dp;
	}

	public void setDp(DataPackage dp) {
		this.dp = dp;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

	public String getCreatername() {
		return creatername;
	}

	public void setCreatername(String creatername) {
		this.creatername = creatername;
	}

}
