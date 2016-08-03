/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acesse.vcashadmin.db.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Vadim_Korostelev
 */
@Embeddable
public class DboaspnetUsersInRolesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "UserId", nullable = false, length = 64)
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "RoleId", nullable = false, length = 64)
    private String roleId;

    public DboaspnetUsersInRolesPK() {
    }

    public DboaspnetUsersInRolesPK(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DboaspnetUsersInRolesPK)) {
            return false;
        }
        DboaspnetUsersInRolesPK other = (DboaspnetUsersInRolesPK) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acesse.vcashadmin.db.entity.DboaspnetUsersInRolesPK[ userId=" + userId + ", roleId=" + roleId + " ]";
    }

}
