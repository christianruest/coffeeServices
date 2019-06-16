package com.cr.coffee.controllers;

import com.cr.coffee.models.RestaurantModel;
import com.cr.coffee.models.RestaurantSpecificationBuilder;
import com.cr.coffee.repositories.RestaurantRepository;
import com.cr.coffee.utils.SearchCriteria;
import com.cr.coffee.utils.SearchCriteriaContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
//@Component
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/{id}")
    public RestaurantModel get(@PathVariable("id") long id) {
        return restaurantRepository.getOne(id);
    }

    /*
    * get all coffee
    */
    @GetMapping("/all")
    public List<RestaurantModel> getAll() {
        return restaurantRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody RestaurantModel restaurantModel) {
        restaurantRepository.save(restaurantModel);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody RestaurantModel restaurantModel) {
        if(get(restaurantModel.getId()) != null) {
            restaurantRepository.save(restaurantModel);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        restaurantRepository.deleteById(id);
    }

    @PostMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantModel> searchRestaurants(@RequestBody SearchCriteriaContainer searchCriteriaContainer) {
        List<SearchCriteria> searchCriteriaList = searchCriteriaContainer.getSearchCriteria();
        return restaurantRepository.findAll(new RestaurantSpecificationBuilder(searchCriteriaList).build());
    }

    @PostMapping("/return")
    public List<SearchCriteria> returnSearchCriteria(@RequestBody SearchCriteriaContainer searchCriteriaContainer) {
        List<SearchCriteria> searchCriteriaList = searchCriteriaContainer.getSearchCriteria();
        return searchCriteriaList;
    }
}
