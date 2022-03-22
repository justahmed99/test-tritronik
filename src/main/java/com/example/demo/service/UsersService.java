package com.example.demo.service;

import com.example.demo.model.request.UsersRequest;
import com.example.demo.model.response.DataResponse;
import com.example.demo.pojo.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepo;

    public DataResponse createUpdateUser(UsersRequest request) {
        try {
            Users user = new Users();
            if (request.getId() != null) {
                user = usersRepo.findById(request.getId()).get();
            }
            user.setName(request.getName());
            user.setAddress(request.getAddress());
            user.setEmail(request.getEmail());
            user.setPhoneNumber(request.getPhoneNumber());
            user.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(request.getDateOfBirth()));

            usersRepo.save(user);
            return new DataResponse ("Create or Update", user);
        } catch (Exception e) {
            return new DataResponse(e.getMessage(), null);
        }
    }

    public DataResponse getUser(Integer id) {
        try {
            Users user = usersRepo.findById(id).get();
            return new DataResponse ("Read", user);
        } catch (Exception e) {
            return new DataResponse(e.getMessage(), null);
        }
    }

    public DataResponse deleteUser(Integer id) {
        try {
            Users user = usersRepo.findById(id).get();
            usersRepo.delete(user);
            return new DataResponse ("Delete", null);
        } catch (Exception e) {
            return new DataResponse(e.getMessage(), null);
        }
    }
}
