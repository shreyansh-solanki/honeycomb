package com.honeycomb.Service.Impl;

import com.honeycomb.DTO.WishlistDTO;
import com.honeycomb.Entity.Wishlist;
import com.honeycomb.Repository.WishlistRepo;
import com.honeycomb.Service.WishlistService;
import com.honeycomb.Util.UlidGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UlidGenerator ulidGenerator;

    @Autowired
    private WishlistRepo wishlistRepo;

    @Override
    public WishlistDTO createWishlist() {
        Wishlist wishlist = new Wishlist();
        wishlist.setId(ulidGenerator.generateUlid());
        wishlistRepo.save(wishlist);

        return this.modelMapper.map(wishlist, WishlistDTO.class);
    }
}
