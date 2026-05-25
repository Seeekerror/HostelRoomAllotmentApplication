package com.HostelRoomAllotmentApplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "waiting_list")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class WaitingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private LocalDateTime waitingTime;
}