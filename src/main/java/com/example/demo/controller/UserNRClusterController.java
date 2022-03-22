package com.example.demo.controller;

import com.example.demo.model.request.UserNRClusterRequest;
import com.example.demo.model.response.DataResponse;
import com.example.demo.service.UserNRClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-nr-cluster")
public class UserNRClusterController {
    @Autowired
    private UserNRClusterService userNRClusterService;

    @PostMapping("")
    public DataResponse createUserNRCluster(@RequestBody UserNRClusterRequest request) {
        return userNRClusterService.createUpdateUserNRCluster(request);
    }

    @PutMapping("")
    public DataResponse updateUserNRCluster(@RequestBody UserNRClusterRequest request) {
        return userNRClusterService.createUpdateUserNRCluster(request);
    }

    @GetMapping("")
    public DataResponse getUserNRCluster(@RequestParam(name = "id", required = true) Integer id) {
        return userNRClusterService.getUserNRCluster(id);
    }

    @DeleteMapping("")
    public DataResponse deleteUserNRCluster(@RequestParam(name = "id", required = true) Integer id) {
        return userNRClusterService.deleteUserNRCluster(id);
    }
}
