package com.acesse.vcashadmin.service.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 12.06.16
 * Time: 18:28
 */
public class SearchListResult<T> {
    public List<T> searchResults;

    public List<T> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<T> searchResults) {
        this.searchResults = searchResults;
    }

    public SearchListResult(T... dtos) {
        this.searchResults = new ArrayList<>();
        searchResults.addAll(Arrays.asList(dtos));

    }

    public SearchListResult() {
    }
}
