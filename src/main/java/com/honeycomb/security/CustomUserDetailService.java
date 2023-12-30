package com.honeycomb.security;

import com.honeycomb.Exceptions.ResourceNotFoundException;
import com.honeycomb.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return this.userRepo.findById(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with given id " + username)
                );
    }
}
