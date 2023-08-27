package com.sumprjct.hotel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumprjct.hotel.responseRequests.RoomResponse;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/rooms")
public class RoomController {

    @GetMapping()
    public List<RoomResponse> getRooms() {
        return 
    }

}
