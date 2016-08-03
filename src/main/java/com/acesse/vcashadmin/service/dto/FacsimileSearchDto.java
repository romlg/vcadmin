package com.acesse.vcashadmin.service.dto;

public class FacsimileSearchDto {
    private Integer affId, acctId;
    private String acctName, firstName, lastName;
    private String secureInfo;
    private String acctStatusDate;
    private Integer groupId;
    private String email;

    public FacsimileSearchDto() {
    }

    public FacsimileSearchDto(Integer affId, Integer acctId, String acctName, String firstName, String lastName, String secureInfo, String acctStatusDate, Integer groupId, String email) {
        this.affId = affId;
        this.acctId = acctId;
        this.acctName = acctName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secureInfo = secureInfo;
        this.acctStatusDate = acctStatusDate;
        this.groupId = groupId;
        this.email = email;
    }

    public Integer getAffId() {
        return affId;
    }

    public void setAffId(Integer affId) {
        this.affId = affId;
    }

    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecureInfo() {
        return secureInfo;
    }

    public void setSecureInfo(String secureInfo) {
        this.secureInfo = secureInfo;
    }

    public String getAcctStatusDate() {
        return acctStatusDate;
    }

    public void setAcctStatusDate(String acctStatusDate) {
        this.acctStatusDate = acctStatusDate;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
