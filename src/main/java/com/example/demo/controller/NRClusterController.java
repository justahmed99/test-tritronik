package com.example.demo.controller;

import com.example.demo.model.request.NRClusterRequest;
import com.example.demo.model.response.DataResponse;
import com.example.demo.service.NRClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nr-cluster")
public class NRClusterController {
    @Autowired
    private NRClusterService nrClusterService;

    @PostMapping("")
    public DataResponse createNRCluster(@RequestBody NRClusterRequest request) {
        return nrClusterService.createUpdateNrCluster(request);
    }

    @PutMapping("")
    public DataResponse updateNRCluster(@RequestBody NRClusterRequest request) {
        return nrClusterService.createUpdateNrCluster(request);
    }

    @GetMapping("")
    public DataResponse getNRCluster(@RequestParam(name = "id", required = true) Integer id) {
        return nrClusterService.getNrCluster(id);
    }

    @DeleteMapping("")
    public DataResponse deleteNRCluster(@RequestParam(name = "id", required = true) Integer id) {
        return nrClusterService.deleteNrCluster(id);
    }
}
