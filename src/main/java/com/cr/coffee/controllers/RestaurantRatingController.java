package com.cr.coffee.controllers;

import com.cr.coffee.controllers.exceptions.NoDataFoundException;
import com.cr.coffee.models.RestaurantRatingModel;
import com.cr.coffee.repositories.RestaurantRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.Min;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/restaurant/rating")
public class RestaurantRatingController {

    public RestaurantRatingController(RestaurantRatingRepository restaurantRatingRepository) {
        this.restaurantRatingRepository = restaurantRatingRepository;
    }

    @Autowired
    RestaurantRatingRepository restaurantRatingRepository;

    @GetMapping("/{id}")
    public RestaurantRatingModel get(@PathVariable("id") long id) {
        return restaurantRatingRepository.findById(id).orElseThrow(() -> new NoDataFoundException(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantRatingModel createRestaurantRating(@Valid @RequestBody RestaurantRatingModel restaurantRatingModel) {
        return restaurantRatingRepository.save(restaurantRatingModel);
    }

}
