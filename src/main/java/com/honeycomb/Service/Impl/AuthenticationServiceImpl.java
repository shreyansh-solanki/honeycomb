package com.honeycomb.Service.Impl;

import com.honeycomb.DTO.AuthRequest;
import com.honeycomb.DTO.UserDTO;
import com.honeycomb.Exceptions.ApiException;
import com.honeycomb.Exceptions.ExceptionConstants;
import com.honeycomb.Responses.AuthResponse;
import com.honeycomb.Service.AuthenticationService;
import com.honeycomb.Service.UserService;
import com.honeycomb.Util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    public AuthResponse login(AuthRequest authRequest) {
        UserDTO userDTO = this.userService.getUserByEmail(authRequest.getEmail());

        this.authenticate(userDTO.getId(), authRequest.getPassword());

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userDTO.getId());

        String token = this.jwtUtils.generateToken(userDetails, authRequest.getEmail());
        String refreshToken = this.jwtUtils.generateRefreshToken(userDetails, authRequest.getEmail());

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        authResponse.setTokenType("Bearer");
        authResponse.setRefreshToken(refreshToken);

        return authResponse;
    }

    private void authenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);

        try {
            this.authenticationManager.authenticate(authenticationToken);
        } catch (AuthenticationException ex) {
            throw new ApiException(ExceptionConstants.INVALID_EMAIL_PASSWORD);
        }
    }
}
