package com.cr.coffee.models;

import com.cr.coffee.utils.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RestaurantSpecification implements Specification<RestaurantModel> {
    private SearchCriteria criteria;

    public RestaurantSpecification() {}

    public RestaurantSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<RestaurantModel> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        String operation = criteria.getOperation();

        if (operation.equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(root.<String> get(criteria.getKey()), criteria.getValue().toString());
        } else if (operation.equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(root.<String> get(criteria.getKey()), criteria.getValue().toString());
        } else if (operation.equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(root.<String> get(criteria.getKey()),"%" + criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }

        return null;

    }

}
