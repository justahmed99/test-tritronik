package com.example.demo.repository;

import com.example.demo.pojo.NRCluster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NRClusterRepository extends JpaRepository<NRCluster, Integer> {
    @Override
    Optional<NRCluster> findById(Integer integer);
}
