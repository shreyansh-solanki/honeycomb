package com.honeycomb.Repository;

import com.honeycomb.Entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepo extends JpaRepository<Wishlist, String> {
}
