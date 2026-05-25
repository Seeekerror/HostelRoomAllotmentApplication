package com.HostelRoomAllotmentApplication.repository;

import com.HostelRoomAllotmentApplication.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    // EXACT MATCH
    List<Room> findByFloorNumberAndRoomTypeAndCapacityAndGenderAndAllowedYearAndAllowedCourse(

            int floorNumber,

            String roomType,

            int capacity,

            String gender,

            int allowedYear,

            String allowedCourse
    );



    // FALLBACK MATCH
    List<Room> findByRoomTypeAndCapacityAndGenderAndAllowedYearAndAllowedCourse(

            String roomType,

            int capacity,

            String gender,

            int allowedYear,

            String allowedCourse
    );



    // RANDOM ROOM
    List<Room> findByGender(String gender);
}