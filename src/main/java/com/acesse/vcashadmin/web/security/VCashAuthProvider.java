package com.acesse.vcashadmin.web.security;

import com.acesse.vcashadmin.db.repository.MembershipRepository;
import com.acesse.vcashadmin.util.HashUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
public class VCashAuthProvider implements AuthenticationProvider {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private MembershipRepository membershipRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.info("Starting auth procedure");
        String user = authentication.getName();
        if (authentication.getCredentials() == null)
            throw new UsernameNotFoundException("User " + user + " provided no password");
        String password = authentication.getCredentials().toString();
        AuthUser authUser = (AuthUser) userDetailsService.loadUserByUsername(user);
        try {
            boolean passwordCorrect = authUser.getPassword().equals(HashUtil.generateHash(password, authUser.getMembership().getPasswordSalt()));
            if (passwordCorrect) {
                authUser.getMembership().setLastLoginDate(new Date());
                authUser.getMembership().setFailedPasswordAttemptCount(0);
                membershipRepository.save(authUser.getMembership());
                return new UsernamePasswordAuthenticationToken(authUser, password, Collections.singletonList((GrantedAuthority) () -> "ADMIN"));
            } else {
                authUser.getMembership().setFailedPasswordAttemptCount(authUser.getMembership().getFailedPasswordAnswerAttemptCount() + 1);
                membershipRepository.save(authUser.getMembership());
                throw new UsernameNotFoundException("User " + user + " not found");
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("User " + user + " password hash failure", e);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        logger.info("Request for support " + authentication.getCanonicalName() + " auth class");
        return true;
    }
}
