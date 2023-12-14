package com.honeycomb.Service;


import com.honeycomb.DTO.UserDTO;

public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO update(UserDTO userDTO);
    UserDTO delete(UserDTO userDTO);
}
