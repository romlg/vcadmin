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
@Table(name = "dbo_aspnet_Membership", catalog = "vcash", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"UserId"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DboaspnetMembership.findAll", query = "SELECT d FROM DboaspnetMembership d"),
        @NamedQuery(name = "DboaspnetMembership.findByApplicationId", query = "SELECT d FROM DboaspnetMembership d WHERE d.applicationId = :applicationId"),
        @NamedQuery(name = "DboaspnetMembership.findByUserId", query = "SELECT d FROM DboaspnetMembership d WHERE d.userId = :userId"),
        @NamedQuery(name = "DboaspnetMembership.findByPassword", query = "SELECT d FROM DboaspnetMembership d WHERE d.password = :password"),
        @NamedQuery(name = "DboaspnetMembership.findByPasswordFormat", query = "SELECT d FROM DboaspnetMembership d WHERE d.passwordFormat = :passwordFormat"),
        @NamedQuery(name = "DboaspnetMembership.findByPasswordSalt", query = "SELECT d FROM DboaspnetMembership d WHERE d.passwordSalt = :passwordSalt"),
        @NamedQuery(name = "DboaspnetMembership.findByMobilePIN", query = "SELECT d FROM DboaspnetMembership d WHERE d.mobilePIN = :mobilePIN"),
        @NamedQuery(name = "DboaspnetMembership.findByEmail", query = "SELECT d FROM DboaspnetMembership d WHERE d.email = :email"),
        @NamedQuery(name = "DboaspnetMembership.findByLoweredEmail", query = "SELECT d FROM DboaspnetMembership d WHERE d.loweredEmail = :loweredEmail"),
        @NamedQuery(name = "DboaspnetMembership.findByPasswordQuestion", query = "SELECT d FROM DboaspnetMembership d WHERE d.passwordQuestion = :passwordQuestion"),
        @NamedQuery(name = "DboaspnetMembership.findByPasswordAnswer", query = "SELECT d FROM DboaspnetMembership d WHERE d.passwordAnswer = :passwordAnswer"),
        @NamedQuery(name = "DboaspnetMembership.findByIsApproved", query = "SELECT d FROM DboaspnetMembership d WHERE d.isApproved = :isApproved"),
        @NamedQuery(name = "DboaspnetMembership.findByIsLockedOut", query = "SELECT d FROM DboaspnetMembership d WHERE d.isLockedOut = :isLockedOut"),
        @NamedQuery(name = "DboaspnetMembership.findByCreateDate", query = "SELECT d FROM DboaspnetMembership d WHERE d.createDate = :createDate"),
        @NamedQuery(name = "DboaspnetMembership.findByLastLoginDate", query = "SELECT d FROM DboaspnetMembership d WHERE d.lastLoginDate = :lastLoginDate"),
        @NamedQuery(name = "DboaspnetMembership.findByLastPasswordChangedDate", query = "SELECT d FROM DboaspnetMembership d WHERE d.lastPasswordChangedDate = :lastPasswordChangedDate"),
        @NamedQuery(name = "DboaspnetMembership.findByLastLockoutDate", query = "SELECT d FROM DboaspnetMembership d WHERE d.lastLockoutDate = :lastLockoutDate"),
        @NamedQuery(name = "DboaspnetMembership.findByFailedPasswordAttemptCount", query = "SELECT d FROM DboaspnetMembership d WHERE d.failedPasswordAttemptCount = :failedPasswordAttemptCount"),
        @NamedQuery(name = "DboaspnetMembership.findByFailedPasswordAttemptWindowStart", query = "SELECT d FROM DboaspnetMembership d WHERE d.failedPasswordAttemptWindowStart = :failedPasswordAttemptWindowStart"),
        @NamedQuery(name = "DboaspnetMembership.findByFailedPasswordAnswerAttemptCount", query = "SELECT d FROM DboaspnetMembership d WHERE d.failedPasswordAnswerAttemptCount = :failedPasswordAnswerAttemptCount"),
        @NamedQuery(name = "DboaspnetMembership.findByFailedPasswordAnswerAttemptWindowStart", query = "SELECT d FROM DboaspnetMembership d WHERE d.failedPasswordAnswerAttemptWindowStart = :failedPasswordAnswerAttemptWindowStart")})
public class DboaspnetMembership implements Serializable {

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
    @Size(min = 1, max = 128)
    @Column(name = "Password", nullable = false, length = 128)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PasswordFormat", nullable = false)
    private int passwordFormat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "PasswordSalt", nullable = false, length = 128)
    private String passwordSalt;
    @Size(max = 16)
    @Column(name = "MobilePIN", length = 16)
    private String mobilePIN;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 256)
    @Column(name = "Email", length = 256)
    private String email;
    @Size(max = 256)
    @Column(name = "LoweredEmail", length = 256)
    private String loweredEmail;
    @Size(max = 256)
    @Column(name = "PasswordQuestion", length = 256)
    private String passwordQuestion;
    @Size(max = 128)
    @Column(name = "PasswordAnswer", length = 128)
    private String passwordAnswer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsApproved", nullable = false)
    private boolean isApproved;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsLockedOut", nullable = false)
    private boolean isLockedOut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreateDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastLoginDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastPasswordChangedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordChangedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastLockoutDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLockoutDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FailedPasswordAttemptCount", nullable = false)
    private int failedPasswordAttemptCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FailedPasswordAttemptWindowStart", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date failedPasswordAttemptWindowStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FailedPasswordAnswerAttemptCount", nullable = false)
    private int failedPasswordAnswerAttemptCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FailedPasswordAnswerAttemptWindowStart", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date failedPasswordAnswerAttemptWindowStart;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Comment", length = 2147483647)
    private String comment;

    public DboaspnetMembership() {
    }

    public DboaspnetMembership(String userId) {
        this.userId = userId;
    }

    public DboaspnetMembership(String userId, String applicationId, String password, int passwordFormat, String passwordSalt, boolean isApproved, boolean isLockedOut, Date createDate, Date lastLoginDate, Date lastPasswordChangedDate, Date lastLockoutDate, int failedPasswordAttemptCount, Date failedPasswordAttemptWindowStart, int failedPasswordAnswerAttemptCount, Date failedPasswordAnswerAttemptWindowStart) {
        this.userId = userId;
        this.applicationId = applicationId;
        this.password = password;
        this.passwordFormat = passwordFormat;
        this.passwordSalt = passwordSalt;
        this.isApproved = isApproved;
        this.isLockedOut = isLockedOut;
        this.createDate = createDate;
        this.lastLoginDate = lastLoginDate;
        this.lastPasswordChangedDate = lastPasswordChangedDate;
        this.lastLockoutDate = lastLockoutDate;
        this.failedPasswordAttemptCount = failedPasswordAttemptCount;
        this.failedPasswordAttemptWindowStart = failedPasswordAttemptWindowStart;
        this.failedPasswordAnswerAttemptCount = failedPasswordAnswerAttemptCount;
        this.failedPasswordAnswerAttemptWindowStart = failedPasswordAnswerAttemptWindowStart;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPasswordFormat() {
        return passwordFormat;
    }

    public void setPasswordFormat(int passwordFormat) {
        this.passwordFormat = passwordFormat;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getMobilePIN() {
        return mobilePIN;
    }

    public void setMobilePIN(String mobilePIN) {
        this.mobilePIN = mobilePIN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoweredEmail() {
        return loweredEmail;
    }

    public void setLoweredEmail(String loweredEmail) {
        this.loweredEmail = loweredEmail;
    }

    public String getPasswordQuestion() {
        return passwordQuestion;
    }

    public void setPasswordQuestion(String passwordQuestion) {
        this.passwordQuestion = passwordQuestion;
    }

    public String getPasswordAnswer() {
        return passwordAnswer;
    }

    public void setPasswordAnswer(String passwordAnswer) {
        this.passwordAnswer = passwordAnswer;
    }

    public boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public boolean getIsLockedOut() {
        return isLockedOut;
    }

    public void setIsLockedOut(boolean isLockedOut) {
        this.isLockedOut = isLockedOut;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getLastPasswordChangedDate() {
        return lastPasswordChangedDate;
    }

    public void setLastPasswordChangedDate(Date lastPasswordChangedDate) {
        this.lastPasswordChangedDate = lastPasswordChangedDate;
    }

    public Date getLastLockoutDate() {
        return lastLockoutDate;
    }

    public void setLastLockoutDate(Date lastLockoutDate) {
        this.lastLockoutDate = lastLockoutDate;
    }

    public int getFailedPasswordAttemptCount() {
        return failedPasswordAttemptCount;
    }

    public void setFailedPasswordAttemptCount(int failedPasswordAttemptCount) {
        this.failedPasswordAttemptCount = failedPasswordAttemptCount;
    }

    public Date getFailedPasswordAttemptWindowStart() {
        return failedPasswordAttemptWindowStart;
    }

    public void setFailedPasswordAttemptWindowStart(Date failedPasswordAttemptWindowStart) {
        this.failedPasswordAttemptWindowStart = failedPasswordAttemptWindowStart;
    }

    public int getFailedPasswordAnswerAttemptCount() {
        return failedPasswordAnswerAttemptCount;
    }

    public void setFailedPasswordAnswerAttemptCount(int failedPasswordAnswerAttemptCount) {
        this.failedPasswordAnswerAttemptCount = failedPasswordAnswerAttemptCount;
    }

    public Date getFailedPasswordAnswerAttemptWindowStart() {
        return failedPasswordAnswerAttemptWindowStart;
    }

    public void setFailedPasswordAnswerAttemptWindowStart(Date failedPasswordAnswerAttemptWindowStart) {
        this.failedPasswordAnswerAttemptWindowStart = failedPasswordAnswerAttemptWindowStart;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        if (!(object instanceof DboaspnetMembership)) {
            return false;
        }
        DboaspnetMembership other = (DboaspnetMembership) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acesse.vcashadmin.db.entity.DboaspnetMembership[ userId=" + userId + " ]";
    }

}
