package com.narendra.entity;

import java.util.ArrayList;
import java.util.List;

public class Answer extends Post implements Commentable, Votable{

    private boolean isAccepted;
    private final List<Vote> votes;
    private final List<Comment> comments;

    public Answer(String text, User author) {
        super(text, author);
        this.votes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void makeAccepted() {
        this.isAccepted = true;
    }

    public boolean isAccepted() {
        return isAccepted;
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
