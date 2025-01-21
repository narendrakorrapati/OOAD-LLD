package com.narendra.entity;

import java.util.ArrayList;
import java.util.List;

public class Question extends Post implements Commentable, Votable{
    private final List<Tag> tags;
    private final List<Answer> answers;
    private final List<Vote> votes;
    private final List<Comment> comments;

    public Question(String text, User author, List<Tag> tags) {
        super(text, author);
        this.tags = tags;
        this.answers = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public List<Tag> getTags() {
        return tags;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void addVote(Vote vote) {
        votes.add(vote);
    }

    @Override
    public List<Vote> getVotes() {
        return votes;
    }
}
