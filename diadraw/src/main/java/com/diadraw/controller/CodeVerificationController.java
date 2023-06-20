package com.diadraw.controller;

import com.diadraw.service.CodeSendService;
import com.diadraw.service.CodeVerificationService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
public class CodeVerificationController {

    private final CodeVerificationService codeVerificationService;

    private CodeSendService codeSendService;

    public CodeVerificationController(final CodeVerificationService codeVerificationService, final CodeSendService codeSendService)
    {
        this.codeVerificationService = codeVerificationService;
        this.codeSendService = codeSendService;
    }

    @GetMapping("/verify/{code}")
    public Optional<String> verifyCode(@PathVariable final String code) {

        return codeVerificationService.verifyCode(code);
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
