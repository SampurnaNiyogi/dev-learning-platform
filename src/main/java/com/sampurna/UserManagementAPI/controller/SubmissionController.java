package com.sampurna.UserManagementAPI.controller;

import com.sampurna.UserManagementAPI.dto.CreateSubmissionRequest;
import com.sampurna.UserManagementAPI.dto.SubmissionResponse;
import com.sampurna.UserManagementAPI.service.SubmissionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubmissionController {
    // Injecting method
    private final SubmissionService submissionService;
    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping("/submissions")
    public SubmissionResponse createSubmission(@Valid @RequestBody CreateSubmissionRequest createSubmissionRequest) {
        return submissionService.submitSolution(createSubmissionRequest);
    }

    @GetMapping("/submissions/user/{userId}")
    public List<SubmissionResponse> getSubmissionByUserId(@PathVariable Long userId) {
        return submissionService.getSubmissionsByUser(userId);
    }
}
