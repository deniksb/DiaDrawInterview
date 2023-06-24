package com.diadraw.controller;

import com.diadraw.model.AuthenticationRequest;
import com.diadraw.service.JwtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
