package com.diadraw.service;

import com.diadraw.model.Customer;
import com.diadraw.repository.CustomerRepository;
import com.diadraw.rest.CodeSendRestService;
import org.apache.logging.log4j.util.Strings;
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

    public String sendCodeViaEmail(final String email) throws IOException {
        final Customer customer = customerRepository.findByEmail(email);

        if(customer == null)
        {
            logger.warn("Customer not found when sending code via email " + email);

            return Strings.EMPTY;
        }

        final String code = codeVerificationService.createVerificationCode(customer);

        codeSendRestService.sendEmail(code, email);

        return code;
    }

    public String sendCodeViaPhone(final String phone) throws IOException {
        final Customer customer = customerRepository.findByPhoneNumber(phone);

        if(customer == null)
        {
            logger.warn("Customer not found when sending code via phone " + phone);

            return Strings.EMPTY;
        }

        final String code = codeVerificationService.createVerificationCode(customer);

        codeSendRestService.sendSms(code, phone);

        return code;
    }
}
