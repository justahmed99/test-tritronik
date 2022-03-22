package com.example.demo.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user_nr_cluster", schema = "public")
public class UserNRCluster {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "nr_cluster_id")
    private NRCluster nrCluster;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "role")
    private String role;
}
