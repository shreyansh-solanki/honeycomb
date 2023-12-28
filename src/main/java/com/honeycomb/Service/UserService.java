package com.honeycomb.Service;


import com.honeycomb.DTO.UserDTO;
import com.honeycomb.Responses.ApiResponse;

public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO getUserById(String userId);
    UserDTO getUserByEmail(String email);
    UserDTO update(UserDTO userDTO, String userId);
    ApiResponse delete(String userId);
}
