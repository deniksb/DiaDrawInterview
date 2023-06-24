package com.diadraw.controller;

import com.diadraw.model.AuthenticationRequest;
import com.diadraw.service.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

    private final JwtService jwtService;

    public AuthenticationController(final JwtService jwtService)
    {
        this.jwtService = jwtService;
    }

    @PostMapping("/authenticate")
    public String validateJwt(@RequestBody final AuthenticationRequest authenticationRequest) throws Exception
    {
        return jwtService.validateJwtToken(authenticationRequest.token());
    }
}
