package com.marcelocbasilio.service;

import com.marcelocbasilio.domain.model.User;

public interface IUserService {

    User findById(Long id);
    User create(User user);
}
