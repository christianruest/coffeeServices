package com.cr.coffee.controllers;

import com.cr.coffee.controllers.exceptions.InvalidIdException;
import com.cr.coffee.controllers.exceptions.NoDataFoundException;
import com.cr.coffee.models.restaurant.RestCoffeeModel;
import com.cr.coffee.repositories.RestCoffeeRepository;
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
@RequestMapping("/api/restCoffee")
public class RestCoffeeController extends EntityController {

    @Autowired
    private RestCoffeeRepository restCoffeeRepository;

    @GetMapping("/{id}")
    public HttpEntity<RestCoffeeModel> get(@PathVariable("id") long id) {
        return getEntity(restCoffeeRepository, id);
    }

    @GetMapping("/all")
    public List<HttpEntity> getAll() {
        return getAllEntities(restCoffeeRepository);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<RestCoffeeModel> create(@RequestBody RestCoffeeModel restCoffeeModel) {
        return createEntity(restCoffeeRepository, restCoffeeModel);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<RestCoffeeModel> update(@RequestBody RestCoffeeModel restCoffeeModel) {
        return updateEntity(restCoffeeRepository, restCoffeeModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        deleteEntity(restCoffeeRepository, id);
    }
}
