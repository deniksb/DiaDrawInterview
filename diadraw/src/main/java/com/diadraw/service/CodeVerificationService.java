package com.diadraw.service;

import com.diadraw.exception.CodeNotFoundException;
import com.diadraw.model.Customer;
import com.diadraw.model.VerificationCode;
import com.diadraw.repository.VerificationCodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CodeVerificationService {

    private final static int EXPIRATION_MINUTES = 10;
    private static final int CODE_LENGTH = 6;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final VerificationCodeRepository verificationCodeRepository;

    private final JwtService jwtService;

    public CodeVerificationService(final JwtService jwtService, final VerificationCodeRepository verificationCodeRepository) {
        this.verificationCodeRepository = verificationCodeRepository;
        this.jwtService = jwtService;
    }

    private static String generateCode() {

        return IntStream.range(0, CODE_LENGTH)
                .mapToObj(i -> String.valueOf(ThreadLocalRandom.current().nextInt(10)))
                .collect(Collectors.joining());
    }

    public String createVerificationCode(final Customer customer) {

        VerificationCode existingCode = verificationCodeRepository.findByCustomer(customer);

        if(existingCode != null)
        {
            return existingCode.getCode();
        }

        final String code = generateCode();

        final VerificationCode verificationCode = new VerificationCode();

        verificationCode.setCode(code);
        verificationCode.setCreationDate(OffsetDateTime.now());
        verificationCode.setCustomer(customer);

        verificationCodeRepository.save(verificationCode);

        return code;
    }

    public String verifyCode(final String code, final String email) throws CodeNotFoundException {
        try {
            final VerificationCode verificationCode = verificationCodeRepository.findByCode(code);

            if (verificationCode == null) {
                throw new CodeNotFoundException();
            }

            final Customer customer = verificationCode.getCustomer();

            if (!Objects.equals(customer.getEmail(), email)) {
                throw new CodeNotFoundException();
            }

            verificationCodeRepository.deleteById(verificationCode.getId());

            return jwtService.generateJwtToken(verificationCode.getCustomer().getEmail(), verificationCode.getCustomer().getPhoneNumber());
        } catch (Exception e) {
            logger.warn("Failed to verify code: " + code + ", " + e);

            throw e;
        }
    }

    @Scheduled(cron = "0 */5 * * * ?")
    private void deleteExpiredCodes() {
        final OffsetDateTime targetDate = OffsetDateTime.now().minusMinutes(EXPIRATION_MINUTES);
        verificationCodeRepository.deleteByCreationDateBefore(targetDate);
    }
}
