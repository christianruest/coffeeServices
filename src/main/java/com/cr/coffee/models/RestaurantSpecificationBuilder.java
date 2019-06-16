package com.cr.coffee.models;

import com.cr.coffee.utils.SearchCriteria;
import com.cr.coffee.utils.SearchCriteriaContainer;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantSpecificationBuilder {
    private final List<SearchCriteria> searchCriteriaList;

    public RestaurantSpecificationBuilder() {
        searchCriteriaList = new ArrayList<>();
    }

    public RestaurantSpecificationBuilder(List<SearchCriteria> searchCriterias) {
        this.searchCriteriaList = searchCriterias;
    }


    public RestaurantSpecificationBuilder with(SearchCriteria searchCriteria) {
        searchCriteriaList.add(new SearchCriteria(searchCriteria.getKey(), searchCriteria.getOperation(), searchCriteria.getValue()));
        return this;
    }

    public Specification<RestaurantModel> build() {
        if (searchCriteriaList.size() == 0) {
            return null;
        }

        List<Specification> specs = searchCriteriaList.stream()
                .map(RestaurantSpecification::new)
                .collect(Collectors.toList());

        Specification result = specs.get(0);

        for(int i = 1; i < specs.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }

        return result;
    }

}
