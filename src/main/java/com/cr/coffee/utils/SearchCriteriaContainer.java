package com.cr.coffee.utils;

import java.util.ArrayList;
import java.util.List;

public class SearchCriteriaContainer {
    private List<SearchCriteria> searchCriteria = new ArrayList<>();

    public List<SearchCriteria> getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(List<SearchCriteria> searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

}
