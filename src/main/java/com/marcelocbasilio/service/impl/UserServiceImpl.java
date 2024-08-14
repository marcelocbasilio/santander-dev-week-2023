package com.marcelocbasilio.service.impl;

import com.marcelocbasilio.controller.exception.GlobalExceptionHandler;
import com.marcelocbasilio.domain.model.User;
import com.marcelocbasilio.domain.repository.IUserRepository;
import com.marcelocbasilio.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (user.getId() != null && userRepository.existsById(user.getId())) {
            throw new IllegalArgumentException("User already exists!");
        }

        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("Account number already exists!");
        }

        return userRepository.save(user);
    }
}
