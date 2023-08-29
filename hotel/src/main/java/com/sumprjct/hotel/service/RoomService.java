package com.sumprjct.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sumprjct.hotel.dao.RoomRepository;
import com.sumprjct.hotel.entities.Room;
import com.sumprjct.hotel.entities.RoomType;
import com.sumprjct.hotel.responseRequests.RoomRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    public Long addRoom(RoomRequest request) {
        Room room = Room.builder()
            .number(request.getNumber())
            .type(
                RoomType.builder()
                    .id(request.getType())
                    .build()
            ).build();
        return roomRepository.save(room).getId();
    }

}
