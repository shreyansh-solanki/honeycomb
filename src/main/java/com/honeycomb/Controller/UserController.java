package com.honeycomb.Controller;

import com.honeycomb.DTO.UserDTO;
import com.honeycomb.Responses.ApiResponse;
import com.honeycomb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        UserDTO createuserDTO = userService.register(userDTO);
        return new ResponseEntity<>(createuserDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(this.userService.getUserById(userId), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable("userId") String userId ,@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(this.userService.update(userDTO, userId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUserById(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(this.userService.delete(userId), HttpStatus.OK);
    }

    @GetMapping("/username")
    public String getUsername(){

        return null;
    }
}
