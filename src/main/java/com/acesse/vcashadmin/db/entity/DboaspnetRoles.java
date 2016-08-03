/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acesse.vcashadmin.db.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Vadim_Korostelev
 */
@Entity
@Table(name = "dbo_aspnet_Roles", catalog = "vcash", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"RoleId"}),
        @UniqueConstraint(columnNames = {"ApplicationId", "LoweredRoleName"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DboaspnetRoles.findAll", query = "SELECT d FROM DboaspnetRoles d"),
        @NamedQuery(name = "DboaspnetRoles.findByApplicationId", query = "SELECT d FROM DboaspnetRoles d WHERE d.applicationId = :applicationId"),
        @NamedQuery(name = "DboaspnetRoles.findByRoleId", query = "SELECT d FROM DboaspnetRoles d WHERE d.roleId = :roleId"),
        @NamedQuery(name = "DboaspnetRoles.findByRoleName", query = "SELECT d FROM DboaspnetRoles d WHERE d.roleName = :roleName"),
        @NamedQuery(name = "DboaspnetRoles.findByLoweredRoleName", query = "SELECT d FROM DboaspnetRoles d WHERE d.loweredRoleName = :loweredRoleName"),
        @NamedQuery(name = "DboaspnetRoles.findByDescription", query = "SELECT d FROM DboaspnetRoles d WHERE d.description = :description")})
public class DboaspnetRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "ApplicationId", nullable = false, length = 64)
    private String applicationId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "RoleId", nullable = false, length = 64)
    private String roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "RoleName", nullable = false, length = 256)
    private String roleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "LoweredRoleName", nullable = false, length = 256)
    private String loweredRoleName;
    @Size(max = 256)
    @Column(name = "Description", length = 256)
    private String description;

    public DboaspnetRoles() {
    }

    public DboaspnetRoles(String roleId) {
        this.roleId = roleId;
    }

    public DboaspnetRoles(String roleId, String applicationId, String roleName, String loweredRoleName) {
        this.roleId = roleId;
        this.applicationId = applicationId;
        this.roleName = roleName;
        this.loweredRoleName = loweredRoleName;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getLoweredRoleName() {
        return loweredRoleName;
    }

    public void setLoweredRoleName(String loweredRoleName) {
        this.loweredRoleName = loweredRoleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DboaspnetRoles)) {
            return false;
        }
        DboaspnetRoles other = (DboaspnetRoles) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acesse.vcashadmin.db.entity.DboaspnetRoles[ roleId=" + roleId + " ]";
    }

}
