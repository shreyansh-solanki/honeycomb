package com.honeycomb.Repository;

import com.honeycomb.Entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepo extends JpaRepository<Authority, String> {
}
