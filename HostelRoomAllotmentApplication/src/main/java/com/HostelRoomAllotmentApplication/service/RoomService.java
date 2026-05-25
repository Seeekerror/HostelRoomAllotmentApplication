package com.HostelRoomAllotmentApplication.service;

import com.HostelRoomAllotmentApplication.entity.Room;
import com.HostelRoomAllotmentApplication.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;



    // GET ALL ROOMS
    public List<Room> getAllRooms() {

        return roomRepository.findAll();
    }



    // GET ROOM BY ID
    public Room getRoomById(Long id) {

        return roomRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Room Not Found"));
    }



    // ADD ROOM
    public Room addRoom(Room room) {

        return roomRepository.save(room);
    }
}