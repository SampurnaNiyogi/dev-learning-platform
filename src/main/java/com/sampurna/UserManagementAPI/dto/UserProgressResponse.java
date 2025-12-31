package com.sampurna.UserManagementAPI.dto;

import java.time.LocalDate;

public class UserProgressResponse {
    private final Long userId;
    private final int totalSubmissions;
    private final int uniqueProblemsAttempted;
    private final LocalDate lastSubmissionDate;

    public UserProgressResponse(Long userId, int totalSubmissions, int uniqueProblemsAttempted, LocalDate lastSubmissionDate) {
        this.userId = userId;
        this.totalSubmissions = totalSubmissions;
        this.uniqueProblemsAttempted = uniqueProblemsAttempted;
        this.lastSubmissionDate = lastSubmissionDate;
    }
    public Long getUserId(){
        return userId;
    }
    public int getTotalSubmissions(){
        return totalSubmissions;
    }
    public int getUniqueProblemsAttempted(){
        return uniqueProblemsAttempted;
    }
    public LocalDate getLastSubmissionDate(){
        return lastSubmissionDate;
    }

}
