package com.sumprjct.hotel.dao;

import com.sumprjct.hotel.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Image getImageById(Long id);
}
