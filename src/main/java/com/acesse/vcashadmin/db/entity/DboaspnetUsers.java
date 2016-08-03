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
@Table(name = "dbo_aspnet_Users", catalog = "vcash", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ApplicationId", "LoweredUserName"}),
        @UniqueConstraint(columnNames = {"UserId"})})
@XmlRootElement
public class DboaspnetUsers implements Serializable {

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
    @Column(name = "UserId", nullable = false, length = 64)
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "UserName", nullable = false, length = 256)
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "LoweredUserName", nullable = false, length = 256)
    private String loweredUserName;
    @Size(max = 16)
    @Column(name = "MobileAlias", length = 16)
    private String mobileAlias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsAnonymous", nullable = false)
    private boolean isAnonymous;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastActivityDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastActivityDate;

    public DboaspnetUsers() {
    }

    public DboaspnetUsers(String userId) {
        this.userId = userId;
    }

    public DboaspnetUsers(String userId, String applicationId, String userName, String loweredUserName, boolean isAnonymous, Date lastActivityDate) {
        this.userId = userId;
        this.applicationId = applicationId;
        this.userName = userName;
        this.loweredUserName = loweredUserName;
        this.isAnonymous = isAnonymous;
        this.lastActivityDate = lastActivityDate;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoweredUserName() {
        return loweredUserName;
    }

    public void setLoweredUserName(String loweredUserName) {
        this.loweredUserName = loweredUserName;
    }

    public String getMobileAlias() {
        return mobileAlias;
    }

    public void setMobileAlias(String mobileAlias) {
        this.mobileAlias = mobileAlias;
    }

    public boolean getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
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
        if (!(object instanceof DboaspnetUsers)) {
            return false;
        }
        DboaspnetUsers other = (DboaspnetUsers) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acesse.vcashadmin.db.entity.DboaspnetUsers[ userId=" + userId + " ]";
    }

}
