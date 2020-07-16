package com.start.startsecurity.core;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AbstractUserDetailsAuthenticationProvider {
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (user == null) {
            cacheWasUsed = false;
            try {
                user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
            }catch (Exception e){

            }
        return createSuccessAuthentication(principalToReturn, authentication, user);
        }
}
