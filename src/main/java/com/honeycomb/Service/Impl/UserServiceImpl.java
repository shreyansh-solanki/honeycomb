package com.honeycomb.Service.Impl;

import com.honeycomb.DTO.UserDTO;
import com.honeycomb.Entity.Cart;
import com.honeycomb.Entity.User;
import com.honeycomb.Entity.Wishlist;
import com.honeycomb.Exceptions.ResourceNotFoundException;
import com.honeycomb.Repository.UserRepo;
import com.honeycomb.Service.AuthorityService;
import com.honeycomb.Service.CartService;
import com.honeycomb.Service.UserService;
import com.honeycomb.Service.WishlistService;
import com.honeycomb.Util.CustomPasswordEncoder;
import com.honeycomb.Util.UlidGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CartService cart;

    @Autowired
    private WishlistService wishlist;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private CustomPasswordEncoder customPasswordEncoder;

    @Autowired
    private UlidGenerator ulidGenerator;

    @Override
    public UserDTO register(UserDTO userDTO) {
        User user = this.modelMapper.map(userDTO, User.class);
        user.setId(this.ulidGenerator.generateUlid());
        user.setPassword(this.customPasswordEncoder.getPasswordEncoder().encode(userDTO.getPassword()));
        user.setCart(this.modelMapper.map(cart.createCart(), Cart.class));
        user.setWishlist(this.modelMapper.map(wishlist.createWishlist(), Wishlist.class));

        this.userRepo.save(user);

        this.authorityService.createAuthority(this.userRepo.findById(user.getId()).orElseThrow());

        return this.modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(String userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on server with given id : " + userId));
        return this.modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = this.userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found on server with given email : " + email));
        return this.modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    @Override
    public void delete(String userId) {
        if(this.userRepo.findById(userId).isEmpty()) {
            throw new ResourceNotFoundException("User not found on server with given id : " + userId);
        }

        this.userRepo.deleteById(userId);
    }

}
