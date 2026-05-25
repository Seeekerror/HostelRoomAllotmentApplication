package com.HostelRoomAllotmentApplication.controller;

import com.HostelRoomAllotmentApplication.dto.PreferenceRequest;
import com.HostelRoomAllotmentApplication.service.AllocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/allocation")

public class AllocationController {

    @Autowired
    private AllocationService allocationService;



    // ROOM ALLOCATION API
    @PostMapping("/allocate")

    public String allocateRoom(
            @RequestBody PreferenceRequest request
    ) {

        return allocationService.allocateRoom(request);
    }
}