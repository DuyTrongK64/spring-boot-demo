package com.GR3.demo.controller;

import com.GR3.demo.dto.request.ApiRespose;
import com.GR3.demo.dto.request.UserCreationRequest;
import com.GR3.demo.dto.request.UserUpdateRequest;
import com.GR3.demo.entity.User;
import com.GR3.demo.service.TestService;
import com.GR3.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TestService testService;

    @PostMapping("/users")
    ApiRespose<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiRespose<User> apiRespose = new ApiRespose<>();

        apiRespose.setResult(userService.createUser(request));
        return  apiRespose;
    }

    @GetMapping("/users")
    List<User> getUsers(){return userService.getUsers();};

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User has been deleted";
    }

    @GetMapping("/test")
    void createUsers(){
        testService.performAction();
    }
}
