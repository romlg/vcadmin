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
@Table(name = "dbo_aspnet_Profile", catalog = "vcash", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"UserId"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DboaspnetProfile.findAll", query = "SELECT d FROM DboaspnetProfile d"),
        @NamedQuery(name = "DboaspnetProfile.findByUserId", query = "SELECT d FROM DboaspnetProfile d WHERE d.userId = :userId"),
        @NamedQuery(name = "DboaspnetProfile.findByLastUpdatedDate", query = "SELECT d FROM DboaspnetProfile d WHERE d.lastUpdatedDate = :lastUpdatedDate")})
public class DboaspnetProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "UserId", nullable = false, length = 64)
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "PropertyNames", nullable = false, length = 2147483647)
    private String propertyNames;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "PropertyValuesString", nullable = false, length = 2147483647)
    private String propertyValuesString;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "PropertyValuesBinary", nullable = false)
    private byte[] propertyValuesBinary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastUpdatedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;

    public DboaspnetProfile() {
    }

    public DboaspnetProfile(String userId) {
        this.userId = userId;
    }

    public DboaspnetProfile(String userId, String propertyNames, String propertyValuesString, byte[] propertyValuesBinary, Date lastUpdatedDate) {
        this.userId = userId;
        this.propertyNames = propertyNames;
        this.propertyValuesString = propertyValuesString;
        this.propertyValuesBinary = propertyValuesBinary;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPropertyNames() {
        return propertyNames;
    }

    public void setPropertyNames(String propertyNames) {
        this.propertyNames = propertyNames;
    }

    public String getPropertyValuesString() {
        return propertyValuesString;
    }

    public void setPropertyValuesString(String propertyValuesString) {
        this.propertyValuesString = propertyValuesString;
    }

    public byte[] getPropertyValuesBinary() {
        return propertyValuesBinary;
    }

    public void setPropertyValuesBinary(byte[] propertyValuesBinary) {
        this.propertyValuesBinary = propertyValuesBinary;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DboaspnetProfile)) {
            return false;
        }
        DboaspnetProfile other = (DboaspnetProfile) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acesse.vcashadmin.db.entity.DboaspnetProfile[ userId=" + userId + " ]";
    }

}
