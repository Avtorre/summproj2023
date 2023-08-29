package com.sumprjct.hotel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumprjct.hotel.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    

    
}
