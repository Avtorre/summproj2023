package com.sumprjct.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumprjct.hotel.entities.ConfirmCode;

public interface ConfirmCodeRepository extends JpaRepository<ConfirmCode, Long> {
    
    public ConfirmCode findByKey(String key);

    public boolean existsByKey(String key);

}
