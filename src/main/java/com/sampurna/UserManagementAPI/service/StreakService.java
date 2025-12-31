package com.sampurna.UserManagementAPI.service;

import com.sampurna.UserManagementAPI.dto.SubmissionResponse;
import com.sampurna.UserManagementAPI.dto.UserStreakResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StreakService {
    private final UserService userService;
    private final SubmissionService submissionService;
    public StreakService(UserService userService, SubmissionService submissionService) {
        this.userService = userService;
        this.submissionService = submissionService;
    }

    public UserStreakResponse getUserStreak(Long userId) {
        userService.getUserById(userId);
        List<SubmissionResponse> submissions = submissionService.getSubmissionsByUser(userId);
        int currentStreak = 0;
        LocalDate lastActiveDate = null;
        if (submissions.isEmpty()) {
            return new UserStreakResponse(userId, currentStreak,lastActiveDate);
        }

        // Submission Exists
        Set<LocalDate> activeDates = new HashSet<>();
        for (SubmissionResponse submission : submissions) {
            activeDates.add(submission.getSubmittedAt().toLocalDate());
        }
        LocalDate today = LocalDate.now();
        LocalDate startDate;

        if (activeDates.contains(today)){
            startDate = today;
        } else if (activeDates.contains(today.minusDays(1))) {
            startDate = today.minusDays(1);
        }
        else {
            // no streak
            return new UserStreakResponse(userId, 0, null);
        }
        int streak = 0;
        LocalDate currentDate = startDate;
        while (activeDates.contains(currentDate)) {
            streak++;
            currentDate = currentDate.minusDays(1);
        }
        return new UserStreakResponse(userId, streak, startDate);
    }
}
