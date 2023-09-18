package com.sumprjct.hotel.responseRequests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RoomTypeRequest {
    
    @NotNull
    private Long outerPreview;

    @NotBlank(message = "Field \"caption\" cannot be empty")
    @Size(min = 1, max = 32, message = "The length of field \"caption\" must be between 1 and 32")
    private String caption;

    @NotNull
    private Long innerPreview;

    @NotBlank(message = "Field \"description\" cannot be empty")
    @Size(min = 1, max = 1024, message = "The length of field \"description\" must be between 1 and 1024")
    private String description;

    @NotNull
    @Min(1)
    @Max(value = 8, message = "Max value is 8 for field \"guestCount\"")
    private Short guestCount;

}
