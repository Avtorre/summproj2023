package com.sumprjct.hotel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumprjct.hotel.responseRequests.RoomRequest;
import com.sumprjct.hotel.responseRequests.RoomResponse;
import com.sumprjct.hotel.responseRequests.RoomResponseFull;
import com.sumprjct.hotel.service.RoomService;

import jakarta.validation.Valid;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/rooms")
@Validated
public class RoomController {

    private RoomService roomService;

    @GetMapping()
    public List<RoomResponse> getRooms() {
        return roomService.getRooms().stream().map(RoomResponse::new).toList();
    }

    @GetMapping("/full")
    public List<RoomResponseFull> getMethodName() {
        return roomService.getRooms().stream().map(RoomResponseFull::new).toList();
    }

    @PostMapping()
    public Long addRoom(@Valid @RequestBody RoomRequest room) {
        return roomService.addRoom(room);
    }
    

}
