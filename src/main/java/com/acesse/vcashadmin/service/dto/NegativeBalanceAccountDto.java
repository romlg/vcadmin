package com.acesse.vcashadmin.service.dto;

public class NegativeBalanceAccountDto {
    private Integer vcashNumber, memberid;
    private String balance;

    public NegativeBalanceAccountDto(Integer vcashNumber, Integer memberid, String balance) {
        this.vcashNumber = vcashNumber;
        this.memberid = memberid;
        this.balance = balance;
    }

    public Integer getVcashNumber() {
        return vcashNumber;
    }

    public void setVcashNumber(Integer vcashNumber) {
        this.vcashNumber = vcashNumber;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
