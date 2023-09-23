package com.sumprjct.hotel.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sumprjct.hotel.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    

    
}
