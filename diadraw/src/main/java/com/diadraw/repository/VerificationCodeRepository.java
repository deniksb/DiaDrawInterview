package com.diadraw.repository;

import com.diadraw.model.Customer;
import com.diadraw.model.VerificationCode;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

@Repository
public interface VerificationCodeRepository extends CrudRepository<VerificationCode, Integer> {

    VerificationCode findByCode(String code);

    VerificationCode findByCustomer(Customer customer);

    @Modifying
    @Transactional
    @Query("DELETE FROM VerificationCode e WHERE e.creationDate < :targetDate")
    int deleteByCreationDateBefore(@Param("targetDate") OffsetDateTime targetDate);
}
