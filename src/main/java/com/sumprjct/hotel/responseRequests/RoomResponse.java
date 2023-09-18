package com.sumprjct.hotel.responseRequests;

import java.util.Date;

import com.sumprjct.hotel.entities.Room;

import lombok.Data;

@Data
public class RoomResponse {
    
    private Long id;

    private Integer number;

    private Long type;

    private Boolean active;

    private Date lastCleaning;

    private Date creationDate;

    public RoomResponse(Room room){
        this.id = room.getId();
        this.number = room.getNumber();
        this.type = room.getType() != null ? room.getType().getId() : null;
        this.active = room.getActive();
        this.lastCleaning = room.getLastCleaning();
        this.creationDate = room.getCreationDate();
    }

}
