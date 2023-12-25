package com.honeycomb.Service.Impl;

import com.honeycomb.DTO.CartDTO;
import com.honeycomb.Entity.Cart;
import com.honeycomb.Repository.CartRepo;
import com.honeycomb.Service.CartService;
import com.honeycomb.Util.UlidGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private UlidGenerator ulidGenerator;

    @Override
    public CartDTO createCart() {
        Cart cart = new Cart();
        cart.setId(ulidGenerator.generateUlid());
        cartRepo.save(cart);

        return this.modelMapper.map(cart, CartDTO.class);
    }
}
