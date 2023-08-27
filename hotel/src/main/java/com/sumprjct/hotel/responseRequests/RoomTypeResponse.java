package com.sumprjct.hotel.responseRequests;

import java.util.Date;

import com.sumprjct.hotel.entities.RoomType;

import lombok.Data;

@Data
public class RoomTypeResponse {

    private Long id;
    
    private Long outerPreview;

    private String caption;

    private Long innerPreview;

    private String description;

    private Short guestCount;

    private Date creationDate;

     public RoomTypeResponse(RoomType roomType){
        this.id = roomType.getId();
        this.outerPreview = roomType.getOuterPreview() != null ?
            roomType.getOuterPreview().getId() : null;
        this.caption = roomType.getCaption();
        this.innerPreview = roomType.getInnerPreview() != null ?
            roomType.getInnerPreview().getId() : null;
        this.description = roomType.getDescription();
        this.guestCount = roomType.getGuestCount();
        this.creationDate = roomType.getCreationDate();
    }

}