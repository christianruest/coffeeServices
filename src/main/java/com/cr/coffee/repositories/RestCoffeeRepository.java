package com.cr.coffee.repositories;

import com.cr.coffee.models.RestCoffeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestCoffeeRepository extends JpaRepository<RestCoffeeModel, Long> {

}
