package com.honeycomb.Service;


import com.honeycomb.DTO.UserDTO;

public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO getUserById(String userId);
    UserDTO getUserByEmail(String email);
    UserDTO update(UserDTO userDTO, String userId);
    void delete(String userId);
}
