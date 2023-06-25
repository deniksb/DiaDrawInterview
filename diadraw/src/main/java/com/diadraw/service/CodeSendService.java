package com.diadraw.service;

import com.diadraw.model.Customer;
import com.diadraw.repository.CustomerRepository;
import com.diadraw.rest.CodeSendRestService;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CodeSendService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CodeSendRestService codeSendRestService;

    private final CodeVerificationService codeVerificationService;

    private final CustomerRepository customerRepository;

    public CodeSendService(final CodeSendRestService codeSendRestService, final CodeVerificationService codeVerificationService, final CustomerRepository customerRepository) {
        this.codeSendRestService = codeSendRestService;
        this.codeVerificationService = codeVerificationService;
        this.customerRepository = customerRepository;
    }

    public String sendCodeViaEmail(final String email) throws Exception {

        AutoCloseable closeable = null;

        try {
            final Customer customer = customerRepository.findByEmail(email);

            if (customer == null) {
                logger.warn("Customer not found when sending code via email " + email);

                return Strings.EMPTY;
            }

            final String code = codeVerificationService.createVerificationCode(customer);

            closeable = codeSendRestService.sendEmail(code, email);

            return code;
        } catch (Exception e) {
            logger.error("Failed to send code via email: " + email + "with error: " + e);

            throw e;
        } finally {
            assert closeable != null;
            closeable.close();
        }
    }

    public String sendCodeViaPhone(final String phone) throws Exception {

        AutoCloseable closeable = null;

        try {
            final Customer customer = customerRepository.findByPhoneNumber(phone);

            if (customer == null) {
                logger.warn("Customer not found when sending code via phone " + phone);

                return Strings.EMPTY;
            }

            final String code = codeVerificationService.createVerificationCode(customer);

            closeable = codeSendRestService.sendSms(code, phone);

            return code;
        } catch (Exception e) {
            logger.error("Failed to send code via phone: " + phone + "with error: " + e);

            throw e;
        } finally {
            assert closeable != null;
            closeable.close();
        }
    }
}
