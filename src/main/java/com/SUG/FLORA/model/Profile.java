package com.SUG.FLORA.model;

import org.springframework.security.core.GrantedAuthority;

public class Profile implements GrantedAuthority{

    @Override
    public String getAuthority() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getAuthority'");
    }
    
}
