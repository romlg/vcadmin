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
import java.util.Date;

/**
 * @author Vadim_Korostelev
 */
@Entity
@Table(name = "dbo_aspnet_PersonalizationAllUsers", catalog = "vcash", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"PathId"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DboaspnetPersonalizationAllUsers.findAll", query = "SELECT d FROM DboaspnetPersonalizationAllUsers d"),
        @NamedQuery(name = "DboaspnetPersonalizationAllUsers.findByPathId", query = "SELECT d FROM DboaspnetPersonalizationAllUsers d WHERE d.pathId = :pathId"),
        @NamedQuery(name = "DboaspnetPersonalizationAllUsers.findByLastUpdatedDate", query = "SELECT d FROM DboaspnetPersonalizationAllUsers d WHERE d.lastUpdatedDate = :lastUpdatedDate")})
public class DboaspnetPersonalizationAllUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "PathId", nullable = false, length = 64)
    private String pathId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "PageSettings", nullable = false)
    private byte[] pageSettings;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastUpdatedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;

    public DboaspnetPersonalizationAllUsers() {
    }

    public DboaspnetPersonalizationAllUsers(String pathId) {
        this.pathId = pathId;
    }

    public DboaspnetPersonalizationAllUsers(String pathId, byte[] pageSettings, Date lastUpdatedDate) {
        this.pathId = pathId;
        this.pageSettings = pageSettings;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    public byte[] getPageSettings() {
        return pageSettings;
    }

    public void setPageSettings(byte[] pageSettings) {
        this.pageSettings = pageSettings;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
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
        if (!(object instanceof DboaspnetPersonalizationAllUsers)) {
            return false;
        }
        DboaspnetPersonalizationAllUsers other = (DboaspnetPersonalizationAllUsers) object;
        if ((this.pathId == null && other.pathId != null) || (this.pathId != null && !this.pathId.equals(other.pathId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acesse.vcashadmin.db.entity.DboaspnetPersonalizationAllUsers[ pathId=" + pathId + " ]";
    }

}
