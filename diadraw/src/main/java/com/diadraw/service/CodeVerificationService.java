package com.diadraw.service;

import com.diadraw.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CodeVerificationService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final int CODE_LENGTH = 6;

    private final Map<String, Customer> verificationCodes;

    private final JwtService jwtService;

    public CodeVerificationService(final JwtService jwtService)
    {
        this.verificationCodes = new HashMap<>();
        this.jwtService = jwtService;
    }

    public String createVerificationCode(final Customer customer)
    {
        String code;

        do {
            code = generateCode();
        } while (verificationCodes.containsKey(code));

        verificationCodes.put(code, customer);

        return code;
    }

    public Optional<String> verifyCode(final String code)
    {
        try
        {
            final Customer customer = verificationCodes.get(code);

            verificationCodes.remove(code);

            return Optional.of(jwtService.generateJwtToken(customer.getEmail(), customer.getPhoneNumber()));
        }
        catch (Exception e)
        {
            logger.warn("Failed to verify code: " + code + ", " + e);

            return Optional.empty();
        }
    }

    private static String generateCode() {

        return IntStream.range(0, CODE_LENGTH)
                .mapToObj(i -> String.valueOf(ThreadLocalRandom.current().nextInt(10)))
                .collect(Collectors.joining());
    }
}
