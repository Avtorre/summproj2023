package com.sumprjct.hotel.responseRequests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterRequest {
    
    @NotBlank(message = "Field \"firstname\" cannot be empty")
    @Size(min = 1, max = 32, message = "The length of field \"firstname\" must be between 1 and 32")
    private String firstname;

    @NotBlank(message = "Field \"surname\" cannot be empty")
    @Size(min = 1, max = 32, message = "The length of field \"surname\" must be between 1 and 32")
    private String surname;

    @NotBlank(message = "Field \"email\" cannot be empty")
    @Size(min = 1, max = 32, message = "The length of field \"firstname\" must be between 1 and 256")
    @Email
    private String email;

    @NotBlank(message = "Field \"password\" cannot be empty")
    @Size(min = 8, max = 256, message = "The length of field \"password\" must be between 8 and 256")
    private String password;

}
