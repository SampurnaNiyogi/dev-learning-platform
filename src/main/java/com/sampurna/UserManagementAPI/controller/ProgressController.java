package com.sampurna.UserManagementAPI.controller;

import com.sampurna.UserManagementAPI.dto.UserProgressResponse;
import com.sampurna.UserManagementAPI.service.ProgressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping("/progress/user/{userId}")
    public UserProgressResponse getUserProgress(@PathVariable Long userId) {
        return progressService.getUserProgress(userId);
    }
}
