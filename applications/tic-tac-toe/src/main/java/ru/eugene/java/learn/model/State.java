package ru.eugene.java.learn.model;

public enum State {
    WIN, DRAW, NOT_FINISH, ERROR;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
