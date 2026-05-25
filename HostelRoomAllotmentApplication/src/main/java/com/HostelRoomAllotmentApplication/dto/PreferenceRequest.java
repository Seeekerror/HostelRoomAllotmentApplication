package com.HostelRoomAllotmentApplication.dto;

import lombok.Data;

@Data
public class PreferenceRequest {

    private Long studentId;

    private int preferredFloor;

    private String preferredRoomType;

    private int preferredCapacity;
}