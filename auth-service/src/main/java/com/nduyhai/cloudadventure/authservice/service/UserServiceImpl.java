package com.nduyhai.cloudadventure.authservice.service;

import com.nduyhai.cloudadventure.authservice.domain.User;
import com.nduyhai.cloudadventure.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(User user) {
        this.repository.save(user);
    }
}
