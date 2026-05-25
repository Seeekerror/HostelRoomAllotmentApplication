package com.HostelRoomAllotmentApplication.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String name;

    private String email;

    private String password;

    private String gender;

    private int year;

    private String course;
}