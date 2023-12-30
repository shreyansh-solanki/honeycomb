package com.honeycomb.Service.Impl;

import com.honeycomb.DTO.AuthRequest;
import com.honeycomb.DTO.AuthorityDTO;
import com.honeycomb.DTO.UserDTO;
import com.honeycomb.Entity.Authority;
import com.honeycomb.Entity.User;
import com.honeycomb.Enums.Authorities;
import com.honeycomb.Exceptions.ApiException;
import com.honeycomb.Repository.AuthorityRepo;
import com.honeycomb.Responses.AuthResponse;
import com.honeycomb.Service.AuthorityService;
import com.honeycomb.Service.UserService;
import com.honeycomb.Util.JwtUtils;
import com.honeycomb.Util.UlidGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthorityRepo authorityRepo;

    @Autowired
    private UlidGenerator ulidGenerator;

    @Override
    public void createAuthority(User user) {
        Authority authority = new Authority();
        authority.setId(ulidGenerator.generateUlid());
        authority.setUser(user);
        authority.setAuthority(Authorities.ROLE_USER.name());

        authorityRepo.save(authority);
    }
}
