package com.kdaquila.site;

import com.kdaquila.site.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>(1);
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !user.getAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.getAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.getCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled();
    }
}
