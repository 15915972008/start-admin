package com.start.startsecurity.core;

import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class DaoAuthenticationProvider {

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new AccountNotExistsException("user.error.login.username-or-password.error");
        }
        if (!user.isEnabled()) {
            throw new DisabledException("user.error.login.user.disabled");
        }
        return detailsService.loadUserByUsername(username);
    }
}
