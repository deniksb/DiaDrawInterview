package com.diadraw.repository;

import com.diadraw.model.VerificationCode;
import org.springframework.data.repository.CrudRepository;

public interface VerificationCodeRepository extends CrudRepository<VerificationCode, Integer> {

    VerificationCode findByCode(String code);
}
