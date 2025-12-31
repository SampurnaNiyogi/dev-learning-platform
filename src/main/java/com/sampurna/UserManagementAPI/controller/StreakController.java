package com.sampurna.UserManagementAPI.controller;

import com.sampurna.UserManagementAPI.dto.UserStreakResponse;
import com.sampurna.UserManagementAPI.service.StreakService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreakController {
    private final StreakService streakService;

    public StreakController(StreakService streakService){
        this.streakService = streakService;
    }

    @GetMapping("/streak/user/{userId}")
    public UserStreakResponse getUserStreak(@PathVariable Long userId){
        return streakService.getUserStreak(userId);
    }
}
