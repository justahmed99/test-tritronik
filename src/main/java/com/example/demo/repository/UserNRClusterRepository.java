package com.example.demo.repository;

import com.example.demo.pojo.UserNRCluster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserNRClusterRepository extends JpaRepository<UserNRCluster, Integer> {
    @Override
    Optional<UserNRCluster> findById(Integer integer);
}
