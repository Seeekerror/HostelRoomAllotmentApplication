package com.HostelRoomAllotmentApplication.service;

import com.HostelRoomAllotmentApplication.dto.PreferenceRequest;
import com.HostelRoomAllotmentApplication.entity.Allocation;
import com.HostelRoomAllotmentApplication.entity.Room;
import com.HostelRoomAllotmentApplication.entity.Student;
import com.HostelRoomAllotmentApplication.entity.WaitingList;
import com.HostelRoomAllotmentApplication.repository.AllocationRepository;
import com.HostelRoomAllotmentApplication.repository.RoomRepository;
import com.HostelRoomAllotmentApplication.repository.StudentRepository;
import com.HostelRoomAllotmentApplication.repository.WaitingListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AllocationService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private AllocationRepository allocationRepository;

    @Autowired
    private WaitingListRepository waitingListRepository;



    public String allocateRoom(PreferenceRequest request) {

        // FETCH STUDENT
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() ->
                        new RuntimeException("Student Not Found"));



        // EXACT ROOM SEARCH
        List<Room> exactRooms =

                roomRepository
                        .findByFloorNumberAndRoomTypeAndCapacityAndGenderAndAllowedYearAndAllowedCourse(

                                request.getPreferredFloor(),

                                request.getPreferredRoomType(),

                                request.getPreferredCapacity(),

                                student.getGender(),

                                student.getYear(),

                                student.getCourse()
                        );



        // CHECK EXACT ROOM AVAILABILITY
        for (Room room : exactRooms) {

            if (room.getOccupiedBeds() < room.getCapacity()) {

                // UPDATE OCCUPIED BEDS
                room.setOccupiedBeds(
                        room.getOccupiedBeds() + 1
                );

                roomRepository.save(room);



                // SAVE ALLOCATION
                Allocation allocation = new Allocation();

                allocation.setStudent(student);

                allocation.setRoom(room);

                allocation.setAllocationDate(
                        LocalDateTime.now()
                );

                allocationRepository.save(allocation);



                return "Room Allocated Successfully : "
                        + room.getRoomNumber();
            }
        }


        List<Room> similarRooms =

                roomRepository
                        .findByRoomTypeAndCapacityAndGenderAndAllowedYearAndAllowedCourse(

                                request.getPreferredRoomType(),

                                request.getPreferredCapacity(),

                                student.getGender(),

                                student.getYear(),

                                student.getCourse()
                        );



        // CHECK FALLBACK ROOM
        for (Room room : similarRooms) {

            if (room.getOccupiedBeds() < room.getCapacity()) {

                // UPDATE OCCUPIED BEDS
                room.setOccupiedBeds(
                        room.getOccupiedBeds() + 1
                );

                roomRepository.save(room);



                // SAVE ALLOCATION
                Allocation allocation = new Allocation();

                allocation.setStudent(student);

                allocation.setRoom(room);

                allocation.setAllocationDate(
                        LocalDateTime.now()
                );

                allocationRepository.save(allocation);



                return "Preferred Floor Full. "
                        + "Allocated Room On Floor : "
                        + room.getFloorNumber();
            }
        }



        // RANDOM ROOM SEARCH

        List<Room> randomRooms =
                roomRepository.findByGender(
                        student.getGender()
                );



        for (Room room : randomRooms) {

            if (room.getOccupiedBeds() < room.getCapacity()) {

                room.setOccupiedBeds(
                        room.getOccupiedBeds() + 1
                );

                roomRepository.save(room);



                Allocation allocation =
                        new Allocation();

                allocation.setStudent(student);

                allocation.setRoom(room);

                allocation.setAllocationDate(
                        LocalDateTime.now()
                );

                allocationRepository.save(allocation);



                return "Preferred Room Not Available. "
                        + "Random Room Allocated : "
                        + room.getRoomNumber();
            }
        }



// WAITING LIST

        WaitingList waitingList = new WaitingList();

        waitingList.setStudent(student);

        waitingList.setWaitingTime(
                LocalDateTime.now()
        );

        waitingListRepository.save(waitingList);



        return "No Rooms Available. Added To Waiting List";
    }
}