package com.honeycomb.Service;

import com.honeycomb.DTO.PasswordResetDTO;
import com.honeycomb.Responses.ApiResponse;
import com.honeycomb.Responses.PasswordResponse;

import java.time.Instant;

public interface PasswordResetService {

    ApiResponse requestPasswordReset(String email);

    ApiResponse completePasswordReset(String token, PasswordResponse passwordResponse);
}
