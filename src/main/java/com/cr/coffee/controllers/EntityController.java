package com.cr.coffee.controllers;

import com.cr.coffee.controllers.exceptions.InvalidIdException;
import com.cr.coffee.controllers.exceptions.InvalidRefDataException;
import com.cr.coffee.controllers.exceptions.NoDataFoundException;
import com.cr.coffee.repositories.CoffeeRepository;
import com.cr.coffee.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpEntity;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

public class EntityController implements EntityControllerInterface {

    @Override
    public HttpEntity createEntity(JpaRepository repository, Object object) {
        try {
            return new HttpEntity(repository.save(object));
        } catch (Exception e) {
            throw new InvalidRefDataException(e.getMessage()); //TODO: return propertyPath=compostition, interpolatedMessage:'must be less or equal to 100'
        }
    }

    @Override
    public HttpEntity getEntity(JpaRepository repository, String id) {
        Object response = repository.findById(id);

        if (response != Optional.empty()) {
            return new HttpEntity(response);
        } else {
            throw new NoDataFoundException(id);
        }
    }

    @Override
    public HttpEntity getEntity(JpaRepository repository, Long id) {
        Object response = repository.findById(id);

        if (response != Optional.empty()) {
            return new HttpEntity(response);
        } else {
            throw new NoDataFoundException(id);
        }
    }

    @Override
    public List<HttpEntity> getAllEntities(JpaRepository repository) {
        return repository.findAll();
    }

    @Override
    public HttpEntity updateEntity(JpaRepository repository, Object object) {
        Object id;

        try {
            Method methodGetId = object.getClass().getMethod("getId");
            id = methodGetId.invoke(object);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        if(repository.existsById(id)) {
            //createEntity because it handles ConstraintViolationException
            return createEntity(repository, object);
        } else {
            throw new InvalidIdException(id.toString());
        }
    }

    @Override
    public void deleteEntity(JpaRepository repository, Object id) {
        repository.deleteById(id);
    }
}
