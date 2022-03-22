package com.example.demo.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNRClusterRequest {
    private Integer id;
    private Integer nrClusterId;
    private Integer userId;
    private String role;
}
