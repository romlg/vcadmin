package com.acesse.vcashadmin.service.dto;

/**
 * Created by Vadim_Korostelev on 7/4/2016.
 */
public class MemberVcashDto {
    public String memberid, vcashid;

    public MemberVcashDto() {
    }

    public MemberVcashDto(String memberid, String vcashid) {
        this.memberid = memberid;
        this.vcashid = vcashid;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getVcashid() {
        return vcashid;
    }

    public void setVcashid(String vcashid) {
        this.vcashid = vcashid;
    }
}
