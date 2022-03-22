package com.example.demo.model.request;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NRClusterRequest {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private Double latitude;
    private Double longitude;
}
