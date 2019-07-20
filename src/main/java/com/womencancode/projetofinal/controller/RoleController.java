package com.womencancode.projetofinal.controller;

import com.womencancode.projetofinal.service.RoleService;
import com.womencancode.projetofinal.model.Role;
import com.womencancode.projetofinal.model.User;
import com.womencancode.projetofinal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/role", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController {

    @Autowired
    RoleService service;

    @PostMapping
    public ResponseEntity<Role> insertUser(@RequestBody Role role) throws Exception {
        return ResponseEntity.ok(service.insertRole(role));
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Role> updateUser(@RequestBody Role role, @PathVariable String id) throws Exception {
        role.setId(id);
        return ResponseEntity.ok(service.updateRole(role));
    }


    @GetMapping
    public ResponseEntity<List<Role>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Role> findById(@PathVariable String id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Void> delete(@PathVariable String id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
