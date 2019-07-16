package com.cr.coffee.repositories;

import com.cr.coffee.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {

    /**
     * to be called to find out if userName is already taken
     * @param userName
     * @return user if exists
     */
    List<UserModel> findByUserName(String userName);

}
