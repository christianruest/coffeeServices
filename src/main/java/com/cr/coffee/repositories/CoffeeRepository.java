package com.cr.coffee.repositories;

import com.cr.coffee.models.CoffeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<CoffeeModel, Long> {
}
