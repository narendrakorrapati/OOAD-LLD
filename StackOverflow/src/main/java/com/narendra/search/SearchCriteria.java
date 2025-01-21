package com.narendra.search;

import com.narendra.entity.Question;

public interface SearchCriteria {
    boolean matches(Question question);
}
