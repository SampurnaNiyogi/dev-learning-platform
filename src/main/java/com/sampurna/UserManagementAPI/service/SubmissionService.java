package com.sampurna.UserManagementAPI.service;

import com.sampurna.UserManagementAPI.dto.*;
import com.sampurna.UserManagementAPI.model.Submission;
import com.sampurna.UserManagementAPI.model.SubmissionStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubmissionService {
    private Long submissionId = 0L;
    private final ProblemService problemService;
    private final UserService userService;
    public SubmissionService(ProblemService problemService, UserService userService) {
        this.problemService = problemService;
        this.userService = userService;
    }

    private final Map<Long, Submission> submissions = new HashMap<>();


    public SubmissionResponse submitSolution(CreateSubmissionRequest request){
        userService.getUserById(request.getUserId());
        problemService.getProblemById(request.getProblemId());
        submissionId++;
        Submission submission = new Submission(submissionId, request.getUserId(), request.getProblemId(), request.getLanguage(), request.getCode(), SubmissionStatus.SUBMITTED);
        submissions.put(submission.getId(), submission);
        return new SubmissionResponse(submission.getId(),submission.getUserId(),submission.getProblemId(),submission.getLanguage(), submission.getStatus(), submission.getSubmittedAt());
    }

    public List<SubmissionResponse> getSubmissionsByUser(Long userId){
        userService.getUserById(userId);
        List<SubmissionResponse> submissionResponseList = new ArrayList<>();
        for (Submission submission : submissions.values()){
            if (submission.getUserId().equals(userId)){
                submissionResponseList.add(new SubmissionResponse(submission.getId(),submission.getUserId(),submission.getProblemId(), submission.getLanguage(), submission.getStatus(),submission.getSubmittedAt()));
            }
        }
        return submissionResponseList;
    }

}
