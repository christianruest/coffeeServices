package com.cr.coffee.controllers;

import com.cr.coffee.models.RestCoffeeModel;
import com.cr.coffee.models.RestaurantModel;
import com.cr.coffee.repositories.RestCoffeeRepository;
import com.cr.coffee.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RestCoffeeController {

    @Autowired
    private RestCoffeeRepository restCoffeeRepository;

    @GetMapping("/{id}")
    public RestCoffeeModel get(@PathVariable("id") long id) {
        return restCoffeeRepository.getOne(id);
    }

    /*
    * get all coffee
    */
    @GetMapping("/all")
    public List<RestCoffeeModel> getAll() {
        return restCoffeeRepository.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody RestCoffeeModel RestCoffeeModel) {
        restCoffeeRepository.save(RestCoffeeModel);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody RestCoffeeModel RestCoffeeModel) {
        if(get(RestCoffeeModel.getId()) != null) {
            restCoffeeRepository.save(RestCoffeeModel);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        restCoffeeRepository.deleteById(id);
    }
}
