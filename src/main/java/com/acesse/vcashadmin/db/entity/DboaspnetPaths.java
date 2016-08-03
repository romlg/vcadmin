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
@Table(name = "dbo_aspnet_Paths", catalog = "vcash", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ApplicationId", "LoweredPath"}),
        @UniqueConstraint(columnNames = {"ApplicationId"}),
        @UniqueConstraint(columnNames = {"PathId"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DboaspnetPaths.findAll", query = "SELECT d FROM DboaspnetPaths d"),
        @NamedQuery(name = "DboaspnetPaths.findByApplicationId", query = "SELECT d FROM DboaspnetPaths d WHERE d.applicationId = :applicationId"),
        @NamedQuery(name = "DboaspnetPaths.findByPathId", query = "SELECT d FROM DboaspnetPaths d WHERE d.pathId = :pathId"),
        @NamedQuery(name = "DboaspnetPaths.findByPath", query = "SELECT d FROM DboaspnetPaths d WHERE d.path = :path"),
        @NamedQuery(name = "DboaspnetPaths.findByLoweredPath", query = "SELECT d FROM DboaspnetPaths d WHERE d.loweredPath = :loweredPath")})
public class DboaspnetPaths implements Serializable {

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
    @Column(name = "PathId", nullable = false, length = 64)
    private String pathId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "Path", nullable = false, length = 256)
    private String path;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "LoweredPath", nullable = false, length = 256)
    private String loweredPath;

    public DboaspnetPaths() {
    }

    public DboaspnetPaths(String pathId) {
        this.pathId = pathId;
    }

    public DboaspnetPaths(String pathId, String applicationId, String path, String loweredPath) {
        this.pathId = pathId;
        this.applicationId = applicationId;
        this.path = path;
        this.loweredPath = loweredPath;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLoweredPath() {
        return loweredPath;
    }

    public void setLoweredPath(String loweredPath) {
        this.loweredPath = loweredPath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pathId != null ? pathId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DboaspnetPaths)) {
            return false;
        }
        DboaspnetPaths other = (DboaspnetPaths) object;
        if ((this.pathId == null && other.pathId != null) || (this.pathId != null && !this.pathId.equals(other.pathId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acesse.vcashadmin.db.entity.DboaspnetPaths[ pathId=" + pathId + " ]";
    }

}
