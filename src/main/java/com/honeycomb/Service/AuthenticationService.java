package com.honeycomb.Service;

import com.honeycomb.DTO.AuthRequest;
import com.honeycomb.Responses.AuthResponse;

public interface AuthenticationService {

    AuthResponse login(AuthRequest authRequest);
}
