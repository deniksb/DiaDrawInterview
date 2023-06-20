package com.diadraw;

import java.util.regex.Pattern;

public class CredentialVerificationUtills {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String INTERNATIONAL_PHONE_REGEX = "^(?:[0-9]?){6,14}[0-9]$";

    public static boolean isValidEmail(final String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean isValidPhoneNumber(final String mobileNumber) {
        return Pattern.matches(INTERNATIONAL_PHONE_REGEX, mobileNumber);
    }
}
