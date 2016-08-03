package com.acesse.vcashadmin.service.dto;

import java.math.BigInteger;

public class FacsimileAccountSearchDto extends FacsimileSearchDto {
    private BigInteger transactionCount;

    public FacsimileAccountSearchDto() {
    }

    public FacsimileAccountSearchDto(Integer affId, Integer acctId, String acctName, String firstName, String lastName, String secureInfo, String acctStatusDate, Integer groupId, BigInteger transactionCount, String email) {
        super(affId, acctId, acctName, firstName, lastName, secureInfo, acctStatusDate, groupId, email);
        this.transactionCount = transactionCount;
    }

    public BigInteger getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(BigInteger transactionCount) {
        this.transactionCount = transactionCount;
    }
}
