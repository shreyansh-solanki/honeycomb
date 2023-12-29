package com.honeycomb.Service.Impl;

import com.honeycomb.DTO.PasswordResetDTO;
import com.honeycomb.DTO.UserDTO;
import com.honeycomb.Entity.PasswordReset;
import com.honeycomb.Entity.User;
import com.honeycomb.Exceptions.ApiException;
import com.honeycomb.Exceptions.ExceptionConstants;
import com.honeycomb.Exceptions.ResourceNotFoundException;
import com.honeycomb.Repository.PasswordResetRepo;
import com.honeycomb.Responses.ApiConstants;
import com.honeycomb.Responses.ApiResponse;
import com.honeycomb.Responses.PasswordResponse;
import com.honeycomb.Service.PasswordResetService;
import com.honeycomb.Service.UserService;
import com.honeycomb.Util.UlidGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class PasswordResetServiceImpl implements PasswordResetService {

    @Autowired
    private UlidGenerator ulidGenerator;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordResetRepo passwordResetRepo;

    @Autowired
    private UserService userService;

    @Override
    public ApiResponse requestPasswordReset(String email) {
        UserDTO userDTO = this.userService.getUserByEmail(email);

        if(userDTO.getPasswordReset() != null) {
            checkResetTokenRequestTime(userDTO.getPasswordReset().getRequestTime());
        }

        PasswordReset passwordReset = new PasswordReset();
        passwordReset.setId(ulidGenerator.generateUlid());
        passwordReset.setResetToken(UUID.randomUUID().toString());
        passwordReset.setRequestTime(Instant.now());

        this.passwordResetRepo.save(passwordReset);

        userDTO.setPasswordReset(this.modelMapper.map(passwordReset, PasswordResetDTO.class));

        this.userService.save(userDTO);

        return new ApiResponse(ApiConstants.PASSWORD_RESET, ApiConstants.API_SUCCESS_TRUE, HttpStatus.OK);
    }

    @Override
    public ApiResponse completePasswordReset(String token, PasswordResponse passwordResponse) {
        PasswordReset passwordReset = this.passwordResetRepo.findByResetToken(token).orElseThrow(() -> new ResourceNotFoundException(ApiConstants.INVALID_TOKEN));

        checkResetTokenValidity(passwordReset.getRequestTime());

        if (passwordReset.getUser().getId() != null) {
            this.userService.changePassword(passwordReset.getUser().getId(), passwordResponse.getNewPassword());
        }

        this.passwordResetRepo.deleteById(passwordReset.getId());

        return new ApiResponse(ApiConstants.PASSWORD_RESET_SUCCESS, ApiConstants.API_SUCCESS_TRUE, HttpStatus.OK);
    }


    public void checkResetTokenRequestTime(Instant tokenTime) {
        if(tokenTime.isBefore(Instant.now().plusSeconds(24 * 60 * 60 * 60))) {
            throw new ApiException(ExceptionConstants.TOKEN_BEFORE_TIME + " Token initiated at : " + tokenTime);
        }
    }

    public void checkResetTokenValidity(Instant tokenValidity) {
        if(tokenValidity.isAfter(Instant.now().plusSeconds(24 * 60 * 60 * 60))) {
            throw new ApiException(ExceptionConstants.TOKEN_EXPIRED);
        }
    }
}
