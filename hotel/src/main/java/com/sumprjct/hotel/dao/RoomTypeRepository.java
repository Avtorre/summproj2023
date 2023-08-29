package com.sumprjct.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumprjct.hotel.entities.RoomType;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

    
}