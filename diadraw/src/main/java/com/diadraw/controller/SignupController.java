package com.diadraw.controller;

import com.diadraw.service.CodeVerificationService;
import com.diadraw.service.SignupService;
import com.diadraw.model.SignupRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignupController {

    private final SignupService signupService;

    public SignupController(final SignupService signupService, final CodeVerificationService codeVerificationService)
    {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody final SignupRequest signupRequest) throws Exception {

        signupService.registerCustomer(signupRequest);
    }
}
