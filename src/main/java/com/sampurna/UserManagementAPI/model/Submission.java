package com.sampurna.UserManagementAPI.model;

import java.time.LocalDateTime;

public class Submission {
    private Long id;
    private Long userId;
    private Long problemId;
    private String language;
    private String code;
    private SubmissionStatus status;
    private LocalDateTime submittedAt;

    public Submission( Long id,Long userId, Long problemId, String language, String code, SubmissionStatus status) {
        this.id = id;
        this.userId = userId;
        this.problemId = problemId;
        this.language = language;
        this.code = code;
        this.status = status;
        this.submittedAt = LocalDateTime.now();
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
    public String getCode() {
        return code;
    }
    public SubmissionStatus getStatus() {
        return status;
    }
    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

}
