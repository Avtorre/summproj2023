package com.sumprjct.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumprjct.hotel.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    
    
}