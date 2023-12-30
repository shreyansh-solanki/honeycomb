package com.honeycomb.Repository;

import com.honeycomb.Entity.PasswordReset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetRepo extends JpaRepository<PasswordReset, String> {
    Optional<PasswordReset> findByResetToken(String token);
//    Optional<PasswordReset> findByResetToken();
}
