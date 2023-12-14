package com.honeycomb.Repository;

import com.honeycomb.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<String, User> {
}
