package com.example.demo.service;

import com.example.demo.model.request.NRClusterRequest;
import com.example.demo.model.response.DataResponse;
import com.example.demo.pojo.NRCluster;
import com.example.demo.repository.NRClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NRClusterService {
    @Autowired
    private NRClusterRepository nrClusterRepos;

    public DataResponse createUpdateNrCluster(NRClusterRequest request) {
        try {
            NRCluster nrCluster = new NRCluster();
            if (request.getId() != null) {
                nrCluster = nrClusterRepos.findById(request.getId()).get();
            }
            nrCluster.setName(request.getName());
            nrCluster.setAddress(request.getAddress());
            nrCluster.setCity(request.getCity());
            nrCluster.setLatitude(request.getLatitude());
            nrCluster.setLongitude(request.getLongitude());

            nrClusterRepos.save(nrCluster);
            return new DataResponse("Create or Update", nrCluster);
        } catch (Exception e) {
            return new DataResponse(e.getMessage(), null);
        }
    }

    public DataResponse getNrCluster(Integer id) {
        try {
            NRCluster nrCluster = nrCluster = nrClusterRepos.findById(id).get();
            nrClusterRepos.save(nrCluster);
            return new DataResponse("Read", nrCluster);
        } catch (Exception e) {
            return new DataResponse(e.getMessage(), null);
        }
    }

    public DataResponse deleteNrCluster(Integer id) {
        try {
            NRCluster nrCluster = nrCluster = nrClusterRepos.findById(id).get();
            nrClusterRepos.delete(nrCluster);
            return new DataResponse("Delete", null);
        } catch (Exception e) {
            return new DataResponse(e.getMessage(), null);
        }
    }
}
