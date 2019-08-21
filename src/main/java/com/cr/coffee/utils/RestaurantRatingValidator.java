package com.cr.coffee.utils;


import com.cr.coffee.models.restaurant.RestaurantRatingModel;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class RestaurantRatingValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return RestaurantRatingValidator.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        RestaurantRatingModel restRating = (RestaurantRatingModel) obj;
        if(checkInputString(restRating.getRestaurantId().toString())) {
            errors.rejectValue("restaurantId", "restaurantId.emtpy");
        }


    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }

    private boolean checkInputLong(Long input) {
        return (input == null);
    }

}
