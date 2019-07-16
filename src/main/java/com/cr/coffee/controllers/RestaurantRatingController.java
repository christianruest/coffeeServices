package com.cr.coffee.controllers;

import com.cr.coffee.models.RestaurantRatingModel;
import com.cr.coffee.repositories.RestaurantRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/restaurant/rating")
public class RestaurantRatingController {

    @Autowired
    RestaurantRatingRepository restaurantRatingRepository;

    @GetMapping("/{id}")
    public RestaurantRatingModel get(@PathVariable("id") Long id) {
        return restaurantRatingRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRestaurantRating(@RequestBody RestaurantRatingModel restaurantRatingModel) {
        restaurantRatingRepository.save(restaurantRatingModel);
    }

}
