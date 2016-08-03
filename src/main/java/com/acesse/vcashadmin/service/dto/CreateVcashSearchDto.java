package com.acesse.vcashadmin.service.dto;

public class CreateVcashSearchDto extends FacsimileSearchDto {
    private Integer statusId;

    public CreateVcashSearchDto() {
    }

    public CreateVcashSearchDto(Integer affId, Integer acctId, String firstName, String lastName, String email, Integer statusId) {
        super(affId, acctId, null, firstName, lastName, null, null, null, email);
        this.statusId = statusId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}
