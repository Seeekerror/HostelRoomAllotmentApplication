package com.HostelRoomAllotmentApplication.controller;

import com.HostelRoomAllotmentApplication.dto.LoginRequest;
import com.HostelRoomAllotmentApplication.dto.RegisterRequest;
import com.HostelRoomAllotmentApplication.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private AuthService authService;



    // REGISTER API
    @PostMapping("/register")

    public String register(
            @RequestBody RegisterRequest request
    ) {

        return authService.register(request);
    }



    // LOGIN API
    @PostMapping("/login")

    public String login(
            @RequestBody LoginRequest request
    ) {

        return authService.login(request);
    }
}