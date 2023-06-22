package com.diadraw.controller;

import com.diadraw.exception.CodeNotFoundException;
import com.diadraw.service.CodeSendService;
import com.diadraw.service.CodeVerificationService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CodeVerificationController {

    private final CodeVerificationService codeVerificationService;

    private CodeSendService codeSendService;

    public CodeVerificationController(final CodeVerificationService codeVerificationService, final CodeSendService codeSendService)
    {
        this.codeVerificationService = codeVerificationService;
        this.codeSendService = codeSendService;
    }

    @GetMapping("/verify")
    public String verifyCode(@RequestParam final String code, @RequestParam final String email) throws CodeNotFoundException {

        return codeVerificationService.verifyCode(code, email);
    }

    @GetMapping("/verify/email")
    public void requestEmailVerificationCode(@RequestParam final String email) throws IOException {

        codeSendService.sendCodeViaEmail(email);
    }

    @GetMapping("/verify/phone")
    public void requestPhoneVerificationCode(@RequestParam final String phoneNumber) throws IOException {

        codeSendService.sendCodeViaPhone(phoneNumber);
    }
}
