package com.narendra;

import com.narendra.entity.*;
import com.narendra.search.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Revisit this again and fix reputation score calculation to follow SOLID principles
 */
public class StackOverflow {
    private static final int QUESTION_SCORE = 5;
    private static final int COMMENT_SCORE = 3;
    private static final int ANSWER_SCORE = 10;
    private final List<User> users;
    private final List<Question> questions;

    public StackOverflow() {
        this.users = new ArrayList<>();
        this.questions = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void postQuestion(Question question) {
        questions.add(question);
        question.getAuthor().updateReputationScore(QUESTION_SCORE);
    }

    public void answerQuestion(Question question, Answer answer) {
        question.addAnswer(answer);
        answer.getAuthor().updateReputationScore(ANSWER_SCORE);
    }

    public void comment(Commentable commentable, Comment comment) {
        commentable.addComment(comment);
        comment.getAuthor().updateReputationScore(COMMENT_SCORE);
    }

    public void vote(Votable votable, Vote vote) {
        votable.addVote(vote);
    }

    public List<Question> search(SearchCriteria searchCriteria) {
        return questions.stream().filter(searchCriteria::matches).collect(Collectors.toList());
    }
}
