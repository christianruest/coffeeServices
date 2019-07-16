package com.cr.coffee.repositories;

import com.cr.coffee.models.RestaurantRatingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRatingRepository extends JpaRepository <RestaurantRatingModel, Long> {
}
