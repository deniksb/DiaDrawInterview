package com.diadraw.controller;

import com.diadraw.model.SignupRequest;
import com.diadraw.service.CodeVerificationService;
import com.diadraw.service.SignupService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SignupController {

    private final SignupService signupService;

    public SignupController(final SignupService signupService, final CodeVerificationService codeVerificationService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody final SignupRequest signupRequest) throws Exception {

        return signupService.registerCustomer(signupRequest);
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody final SignupRequest signupRequest) throws Exception {

        return signupService.loginCustomer(signupRequest);
    }
}
