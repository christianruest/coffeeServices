package com.cr.coffee;

//import static org.assertj.core.api.Assertions.assertThat;

import com.cr.coffee.models.restaurant.RestaurantModel;
import com.cr.coffee.models.restaurant.RestaurantSpecification;
import com.cr.coffee.utils.SearchCriteria;
import com.cr.coffee.repositories.RestaurantRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIn.isIn;
import static org.hamcrest.core.IsNot.not;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
//@Transactional
public class RestaurantSpecificationTest {

    @Autowired
    private RestaurantRepository repository;

    private RestaurantModel restaurantHinicht;
    private RestaurantModel restaurantNachbar;

    @Before
    public void init() {
        restaurantHinicht = new RestaurantModel();
//        restaurantHinicht.setAddress("Dornacherstrasse 12");
//        restaurantHinicht.setCity("Grindelwald");
        restaurantHinicht.setName("Hinicht");
        restaurantHinicht.setPhoneNumber("0411234567");
//        restaurantHinicht.setZipCode(6003);
        repository.save(restaurantHinicht);

        restaurantNachbar = new RestaurantModel();
//        restaurantNachbar.setAddress("Obergrundstrasse 29");
//        restaurantNachbar.setCity("Luzern");
        restaurantNachbar.setName("Nachbar");
        restaurantNachbar.setPhoneNumber("0411239876");
//        restaurantNachbar.setZipCode(6003);
        repository.save(restaurantNachbar);
    }

    @Test
    public void givenCityReturnsListOfRestaurants() {
        RestaurantSpecification specification1 = new RestaurantSpecification(
                new SearchCriteria("city",":","Grindelwald")
        );

        RestaurantSpecification specification2 = new RestaurantSpecification(
                new SearchCriteria("zipCode",":","6003")
        );

        List<Specification> specs = new ArrayList<>();

        List<RestaurantModel> results = repository.findAll(Specification.where(specification1).and(specification2));

        assertThat(restaurantHinicht, isIn(results));
        assertThat(restaurantNachbar, not(isIn(results)));

    }


}
