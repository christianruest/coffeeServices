package com.cr.coffee.models;

import com.cr.coffee.controllers.exceptions.NoDataFoundException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.logging.Logger;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="restaurant_rating")
public class RestaurantRatingModel {

    @Id
    @Column(name="rest_rating_id")
    private long id;

    @NotNull(message = "restaurantId must not be null")
    @Column(name="restaurant_id")
    private Long restaurantId;

    @Column(name="user_id")
    private String userId;

    @NotNull(message = "rating must not be null")
    private Integer rating;

    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
