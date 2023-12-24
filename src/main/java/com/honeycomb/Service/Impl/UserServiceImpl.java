package com.honeycomb.Service.Impl;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import com.honeycomb.DTO.UserDTO;
import com.honeycomb.Entity.Cart;
import com.honeycomb.Entity.User;
import com.honeycomb.Entity.Wishlist;
import com.honeycomb.Exceptions.ResourceNotFoundException;
import com.honeycomb.Repository.CartRepo;
import com.honeycomb.Repository.UserRepo;
import com.honeycomb.Repository.WishlistRepo;
import com.honeycomb.Service.UserService;
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
    private CartRepo cartRepo;

    @Autowired
    private WishlistRepo wishlistRepo;

    @Override
    public UserDTO register(UserDTO userDTO) {
        User user = this.modelMapper.map(userDTO, User.class);
        Ulid ulid1 = UlidCreator.getUlid();
        System.out.println(ulid1);

        Cart cart = new Cart();
        cart.setId(ulid1.toString());
//        cart.setUser(user);
        cartRepo.save(cart);

        user.setCart(cart);

        this.userRepo.save(user);


//        Ulid ulid2 = UlidCreator.getUlid();
//        Wishlist wishlist = new Wishlist();
//        wishlist.setId(ulid2.toString());
//        wishlist.setUser(user);
//        wishlistRepo.save(wishlist);

        return this.modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on server with given id : " + userId));
        return this.modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    @Override
    public void delete(Long userId) {
        if(this.userRepo.findById(userId).isEmpty()) {
            throw new ResourceNotFoundException("User not found on server with given id : " + userId);
        }

        this.userRepo.deleteById(userId);
    }

}
