package com.acesse.vcashadmin.web.security;

import com.acesse.vcashadmin.db.entity.DboaspnetMembership;
import com.acesse.vcashadmin.db.entity.DboaspnetUsers;
import com.acesse.vcashadmin.db.repository.MembershipRepository;
import com.acesse.vcashadmin.db.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class VcashAdminUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final MembershipRepository membershipRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public VcashAdminUserDetailsService(UsersRepository usersRepository, MembershipRepository membershipRepository) {
        this.usersRepository = usersRepository;
        this.membershipRepository = membershipRepository;
    }

    @Override
    public AuthUser loadUserByUsername(String username) throws UsernameNotFoundException {
        DboaspnetUsers user = usersRepository.findByUserName(username);
        if (user == null) {
            logger.info("User " + username + " not found");
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        DboaspnetMembership membership = membershipRepository.findOne(user.getUserId());
        if (membership == null) {
            logger.info("Membership " + user.getUserId() + " not found");
            throw new UsernameNotFoundException("Membership " + user.getUserId() + " not found");
        }
        logger.info("User " + username + " is found");
        return new AuthUser(username, membership);
    }
}
