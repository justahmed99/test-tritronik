package com.example.demo.model.request;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class UsersRequest {
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
}
