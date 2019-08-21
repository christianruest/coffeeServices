package com.cr.coffee.controllers;

import com.cr.coffee.controllers.exceptions.NoDataFoundException;
import com.cr.coffee.models.restaurant.RestaurantRatingModel;
import com.cr.coffee.repositories.RestaurantRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/restaurant/rating")
public class RestaurantRatingController extends EntityController {

    @Autowired
    RestaurantRatingRepository restaurantRatingRepository;

    @GetMapping("/{id}")
    public HttpEntity<RestaurantRatingModel> get(@PathVariable("id") long id) {
        return getEntity(restaurantRatingRepository, id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HttpEntity<RestaurantRatingModel> createRestaurantRating(@Valid @RequestBody RestaurantRatingModel restaurantRatingModel) {
        return createEntity(restaurantRatingRepository, restaurantRatingModel);
    }

}
