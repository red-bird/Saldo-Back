package com.redbird.SaldoBack.services;

import com.redbird.SaldoBack.models.User;

import java.util.List;

public interface UserService {
    public User findByUsername(String username);
    public User saveUser(User user);
    public User findById(Long id);
    public List<User> findAll();
    public void deleteById(Long id);
}
