package com.narendra.entity;

import java.util.List;

public interface Votable {
    void addVote(Vote vote);
    List<Vote> getVotes();
}
