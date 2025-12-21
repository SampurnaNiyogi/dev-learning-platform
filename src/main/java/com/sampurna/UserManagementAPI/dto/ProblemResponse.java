package com.sampurna.UserManagementAPI.dto;

import com.sampurna.UserManagementAPI.model.Difficulty;

public class ProblemResponse {
    private Long id;
    private String title;
    private String description;
    private Difficulty difficulty;

    public ProblemResponse(Long id, String title, String description, Difficulty difficulty) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public Difficulty getDifficulty() {
        return difficulty;
    }
}
