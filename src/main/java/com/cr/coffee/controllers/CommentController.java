package com.cr.coffee.controllers;

import com.cr.coffee.controllers.exceptions.InvalidIdException;
import com.cr.coffee.controllers.exceptions.NoDataFoundException;
import com.cr.coffee.models.CommentModel;
import com.cr.coffee.repositories.CommentRepository;
import com.cr.coffee.repositories.RestaurantRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/{id}")
    public CommentModel get(@PathVariable("id") long id) {
        return commentRepository.findById(id).orElseThrow(() -> new NoDataFoundException(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentModel create(@RequestBody CommentModel commentModel) {
        commentModel.setRatingUserId(commentModel.getUserId());
        return commentRepository.save(commentModel);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CommentModel update(@RequestBody CommentModel commentModel) {
        if(get(commentModel.getId()) != null) {
            commentModel.setRatingUserId(commentModel.getUserId());
            return commentRepository.save(commentModel);
        } else {
            throw new InvalidIdException(commentModel.getId());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        commentRepository.deleteById(id);
    }
}
