package com.HostelRoomAllotmentApplication.repository;

import com.HostelRoomAllotmentApplication.entity.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {
}