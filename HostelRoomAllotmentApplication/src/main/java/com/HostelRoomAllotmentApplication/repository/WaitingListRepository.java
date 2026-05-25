package com.HostelRoomAllotmentApplication.repository;

import com.HostelRoomAllotmentApplication.entity.WaitingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaitingListRepository extends JpaRepository<WaitingList, Long> {
}