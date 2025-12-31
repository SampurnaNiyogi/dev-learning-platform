package com.sampurna.UserManagementAPI.service;

import com.sampurna.UserManagementAPI.dto.SubmissionResponse;
import com.sampurna.UserManagementAPI.dto.UserProgressResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProgressService {
    private final UserService userService;
    private final SubmissionService submissionService;
    public ProgressService(UserService userService, SubmissionService submissionService) {
        this.userService = userService;
        this.submissionService = submissionService;
    }
    public UserProgressResponse getUserProgress(Long userId){
        userService.getUserById(userId);
        List<SubmissionResponse>  submissionResponses = submissionService.getSubmissionsByUser(userId);
        int uniqueProblemsAttempted;
        int totalSubmissions = submissionResponses.size();
        LocalDate lastSubmissionDate = null;

        // Set stores unique values
        Set<Long> uniqueProblemsSet = new HashSet<>();
        for (SubmissionResponse submission : submissionResponses) {
            uniqueProblemsSet.add(submission.getProblemId());
        }
        uniqueProblemsAttempted = uniqueProblemsSet.size();

        for  (SubmissionResponse submission : submissionResponses) {
            LocalDate submissionDate = submission.getSubmittedAt().toLocalDate();
            if (lastSubmissionDate == null || submissionDate.isAfter(lastSubmissionDate)) {
                lastSubmissionDate = submissionDate;
            }
        }

        return new UserProgressResponse(userId,totalSubmissions,uniqueProblemsAttempted, lastSubmissionDate);
    }
}
