package com.honeycomb.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/username")
    public String getUsername(){

        return null;
    }
}
