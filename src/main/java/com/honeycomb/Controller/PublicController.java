package com.honeycomb.Controller;

import com.honeycomb.Responses.ApiResponse;
import com.honeycomb.Responses.PasswordResponse;
import com.honeycomb.Service.PasswordResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PublicController {

    @Autowired
    private PasswordResetService passwordResetService;

    @PostMapping("/password-reset/request")
    public ResponseEntity<ApiResponse> requestPasswordReset(@RequestParam(value = "email", required = true) String email) {
        return new ResponseEntity<>(this.passwordResetService.requestPasswordReset(email), HttpStatus.OK);
    }

    @PostMapping("/password-reset/complete")
    public ResponseEntity<ApiResponse> completePasswordReset(@RequestParam(value = "token", required = true) String token, @RequestBody PasswordResponse passwordResponse) {
        return new ResponseEntity<>(this.passwordResetService.completePasswordReset(token, passwordResponse), HttpStatus.OK);
    }
}
