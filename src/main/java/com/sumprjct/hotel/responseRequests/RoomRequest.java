package com.sumprjct.hotel.responseRequests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoomRequest {
    
    @NotNull
    private Integer number;

    @NotNull
    private Long type;

}
