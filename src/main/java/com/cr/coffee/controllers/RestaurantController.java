package com.cr.coffee.controllers;

import com.cr.coffee.controllers.exceptions.InvalidIdException;
import com.cr.coffee.controllers.exceptions.NoDataFoundException;
import com.cr.coffee.models.AddressModel;
import com.cr.coffee.models.restaurant.RestaurantModel;
import com.cr.coffee.models.restaurant.RestaurantSpecificationBuilder;
import com.cr.coffee.repositories.RestaurantRepository;
import com.cr.coffee.utils.SearchCriteria;
import com.cr.coffee.utils.SearchCriteriaContainer;
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

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController extends EntityController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/{id}")
    public HttpEntity<RestaurantModel> get(@PathVariable("id") long id) {
        return getEntity(restaurantRepository, id);
    }

    @GetMapping("/all")
    public List<HttpEntity> getAll() {
        return getAllEntities(restaurantRepository);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<RestaurantModel> create(@RequestBody RestaurantModel restaurantModel) {
        if (restaurantModel.getAddress() != null) {
            restaurantModel = setAddressObjectIdAndType(restaurantModel);
        }

        return createEntity(restaurantRepository, restaurantModel);
    }

    private RestaurantModel setAddressObjectIdAndType(RestaurantModel restaurantModel) {
        AddressModel innerAddress = restaurantModel.getAddress();
        innerAddress.setObjectId(restaurantModel.getId());
        innerAddress.setObjectType("REST");
        restaurantModel.setAddress(innerAddress);
        return restaurantModel;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<RestaurantModel> update(@RequestBody RestaurantModel restaurantModel) {
        if (restaurantModel.getAddress() != null) {
            restaurantModel = setAddressObjectIdAndType(restaurantModel);
        }

        return updateEntity(restaurantRepository, restaurantModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        deleteEntity(restaurantRepository, id);
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
