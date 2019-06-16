package com.cr.coffee.repositories;

import com.cr.coffee.models.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantModel, Long>,
        JpaSpecificationExecutor<RestaurantModel> {

}
