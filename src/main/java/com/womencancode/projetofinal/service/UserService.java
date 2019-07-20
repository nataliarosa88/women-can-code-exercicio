package com.womencancode.projetofinal.service;

import com.womencancode.projetofinal.model.User;
import com.womencancode.projetofinal.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserService(@Autowired UserRepository repository) {
        this.repository = repository;
    }

    public User insertUser(User user) {
        return repository.insert(user);
    }

    public User updateUser(User user) {
        return repository.save(user);
    }

    public List<User> findAll (){
        return repository.findAll();
    }

    public User findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}