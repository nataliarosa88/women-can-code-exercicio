package com.womencancode.projetofinal.service;

import com.womencancode.projetofinal.model.Role;
import com.womencancode.projetofinal.model.User;
import com.womencancode.projetofinal.repository.UserRepository;
import com.womencancode.projetofinal.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public RoleService(@Autowired RoleRepository repository) {
        this.repository = repository;
    }

    public Role insertRole(Role role) {
        return repository.insert(role);
    }

    public Role updateRole(Role role) {
        return repository.save(role);
    }

    public List<Role> findAll (){
        return repository.findAll();
    }

    public Role findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}