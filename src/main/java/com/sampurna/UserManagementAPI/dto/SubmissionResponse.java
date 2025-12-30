package com.sampurna.UserManagementAPI.dto;

import com.sampurna.UserManagementAPI.model.SubmissionStatus;

import java.time.LocalDateTime;

public class SubmissionResponse {
    private Long id;
    private  Long userId;
    private Long problemId;
    private String language;
    private SubmissionStatus status;
    private LocalDateTime submittedAt;

    public SubmissionResponse(Long id, Long userId, Long problemId, String language, SubmissionStatus status, LocalDateTime submittedAt) {
        this.id = id;
        this.userId = userId;
        this.problemId = problemId;
        this.language = language;
        this.status = status;
        this.submittedAt = submittedAt;
    }
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }
    public Long getProblemId() {
        return problemId;
    }
    public String getLanguage() {
        return language;
    }
    public SubmissionStatus getStatus() {
        return status;
    }
    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }
}
