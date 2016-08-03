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
@Table(name = "dbo_aspnet_Applications", catalog = "vcash", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ApplicationName"}),
        @UniqueConstraint(columnNames = {"ApplicationId"}),
        @UniqueConstraint(columnNames = {"LoweredApplicationName"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DboaspnetApplications.findAll", query = "SELECT d FROM DboaspnetApplications d"),
        @NamedQuery(name = "DboaspnetApplications.findByApplicationName", query = "SELECT d FROM DboaspnetApplications d WHERE d.applicationName = :applicationName"),
        @NamedQuery(name = "DboaspnetApplications.findByLoweredApplicationName", query = "SELECT d FROM DboaspnetApplications d WHERE d.loweredApplicationName = :loweredApplicationName"),
        @NamedQuery(name = "DboaspnetApplications.findByApplicationId", query = "SELECT d FROM DboaspnetApplications d WHERE d.applicationId = :applicationId"),
        @NamedQuery(name = "DboaspnetApplications.findByDescription", query = "SELECT d FROM DboaspnetApplications d WHERE d.description = :description")})
public class DboaspnetApplications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "ApplicationName", nullable = false, length = 256)
    private String applicationName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "LoweredApplicationName", nullable = false, length = 256)
    private String loweredApplicationName;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "ApplicationId", nullable = false, length = 64)
    private String applicationId;
    @Size(max = 256)
    @Column(name = "Description", length = 256)
    private String description;

    public DboaspnetApplications() {
    }

    public DboaspnetApplications(String applicationId) {
        this.applicationId = applicationId;
    }

    public DboaspnetApplications(String applicationId, String applicationName, String loweredApplicationName) {
        this.applicationId = applicationId;
        this.applicationName = applicationName;
        this.loweredApplicationName = loweredApplicationName;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getLoweredApplicationName() {
        return loweredApplicationName;
    }

    public void setLoweredApplicationName(String loweredApplicationName) {
        this.loweredApplicationName = loweredApplicationName;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
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
        hash += (applicationId != null ? applicationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DboaspnetApplications)) {
            return false;
        }
        DboaspnetApplications other = (DboaspnetApplications) object;
        if ((this.applicationId == null && other.applicationId != null) || (this.applicationId != null && !this.applicationId.equals(other.applicationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acesse.vcashadmin.db.entity.DboaspnetApplications[ applicationId=" + applicationId + " ]";
    }

}
