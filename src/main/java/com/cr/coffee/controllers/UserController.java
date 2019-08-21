package com.cr.coffee.controllers;


import com.cr.coffee.controllers.exceptions.InvalidIdException;
import com.cr.coffee.controllers.exceptions.NoDataFoundException;
import com.cr.coffee.models.UserModel;
import com.cr.coffee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController extends EntityController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public HttpEntity<UserModel> get(@PathVariable("id") String id) {
        return getEntity(userRepository, id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HttpEntity<UserModel> create(@RequestBody UserModel userModel) {
        return createEntity(userRepository, userModel);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<UserModel> update(@RequestBody UserModel userModel) {
        return updateEntity(userRepository, userModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        deleteEntity(userRepository, id);
    }

    @GetMapping("/username/{userName}")
    public List<UserModel> findByUserName(@PathVariable("userName") String userName) {
        return userRepository.findByUserName(userName);
    }

}
