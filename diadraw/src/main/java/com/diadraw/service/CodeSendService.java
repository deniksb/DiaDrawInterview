package com.diadraw.service;

import com.diadraw.model.Customer;
import com.diadraw.repository.CustomerRepository;
import com.diadraw.rest.CodeSendRestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CodeSendService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CodeSendRestService codeSendRestService;

    private final CodeVerificationService codeVerificationService;

    private final CustomerRepository customerRepository;

    public CodeSendService(final CodeSendRestService codeSendRestService, final CodeVerificationService codeVerificationService, final CustomerRepository customerRepository)
    {
        this.codeSendRestService = codeSendRestService;
        this.codeVerificationService = codeVerificationService;
        this.customerRepository = customerRepository;
    }

    public void sendCodeViaEmail(final String email) throws IOException {
        final Customer customer = customerRepository.findByEmail(email);

        if(customer == null)
        {
            logger.warn("Customer not found when sending code via email " + email);

            return;
        }

        final String code = codeVerificationService.createVerificationCode(customer);

        codeSendRestService.sendEmail(code, email);
    }

    public void sendCodeViaPhone(final String phone) throws IOException {
        final Customer customer = customerRepository.findByPhoneNumber(phone);

        if(customer == null)
        {
            logger.warn("Customer not found when sending code via phone " + phone);

            return;
        }

        final String code = codeVerificationService.createVerificationCode(customer);

        codeSendRestService.sendSms(code, phone);
    }
}