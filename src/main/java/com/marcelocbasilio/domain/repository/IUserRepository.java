package com.marcelocbasilio.domain.repository;

import com.marcelocbasilio.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);
    boolean existsByCardNumber(String cardNumber);
}
