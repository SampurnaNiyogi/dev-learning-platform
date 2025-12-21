package com.sampurna.UserManagementAPI.model;

public class Problem {
    private Long id;
    private String title;
    private String description;
    private Difficulty  difficulty;

    //Constructor
    public Problem(Long id, String title, String description, Difficulty difficulty) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
    }
    //Getters
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return  title;
    }
    public String getDescription() {
        return  description;
    }
    public Difficulty getDifficulty() {
        return  difficulty;
    }
}
