package com.sumprjct.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sumprjct.hotel.dao.RoomRepository;
import com.sumprjct.hotel.dao.RoomTypeRepository;
import com.sumprjct.hotel.entities.Image;
import com.sumprjct.hotel.entities.RoomType;
import com.sumprjct.hotel.responseRequests.RoomTypeRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;
    private final RoomRepository roomRepository;

    public List<RoomType> getRoomTypes() {
        return roomTypeRepository.findAll();
    }

    public Long addRoomType(RoomTypeRequest room) {
        RoomType roomType = RoomType.builder()
            .outerPreview(
                Image.builder()
                    .id(room.getOuterPreview())
                    .build()
            ).caption(room.getCaption())
            .innerPreview(
                Image.builder()
                    .id(room.getInnerPreview())
                    .build()
            ).description(room.getDescription())
            .guestCount(room.getGuestCount())
            .build();
        return roomTypeRepository.save(roomType).getId();
    }

    public Boolean available(Long id) {
        return !roomRepository.available(id).isEmpty();
    }
    
}