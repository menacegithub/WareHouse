package org.example.extratomeee.controller;

import org.example.extratomeee.dto.UserDto;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.model.User;
import org.example.extratomeee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }
    @GetMapping
    public User getUserbyId(Integer id) {
        return userService.getUserById(id);
    }
    @PostMapping
    public Result createUser(@RequestBody UserDto userDto) {
        Result result = userService.createnewUser(userDto);
        return result;
    }
    @PutMapping
    public Result updateUser(@PathVariable Integer id,@RequestBody UserDto userDto) {
        Result result = userService.updateUser(userDto, id);
        return result;
    }
    @DeleteMapping
    public Result deleteUser(@PathVariable Integer id) {
        Result result = userService.deleteUser(id);
        return result;
    }





}
