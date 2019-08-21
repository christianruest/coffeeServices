package com.cr.coffee.controllers;

import com.cr.coffee.controllers.exceptions.InvalidIdException;
import com.cr.coffee.controllers.exceptions.NoDataFoundException;
import com.cr.coffee.models.restaurant.CommentModel;
import com.cr.coffee.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/comment")
public class CommentController extends EntityController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/{id}")
    public HttpEntity<CommentModel> get(@PathVariable("id") long id) {
        return getEntity(commentRepository, id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HttpEntity<CommentModel> create(@RequestBody CommentModel commentModel) {
        populateRatingUserIdIfNecessary(commentModel);
        return createEntity(commentRepository, commentModel);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<CommentModel> update(@RequestBody CommentModel commentModel) {
        populateRatingUserIdIfNecessary(commentModel);
        return updateEntity(commentRepository, commentModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        deleteEntity(commentRepository, id);
    }

    private void populateRatingUserIdIfNecessary(CommentModel commentModel) {
        if(commentModel.getRating() != null || commentModel.getRestaurantId() != null)
            commentModel.setRatingUserId(commentModel.getUserId());
    }
}
