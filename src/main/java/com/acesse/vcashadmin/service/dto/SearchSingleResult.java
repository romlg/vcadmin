package com.acesse.vcashadmin.service.dto;

/**
 * Created by Vadim_Korostelev on 6/14/2016.
 */
public class SearchSingleResult<T> {
    public T searchResults;

    public T getSearchResult() {
        return searchResults;
    }

    public void setSearchResults(T searchResults) {
        this.searchResults = searchResults;
    }
}
