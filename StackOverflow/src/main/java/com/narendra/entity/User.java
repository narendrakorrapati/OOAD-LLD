package com.narendra.entity;

import java.util.Objects;

public class User {
    private final String username;
    private int reputationScore;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void updateReputationScore(int score) {
        this.reputationScore += score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getUsername(), user.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", reputationScore=" + reputationScore +
                '}';
    }
}
