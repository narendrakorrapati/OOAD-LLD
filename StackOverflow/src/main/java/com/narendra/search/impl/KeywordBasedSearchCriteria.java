package com.narendra.search.impl;

import com.narendra.entity.Question;
import com.narendra.search.SearchCriteria;

public class KeywordBasedSearchCriteria implements SearchCriteria {

    private final String keyword;

    public KeywordBasedSearchCriteria(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean matches(Question question) {
        return question.getText().toLowerCase().contains(keyword.toLowerCase());
    }
}
