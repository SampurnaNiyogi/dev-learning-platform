package com.sampurna.UserManagementAPI.dto;

import com.sampurna.UserManagementAPI.model.Difficulty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Used to send post request to create new problem
public class CreateProblemRequest {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Difficulty difficulty;

    //No arg constructor(Will be handled by spring)
    public CreateProblemRequest(){}

    //getters and setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Difficulty getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
