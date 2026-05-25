package com.HostelRoomAllotmentApplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "preference")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private int preferredFloor;

    private String preferredRoomType;

    private int preferredCapacity;
}