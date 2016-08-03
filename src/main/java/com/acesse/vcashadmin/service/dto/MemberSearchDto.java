package com.acesse.vcashadmin.service.dto;

import java.io.Serializable;

public class MemberSearchDto implements Serializable {
    public String email, firstName, lastNAme, affiliateId, status, vcashNumber, exactSearch;

    public MemberSearchDto() {
    }

    public MemberSearchDto(String email, String firstName, String lastNAme, String affiliateId, String status, String vcashNumber, String exactSearch) {
        this.email = email;
        this.firstName = firstName;
        this.lastNAme = lastNAme;
        this.affiliateId = affiliateId;
        this.status = status;
        this.vcashNumber = vcashNumber;
        this.exactSearch = exactSearch;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNAme() {
        return lastNAme;
    }

    public void setLastNAme(String lastNAme) {
        this.lastNAme = lastNAme;
    }

    public String getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(String affiliateId) {
        this.affiliateId = affiliateId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVcashNumber() {
        return vcashNumber;
    }

    public void setVcashNumber(String vcashNumber) {
        this.vcashNumber = vcashNumber;
    }

    public String getExactSearch() {
        return exactSearch;
    }

    public void setExactSearch(String exactSearch) {
        this.exactSearch = exactSearch;
    }
}
