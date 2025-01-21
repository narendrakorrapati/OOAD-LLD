package com.narendra;

import com.narendra.entity.*;
import com.narendra.search.impl.KeywordBasedSearchCriteria;

import java.util.Arrays;
import java.util.List;

public class StackOverflowSimulator {
    public static void main(String[] args) {
        StackOverflow stackOverflow = new StackOverflow();

        User narendra = new User("narendra");
        User john = new User("john");
        stackOverflow.addUser(narendra);
        stackOverflow.addUser(john);

        Question question1 = new Question("What is java?", narendra, Arrays.asList(new Tag("Java"), new Tag("Programming")));
        Question question2 = new Question("What is Python?", narendra, Arrays.asList(new Tag("Python"), new Tag("Programming")));

        stackOverflow.postQuestion(question1);
        stackOverflow.postQuestion(question2);

        List<Question> questions = stackOverflow.search(new KeywordBasedSearchCriteria("java"));
        Question javaQuestion = questions.get(0);

        stackOverflow.answerQuestion(javaQuestion, new Answer("Java is an OOP Language", john));

        System.out.println(narendra);
        System.out.println(john);
    }
}
