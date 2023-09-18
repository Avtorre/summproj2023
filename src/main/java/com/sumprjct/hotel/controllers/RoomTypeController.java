package com.sumprjct.hotel.controllers;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.sumprjct.hotel.responseRequests.RoomTypeRequest;
import com.sumprjct.hotel.responseRequests.RoomTypeResponse;
import com.sumprjct.hotel.service.RoomTypeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/choices")
@Validated
public class RoomTypeController {
    
    private RoomTypeService roomTypeService;

    @GetMapping()
    public List<RoomTypeResponse> getRoomTypes() {
        return roomTypeService.getRoomTypes().stream().map(RoomTypeResponse::new).toList();
    }

    @GetMapping("/{id}/available")
    public Boolean getRoomCount(@PathVariable Long id) {
        roomTypeService.available(id);
        return false;
    }

    @PostMapping()
    public Long addRoomType(@Valid @RequestBody RoomTypeRequest roomType) {
        return roomTypeService.addRoomType(roomType);
    }

}
