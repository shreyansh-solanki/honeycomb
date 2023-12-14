package com.honeycomb.Service.Impl;

import com.honeycomb.DTO.UserDTO;
import com.honeycomb.Entity.User;
import com.honeycomb.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private User user;

    @Override
    public UserDTO register(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO delete(UserDTO userDTO) {
        return null;
    }
}
