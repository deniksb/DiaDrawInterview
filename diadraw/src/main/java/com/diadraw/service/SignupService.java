package com.diadraw.service;

import com.diadraw.DataValidationUtils;
import com.diadraw.exception.InvalidEmailException;
import com.diadraw.exception.InvalidLoginException;
import com.diadraw.exception.InvalidPhoneNumberException;
import com.diadraw.model.Customer;
import com.diadraw.model.SignupRequest;
import com.diadraw.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CustomerRepository customerRepository;

    private final CodeSendService codeSendService;

    public SignupService(final CustomerRepository customerRepository, final CodeSendService codeSendService) {
        this.customerRepository = customerRepository;
        this.codeSendService = codeSendService;
    }

    public void registerCustomer(final SignupRequest signupRequest) throws Exception {
        try {
            if (!DataValidationUtils.isValidEmail(signupRequest.email())) {
                throw new InvalidEmailException();
            }

            if (!DataValidationUtils.isValidPhoneNumber(signupRequest.phoneNumber())) {
                throw new InvalidPhoneNumberException();
            }

            final Customer newCustomer = new Customer();

            newCustomer.setEmail(signupRequest.email());

            newCustomer.setPhoneNumber(signupRequest.phoneNumber());

            customerRepository.save(newCustomer);

        } catch (Exception e) {
            logger.error("Failed to register customer: " + signupRequest + ", " + e);

            throw e;
        }
    }

    public void loginCustomer(final SignupRequest signupRequest) throws Exception {
        try {
            if (!DataValidationUtils.isValidEmail(signupRequest.email())) {
                throw new InvalidEmailException();
            }

            if (!DataValidationUtils.isValidPhoneNumber(signupRequest.phoneNumber())) {
                throw new InvalidPhoneNumberException();
            }

            final Customer customer = customerRepository.findByEmailAndPhoneNumber(signupRequest.email(), signupRequest.phoneNumber());

            if (customer == null) {
                throw new InvalidLoginException();
            }
        } catch (Exception e) {
            logger.error("Failed to login customer: " + signupRequest + ", " + e);

            throw e;
        }

    }
}
