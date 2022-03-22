package com.example.demo.service;

import com.example.demo.model.request.UserNRClusterRequest;
import com.example.demo.model.response.DataResponse;
import com.example.demo.pojo.NRCluster;
import com.example.demo.pojo.UserNRCluster;
import com.example.demo.pojo.Users;
import com.example.demo.repository.NRClusterRepository;
import com.example.demo.repository.UserNRClusterRepository;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserNRClusterService {
    @Autowired
    private NRClusterRepository nrClusterRepos;

    @Autowired
    private UsersRepository usersRepo;

    @Autowired
    private UserNRClusterRepository userNRClusterRepos;

    public DataResponse createUpdateUserNRCluster(UserNRClusterRequest request) {
        try {
            UserNRCluster userNRCluster = new UserNRCluster();
            if (request.getId() != null) {
                userNRCluster = userNRClusterRepos.findById(request.getId()).get();
            }

            if (request.getUserId() == null) {
                return new DataResponse("User ID cannot be null", null);
            }

            if (request.getNrClusterId() == null) {
                return new DataResponse("NR Cluster ID cannot be null", null);
            }

            Users user = usersRepo.findById(request.getUserId()).get();
            NRCluster nrCluster = nrClusterRepos.findById(request.getNrClusterId()).get();

            userNRCluster.setUser(user);
            userNRCluster.setNrCluster(nrCluster);
            userNRCluster.setRole(request.getRole());

            userNRClusterRepos.save(userNRCluster);

            return new DataResponse("Create or Update", userNRCluster);
        } catch (Exception e) {
            return new DataResponse(e.getMessage(), null);
        }
    }

    public DataResponse getUserNRCluster(Integer id) {
        try {
            UserNRCluster userNRCluster = userNRClusterRepos.findById(id).get();
            return new DataResponse("Get", userNRCluster);
        } catch (Exception e) {
            return new DataResponse(e.getMessage(), null);
        }
    }

    public DataResponse deleteUserNRCluster(Integer id) {
        try {
            UserNRCluster userNRCluster = userNRClusterRepos.findById(id).get();
            userNRClusterRepos.delete(userNRCluster);
            return new DataResponse("Delete", null);
        } catch (Exception e) {
            return new DataResponse(e.getMessage(), null);
        }
    }
}
