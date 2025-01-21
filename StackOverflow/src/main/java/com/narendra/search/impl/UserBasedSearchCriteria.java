package com.narendra.search.impl;

import com.narendra.entity.Question;
import com.narendra.entity.User;
import com.narendra.search.SearchCriteria;

public class UserBasedSearchCriteria implements SearchCriteria {
    private final User user;
    public UserBasedSearchCriteria(User user) {
        this.user = user;
    }

    @Override
    public boolean matches(Question question) {
        return question.getAuthor().equals(user);
    }
}
