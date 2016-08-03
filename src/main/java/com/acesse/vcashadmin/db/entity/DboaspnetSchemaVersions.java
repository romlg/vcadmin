/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acesse.vcashadmin.db.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Vadim_Korostelev
 */
@Entity
@Table(name = "dbo_aspnet_SchemaVersions", catalog = "vcash", schema = "")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DboaspnetSchemaVersions.findAll", query = "SELECT d FROM DboaspnetSchemaVersions d"),
        @NamedQuery(name = "DboaspnetSchemaVersions.findByFeature", query = "SELECT d FROM DboaspnetSchemaVersions d WHERE d.dboaspnetSchemaVersionsPK.feature = :feature"),
        @NamedQuery(name = "DboaspnetSchemaVersions.findByCompatibleSchemaVersion", query = "SELECT d FROM DboaspnetSchemaVersions d WHERE d.dboaspnetSchemaVersionsPK.compatibleSchemaVersion = :compatibleSchemaVersion"),
        @NamedQuery(name = "DboaspnetSchemaVersions.findByIsCurrentVersion", query = "SELECT d FROM DboaspnetSchemaVersions d WHERE d.isCurrentVersion = :isCurrentVersion")})
public class DboaspnetSchemaVersions implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DboaspnetSchemaVersionsPK dboaspnetSchemaVersionsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsCurrentVersion", nullable = false)
    private boolean isCurrentVersion;

    public DboaspnetSchemaVersions() {
    }

    public DboaspnetSchemaVersions(DboaspnetSchemaVersionsPK dboaspnetSchemaVersionsPK) {
        this.dboaspnetSchemaVersionsPK = dboaspnetSchemaVersionsPK;
    }

    public DboaspnetSchemaVersions(DboaspnetSchemaVersionsPK dboaspnetSchemaVersionsPK, boolean isCurrentVersion) {
        this.dboaspnetSchemaVersionsPK = dboaspnetSchemaVersionsPK;
        this.isCurrentVersion = isCurrentVersion;
    }

    public DboaspnetSchemaVersions(String feature, String compatibleSchemaVersion) {
        this.dboaspnetSchemaVersionsPK = new DboaspnetSchemaVersionsPK(feature, compatibleSchemaVersion);
    }

    public DboaspnetSchemaVersionsPK getDboaspnetSchemaVersionsPK() {
        return dboaspnetSchemaVersionsPK;
    }

    public void setDboaspnetSchemaVersionsPK(DboaspnetSchemaVersionsPK dboaspnetSchemaVersionsPK) {
        this.dboaspnetSchemaVersionsPK = dboaspnetSchemaVersionsPK;
    }

    public boolean getIsCurrentVersion() {
        return isCurrentVersion;
    }

    public void setIsCurrentVersion(boolean isCurrentVersion) {
        this.isCurrentVersion = isCurrentVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dboaspnetSchemaVersionsPK != null ? dboaspnetSchemaVersionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DboaspnetSchemaVersions)) {
            return false;
        }
        DboaspnetSchemaVersions other = (DboaspnetSchemaVersions) object;
        if ((this.dboaspnetSchemaVersionsPK == null && other.dboaspnetSchemaVersionsPK != null) || (this.dboaspnetSchemaVersionsPK != null && !this.dboaspnetSchemaVersionsPK.equals(other.dboaspnetSchemaVersionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acesse.vcashadmin.db.entity.DboaspnetSchemaVersions[ dboaspnetSchemaVersionsPK=" + dboaspnetSchemaVersionsPK + " ]";
    }

}
