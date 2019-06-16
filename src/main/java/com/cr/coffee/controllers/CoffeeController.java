package com.cr.coffee.controllers;

import com.cr.coffee.models.CoffeeModel;
import com.cr.coffee.repositories.CoffeeRepository;
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
@RequestMapping("/api/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeRepository coffeeRepository;

    /*
    * get coffee by Id
    */
    @GetMapping("/{id}")
    public CoffeeModel get(@PathVariable("id") long id) {
        return coffeeRepository.getOne(id);
    }

    /*
    * get all coffee
    */
    @GetMapping("/all")
    public List<CoffeeModel> getAll() {
        return coffeeRepository.findAll();
    }

    /*
    * create coffee
    */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CoffeeModel coffeeModel) {
        coffeeRepository.save(coffeeModel);
    }

    /*
    * update coffee
    */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody CoffeeModel coffeeModel) {
        if(get(coffeeModel.getId()) != null){
            coffeeRepository.save(coffeeModel);
        } /*else {
            throw new Exception('Missing Data Exception'); //TODO: create custom error message
        }*/
    }

    /*
    * delete coffee
    */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        coffeeRepository.deleteById(id);
    }

}
