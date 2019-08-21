package com.cr.coffee.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpEntity;

import java.util.List;

public interface EntityControllerInterface {
    public HttpEntity createEntity(JpaRepository repository, Object object);
    public HttpEntity getEntity(JpaRepository repository, String id);
    public HttpEntity getEntity(JpaRepository repository, Long id);
    public List<HttpEntity> getAllEntities(JpaRepository repository);
    public HttpEntity updateEntity(JpaRepository repository, Object object);
    public void deleteEntity(JpaRepository repository, Object id);

}
