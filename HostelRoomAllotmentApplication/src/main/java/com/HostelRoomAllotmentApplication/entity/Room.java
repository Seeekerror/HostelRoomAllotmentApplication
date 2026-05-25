package com.HostelRoomAllotmentApplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "room")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;

    private int floorNumber;

    private String roomType;

    private int capacity;

    private int occupiedBeds;

    private String gender;

    private int allowedYear;

    private String allowedCourse;
}