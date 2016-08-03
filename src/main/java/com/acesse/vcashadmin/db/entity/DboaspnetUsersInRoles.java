/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acesse.vcashadmin.db.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Vadim_Korostelev
 */
@Entity
@Table(name = "dbo_aspnet_UsersInRoles", catalog = "vcash", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"UserId"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DboaspnetUsersInRoles.findAll", query = "SELECT d FROM DboaspnetUsersInRoles d"),
        @NamedQuery(name = "DboaspnetUsersInRoles.findByUserId", query = "SELECT d FROM DboaspnetUsersInRoles d WHERE d.dboaspnetUsersInRolesPK.userId = :userId"),
        @NamedQuery(name = "DboaspnetUsersInRoles.findByRoleId", query = "SELECT d FROM DboaspnetUsersInRoles d WHERE d.dboaspnetUsersInRolesPK.roleId = :roleId")})
public class DboaspnetUsersInRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DboaspnetUsersInRolesPK dboaspnetUsersInRolesPK;

    public DboaspnetUsersInRoles() {
    }

    public DboaspnetUsersInRoles(DboaspnetUsersInRolesPK dboaspnetUsersInRolesPK) {
        this.dboaspnetUsersInRolesPK = dboaspnetUsersInRolesPK;
    }

    public DboaspnetUsersInRoles(String userId, String roleId) {
        this.dboaspnetUsersInRolesPK = new DboaspnetUsersInRolesPK(userId, roleId);
    }

    public DboaspnetUsersInRolesPK getDboaspnetUsersInRolesPK() {
        return dboaspnetUsersInRolesPK;
    }

    public void setDboaspnetUsersInRolesPK(DboaspnetUsersInRolesPK dboaspnetUsersInRolesPK) {
        this.dboaspnetUsersInRolesPK = dboaspnetUsersInRolesPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dboaspnetUsersInRolesPK != null ? dboaspnetUsersInRolesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DboaspnetUsersInRoles)) {
            return false;
        }
        DboaspnetUsersInRoles other = (DboaspnetUsersInRoles) object;
        if ((this.dboaspnetUsersInRolesPK == null && other.dboaspnetUsersInRolesPK != null) || (this.dboaspnetUsersInRolesPK != null && !this.dboaspnetUsersInRolesPK.equals(other.dboaspnetUsersInRolesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acesse.vcashadmin.db.entity.DboaspnetUsersInRoles[ dboaspnetUsersInRolesPK=" + dboaspnetUsersInRolesPK + " ]";
    }

}
