package com.sampurna.UserManagementAPI.dto;

import java.time.LocalDate;

public class UserStreakResponse {
    private final Long userId;
    private final int currentStreak;
    private final LocalDate lastActiveDate;

    public UserStreakResponse(Long userId, int currentStreak, LocalDate lastActiveDate) {
        this.userId = userId;
        this.currentStreak = currentStreak;
        this.lastActiveDate = lastActiveDate;
    }

    public Long getUserId() {
        return userId;
    }
    public int getCurrentStreak() {
        return currentStreak;
    }
    public LocalDate getLastActiveDate() {
        return lastActiveDate;
    }
}
