package com.acesse.vcashadmin.web.security;

import com.acesse.vcashadmin.db.entity.DboaspnetMembership;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by Vadim_Korostelev on 6/6/2016.
 */
public class AuthUser extends User {
    private DboaspnetMembership membership;

    public AuthUser(String userName, DboaspnetMembership membership) {
        super(userName, membership.getPassword(), AuthorityUtils.createAuthorityList("ADMIN"));
        this.membership = membership;
    }

    public DboaspnetMembership getMembership() {
        return membership;
    }

    public String getId() {
        return membership.getUserId();
    }
}
