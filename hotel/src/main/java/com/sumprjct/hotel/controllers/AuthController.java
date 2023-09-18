package com.sumprjct.hotel.controllers;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.sumprjct.hotel.dao.ConfirmCodeRepository;
import com.sumprjct.hotel.entities.Account;
import com.sumprjct.hotel.responseRequests.AuthenticationRequest;
import com.sumprjct.hotel.responseRequests.RegisterRequest;
import com.sumprjct.hotel.service.AccountService;
import com.sumprjct.hotel.service.UserService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.*;
import jakarta.validation.Valid;
import lombok.*;

@RestController
@RequiredArgsConstructor
@Validated
public class AuthController {
    private final AccountService service;
    private final ConfirmCodeRepository confirmCodeRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request, @NonNull HttpServletResponse response) throws MessagingException {
        service.register(request, response);
        return new ResponseEntity<String>("Accepted", HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@Valid @RequestBody AuthenticationRequest request, @NonNull HttpServletResponse response) {
        service.authenticate(request, response);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @GetMapping("/check")
    public Object check() {
        var account = (Account)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return account.getRole().name();
    }

    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.refreshToken(request, response);
    }

    @GetMapping("/confirm/{key}")
    public ResponseEntity<String> confirm(@PathVariable String key) {
        var code = confirmCodeRepository.findByKey(key);
        if (code == null) return new ResponseEntity<String>("Incorrect code", HttpStatus.CONFLICT);
        if (!service.setConfirmById(code.getUser().getId()))
            return new ResponseEntity<String>("Incorrect code", HttpStatus.CONFLICT);
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }
}
