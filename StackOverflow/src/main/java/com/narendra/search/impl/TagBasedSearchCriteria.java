package com.narendra.search.impl;

import com.narendra.entity.Question;
import com.narendra.entity.Tag;
import com.narendra.search.SearchCriteria;

import java.util.HashSet;
import java.util.List;

public class TagBasedSearchCriteria implements SearchCriteria {

    private final List<Tag> tags;
    public TagBasedSearchCriteria(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean matches(Question question) {
        return new HashSet<>(question.getTags()).containsAll(tags);
    }
}
