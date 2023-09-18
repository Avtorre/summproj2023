package com.sumprjct.hotel.responseRequests;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}
