package com.example.demo.controller;

import com.example.demo.model.request.UsersRequest;
import com.example.demo.model.response.DataResponse;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("")
    public DataResponse createUsers(@RequestBody UsersRequest request) {
        return usersService.createUpdateUser(request);
    }

    @PutMapping("")
    public DataResponse updateUsers(@RequestBody UsersRequest request) {
        return usersService.createUpdateUser(request);
    }

    @GetMapping("")
    public DataResponse getUsers(@RequestParam(name = "id", required = true) Integer id) {
        return usersService.getUser(id);
    }

    @DeleteMapping("")
    public DataResponse deleteUsers(@RequestParam(name = "id", required = true) Integer id) {
        return usersService.deleteUser(id);
    }
}
