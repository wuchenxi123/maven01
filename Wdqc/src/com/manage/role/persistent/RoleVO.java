package com.manage.role.persistent;

import com.core.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RoleVO extends BaseVO implements Serializable {

    /** identifier field */
    private Integer roleId;

    /** nullable persistent field */
    private String roleName;

    /** full constructor */
    public RoleVO(java.lang.String roleName) {
        this.roleName = roleName;
    }

    /** default constructor */
    public RoleVO() {
    }

    public java.lang.Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(java.lang.Integer roleId) {
        this.roleId = roleId;
    }

    public java.lang.String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(java.lang.String roleName) {
        this.roleName = roleName;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("roleId", getRoleId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RoleVO) ) return false;
        RoleVO castOther = (RoleVO) other;
        return new EqualsBuilder()
            .append(this.getRoleId(), castOther.getRoleId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRoleId())
            .toHashCode();
    }

}
