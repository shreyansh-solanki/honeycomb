package com.honeycomb.Service;


import com.honeycomb.DTO.UserDTO;

public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO getUserById(Long userId);
    UserDTO update(UserDTO userDTO);
    void delete(Long userId);
}
