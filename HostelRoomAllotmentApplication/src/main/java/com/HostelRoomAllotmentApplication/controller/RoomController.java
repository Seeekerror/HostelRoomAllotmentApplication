package com.HostelRoomAllotmentApplication.controller;

import com.HostelRoomAllotmentApplication.entity.Room;
import com.HostelRoomAllotmentApplication.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")

public class RoomController {

    @Autowired
    private RoomService roomService;



    // GET ALL ROOMS
    @GetMapping

    public List<Room> getAllRooms() {

        return roomService.getAllRooms();
    }



    // GET ROOM BY ID
    @GetMapping("/{id}")

    public Room getRoomById(
            @PathVariable Long id
    ) {

        return roomService.getRoomById(id);
    }



    // ADD ROOM
    @PostMapping

    public Room addRoom(
            @RequestBody Room room
    ) {

        return roomService.addRoom(room);
    }
}