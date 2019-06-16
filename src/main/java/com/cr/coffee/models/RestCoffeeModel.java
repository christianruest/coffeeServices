package com.cr.coffee.models;


import com.cr.coffee.models.CoffeeModel;
import com.cr.coffee.repositories.CoffeeRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="restaurant_x_coffee")
public class RestCoffeeModel {

    @Id
    @Column(name="rest_x_cof_id")
    private long id;

    @Column(name="coffee_id")
    private long coffeeId;

    @Column(name="restaurant_id")
    private long restaurantId;

    @Column(name ="coffee_name")
    private String coffeeName;

    /*@ManyToOne
    @JoinColumn(name="restaurant_id", referencedColumnName = "restaurant_id")
    private RestaurantModel restaurants;*/

    public RestCoffeeModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(long coffeeId) {
        this.coffeeId = coffeeId;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

/*public RestaurantModel getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(RestaurantModel restaurants) {
        this.restaurants = restaurants;
    }*/
}
