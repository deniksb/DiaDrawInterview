package com.diadraw.rest;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CodeSendRestService {

    private final static String BASE_URL = "https://3vexlv.api.infobip.com";

    private final String apiKey;

    private final OkHttpClient client;

    public CodeSendRestService(@Value("${infobip.api.key}") final String apiKey)
    {
        this. client = new OkHttpClient().newBuilder().build();
        this.apiKey = apiKey;
    }

    public Response sendSms(final String verificationCode, final String phoneNumber) throws IOException {

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"messages\":[{\"destinations\":[{\"to\":\"" + phoneNumber +"\"}],\"from\":\"Denko\",\"text\":\"" + verificationCode +"\"}]}");
        Request request = new Request.Builder()
                .url(BASE_URL + "/sms/2/text/advanced")
                .method("POST", body)
                .addHeader("Authorization", apiKey)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();

        return client.newCall(request).execute();
    }

    public Response sendEmail(final String verificationCode, final String email) throws IOException {

        RequestBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("from", "losfrenn@selfserviceib.com")
                .addFormDataPart("to", email)
                .addFormDataPart("subject", "Verification code")
                .addFormDataPart("text", verificationCode).build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/email/3/send")
                .method("POST", body)
                .addHeader("Authorization", apiKey)
                .build();

        return client.newCall(request).execute();
    }
}
