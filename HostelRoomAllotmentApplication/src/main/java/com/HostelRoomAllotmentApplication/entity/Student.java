package com.HostelRoomAllotmentApplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String gender;

    private int year;

    private String course;
}