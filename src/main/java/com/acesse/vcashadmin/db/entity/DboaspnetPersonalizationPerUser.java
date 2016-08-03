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
@Table(name = "dbo_aspnet_PersonalizationPerUser", catalog = "vcash", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"UserId"}),
        @UniqueConstraint(columnNames = {"Id"}),
        @UniqueConstraint(columnNames = {"PathId", "UserId"}),
        @UniqueConstraint(columnNames = {"PathId"}),
        @UniqueConstraint(columnNames = {"UserId", "PathId"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DboaspnetPersonalizationPerUser.findAll", query = "SELECT d FROM DboaspnetPersonalizationPerUser d"),
        @NamedQuery(name = "DboaspnetPersonalizationPerUser.findById", query = "SELECT d FROM DboaspnetPersonalizationPerUser d WHERE d.id = :id"),
        @NamedQuery(name = "DboaspnetPersonalizationPerUser.findByPathId", query = "SELECT d FROM DboaspnetPersonalizationPerUser d WHERE d.pathId = :pathId"),
        @NamedQuery(name = "DboaspnetPersonalizationPerUser.findByUserId", query = "SELECT d FROM DboaspnetPersonalizationPerUser d WHERE d.userId = :userId"),
        @NamedQuery(name = "DboaspnetPersonalizationPerUser.findByLastUpdatedDate", query = "SELECT d FROM DboaspnetPersonalizationPerUser d WHERE d.lastUpdatedDate = :lastUpdatedDate")})
public class DboaspnetPersonalizationPerUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Id", nullable = false, length = 64)
    private String id;
    @Size(max = 64)
    @Column(name = "PathId", length = 64)
    private String pathId;
    @Size(max = 64)
    @Column(name = "UserId", length = 64)
    private String userId;
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

    public DboaspnetPersonalizationPerUser() {
    }

    public DboaspnetPersonalizationPerUser(String id) {
        this.id = id;
    }

    public DboaspnetPersonalizationPerUser(String id, byte[] pageSettings, Date lastUpdatedDate) {
        this.id = id;
        this.pageSettings = pageSettings;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DboaspnetPersonalizationPerUser)) {
            return false;
        }
        DboaspnetPersonalizationPerUser other = (DboaspnetPersonalizationPerUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acesse.vcashadmin.db.entity.DboaspnetPersonalizationPerUser[ id=" + id + " ]";
    }

}
