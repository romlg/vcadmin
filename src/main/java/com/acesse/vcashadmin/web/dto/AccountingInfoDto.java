package com.acesse.vcashadmin.web.dto;

/**
 * Date: 29.05.16
 * Time: 14:23
 */
public class AccountingInfoDto {
    private Integer affId, acctId;
    private String acctName, amount;
    private String color;

    public AccountingInfoDto() {
    }

    public AccountingInfoDto(Integer affId, Integer acctId, String amount, String acctName, String color) {
        this.affId = affId;
        this.acctId = acctId;
        this.amount = amount;
        this.acctName = acctName;
        this.color = color;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
