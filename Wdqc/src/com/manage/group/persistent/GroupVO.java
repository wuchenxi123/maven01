package com.manage.group.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class GroupVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long groupId;

    /** nullable persistent field */
    private String groupName;

    /** full constructor */
    public GroupVO(java.lang.Long groupId, java.lang.String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    /** default constructor */
    public GroupVO() {
    }

    /** minimal constructor */
    public GroupVO(java.lang.Long groupId) {
        this.groupId = groupId;
    }

    public java.lang.Long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(java.lang.Long groupId) {
        this.groupId = groupId;
    }

    public java.lang.String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(java.lang.String groupName) {
        this.groupName = groupName;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("groupId", getGroupId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof GroupVO) ) return false;
        GroupVO castOther = (GroupVO) other;
        return new EqualsBuilder()
            .append(this.getGroupId(), castOther.getGroupId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getGroupId())
            .toHashCode();
    }

}
