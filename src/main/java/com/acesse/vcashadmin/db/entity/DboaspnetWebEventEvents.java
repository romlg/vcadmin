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
@Table(name = "dbo_aspnet_WebEvent_Events", catalog = "vcash", schema = "")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DboaspnetWebEventEvents.findAll", query = "SELECT d FROM DboaspnetWebEventEvents d"),
        @NamedQuery(name = "DboaspnetWebEventEvents.findByEventId", query = "SELECT d FROM DboaspnetWebEventEvents d WHERE d.eventId = :eventId"),
        @NamedQuery(name = "DboaspnetWebEventEvents.findByEventTimeUtc", query = "SELECT d FROM DboaspnetWebEventEvents d WHERE d.eventTimeUtc = :eventTimeUtc"),
        @NamedQuery(name = "DboaspnetWebEventEvents.findByEventTime", query = "SELECT d FROM DboaspnetWebEventEvents d WHERE d.eventTime = :eventTime"),
        @NamedQuery(name = "DboaspnetWebEventEvents.findByEventType", query = "SELECT d FROM DboaspnetWebEventEvents d WHERE d.eventType = :eventType"),
        @NamedQuery(name = "DboaspnetWebEventEvents.findByEventSequence", query = "SELECT d FROM DboaspnetWebEventEvents d WHERE d.eventSequence = :eventSequence"),
        @NamedQuery(name = "DboaspnetWebEventEvents.findByEventOccurrence", query = "SELECT d FROM DboaspnetWebEventEvents d WHERE d.eventOccurrence = :eventOccurrence"),
        @NamedQuery(name = "DboaspnetWebEventEvents.findByEventCode", query = "SELECT d FROM DboaspnetWebEventEvents d WHERE d.eventCode = :eventCode"),
        @NamedQuery(name = "DboaspnetWebEventEvents.findByEventDetailCode", query = "SELECT d FROM DboaspnetWebEventEvents d WHERE d.eventDetailCode = :eventDetailCode"),
        @NamedQuery(name = "DboaspnetWebEventEvents.findByMessage", query = "SELECT d FROM DboaspnetWebEventEvents d WHERE d.message = :message"),
        @NamedQuery(name = "DboaspnetWebEventEvents.findByApplicationPath", query = "SELECT d FROM DboaspnetWebEventEvents d WHERE d.applicationPath = :applicationPath"),
        @NamedQuery(name = "DboaspnetWebEventEvents.findByApplicationVirtualPath", query = "SELECT d FROM DboaspnetWebEventEvents d WHERE d.applicationVirtualPath = :applicationVirtualPath"),
        @NamedQuery(name = "DboaspnetWebEventEvents.findByMachineName", query = "SELECT d FROM DboaspnetWebEventEvents d WHERE d.machineName = :machineName"),
        @NamedQuery(name = "DboaspnetWebEventEvents.findByRequestUrl", query = "SELECT d FROM DboaspnetWebEventEvents d WHERE d.requestUrl = :requestUrl"),
        @NamedQuery(name = "DboaspnetWebEventEvents.findByExceptionType", query = "SELECT d FROM DboaspnetWebEventEvents d WHERE d.exceptionType = :exceptionType")})
public class DboaspnetWebEventEvents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "EventId", nullable = false, length = 32)
    private String eventId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EventTimeUtc", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventTimeUtc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EventTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "EventType", nullable = false, length = 256)
    private String eventType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EventSequence", nullable = false)
    private long eventSequence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EventOccurrence", nullable = false)
    private long eventOccurrence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EventCode", nullable = false)
    private int eventCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EventDetailCode", nullable = false)
    private int eventDetailCode;
    @Size(max = 1024)
    @Column(name = "Message", length = 1024)
    private String message;
    @Size(max = 256)
    @Column(name = "ApplicationPath", length = 256)
    private String applicationPath;
    @Size(max = 256)
    @Column(name = "ApplicationVirtualPath", length = 256)
    private String applicationVirtualPath;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "MachineName", nullable = false, length = 256)
    private String machineName;
    @Size(max = 1024)
    @Column(name = "RequestUrl", length = 1024)
    private String requestUrl;
    @Size(max = 256)
    @Column(name = "ExceptionType", length = 256)
    private String exceptionType;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Details", length = 2147483647)
    private String details;

    public DboaspnetWebEventEvents() {
    }

    public DboaspnetWebEventEvents(String eventId) {
        this.eventId = eventId;
    }

    public DboaspnetWebEventEvents(String eventId, Date eventTimeUtc, Date eventTime, String eventType, long eventSequence, long eventOccurrence, int eventCode, int eventDetailCode, String machineName) {
        this.eventId = eventId;
        this.eventTimeUtc = eventTimeUtc;
        this.eventTime = eventTime;
        this.eventType = eventType;
        this.eventSequence = eventSequence;
        this.eventOccurrence = eventOccurrence;
        this.eventCode = eventCode;
        this.eventDetailCode = eventDetailCode;
        this.machineName = machineName;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Date getEventTimeUtc() {
        return eventTimeUtc;
    }

    public void setEventTimeUtc(Date eventTimeUtc) {
        this.eventTimeUtc = eventTimeUtc;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public long getEventSequence() {
        return eventSequence;
    }

    public void setEventSequence(long eventSequence) {
        this.eventSequence = eventSequence;
    }

    public long getEventOccurrence() {
        return eventOccurrence;
    }

    public void setEventOccurrence(long eventOccurrence) {
        this.eventOccurrence = eventOccurrence;
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
        this.eventCode = eventCode;
    }

    public int getEventDetailCode() {
        return eventDetailCode;
    }

    public void setEventDetailCode(int eventDetailCode) {
        this.eventDetailCode = eventDetailCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApplicationPath() {
        return applicationPath;
    }

    public void setApplicationPath(String applicationPath) {
        this.applicationPath = applicationPath;
    }

    public String getApplicationVirtualPath() {
        return applicationVirtualPath;
    }

    public void setApplicationVirtualPath(String applicationVirtualPath) {
        this.applicationVirtualPath = applicationVirtualPath;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DboaspnetWebEventEvents)) {
            return false;
        }
        DboaspnetWebEventEvents other = (DboaspnetWebEventEvents) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acesse.vcashadmin.db.entity.DboaspnetWebEventEvents[ eventId=" + eventId + " ]";
    }

}
