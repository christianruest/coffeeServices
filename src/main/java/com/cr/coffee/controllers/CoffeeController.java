package com.cr.coffee.controllers;

import com.cr.coffee.models.coffee.CoffeeModel;
import com.cr.coffee.repositories.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
@RequestMapping("/api/coffee")
public class CoffeeController extends EntityController {

    @Autowired
    private CoffeeRepository coffeeRepository;

    /**
     * get coffee by id
     *
     * @param id of coffee as Long
     * @return HttpEntity of CoffeeModel
     */
    @GetMapping("/{id}")
    public HttpEntity<CoffeeModel> get(@PathVariable("id") long id) {
        return getEntity(coffeeRepository, id);
    }

    /**
     * get all coffees
     *
     * @return List of all coffees in the system
     */
    @GetMapping("/all")
    public List<HttpEntity> getAll() {
        return getAllEntities(coffeeRepository);
    }

    /**
     * creates a coffee
     *
     * @param coffeeModel
     * @return HttpEntity of CoffeeModel
     * @throws Exception
     */
    @PostMapping
    public HttpEntity<CoffeeModel> create(@RequestBody CoffeeModel coffeeModel) throws Exception {
        return createEntity(coffeeRepository, coffeeModel);
    }

    /**
     * updates a coffee in the system
     *
     * @param coffeeModel
     * @return coffeeModel after update
     */
    @PutMapping
    public HttpEntity<CoffeeModel> update(@RequestBody CoffeeModel coffeeModel) {
        return updateEntity(coffeeRepository, coffeeModel);
    }

    /**
     * delete coffee
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        deleteEntity(coffeeRepository, id);
    }

}
