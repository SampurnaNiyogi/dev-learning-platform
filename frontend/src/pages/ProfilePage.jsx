import React from 'react';

const ProfilePage = ({ onBack }) => {
    const stats = {
        totalCompleted: 3,
        currentStreak: 3,
        longestStreak: 5,
        totalTasks: 10
    };

    const recentActivity = [
        { day: 3, title: 'REST Controllers', date: '2025-01-01', score: 95 },
        { day: 2, title: 'Dependency Injection', date: '2024-12-31', score: 88 },
        { day: 1, title: 'Spring Boot Basics', date: '2024-12-30', score: 92 }
    ];

    return (
        <div className="profile-page">
            <button className="back-button" onClick={onBack}>← Back to Home</button>

            <div className="profile-header">
                <div className="profile-avatar">👤</div>
                <div>
                    <h1>Your Progress</h1>
                    <p>Track your learning journey</p>
                </div>
            </div>

            <div className="stats-grid">
                <div className="stat-card">
                    <div className="stat-value">{stats.totalCompleted}/{stats.totalTasks}</div>
                    <div className="stat-label">Tasks Completed</div>
                </div>
                <div className="stat-card">
                    <div className="stat-value">{stats.currentStreak} 🔥</div>
                    <div className="stat-label">Current Streak</div>
                </div>
                <div className="stat-card">
                    <div className="stat-value">{stats.longestStreak}</div>
                    <div className="stat-label">Longest Streak</div>
                </div>
                <div className="stat-card">
                    <div className="stat-value">{Math.round((stats.totalCompleted / stats.totalTasks) * 100)}%</div>
                    <div className="stat-label">Progress</div>
                </div>
            </div>

            <div className="recent-activity">
                <h2>Recent Activity</h2>
                <div className="activity-list">
                    {recentActivity.map((activity, idx) => (
                        <div key={idx} className="activity-item">
                            <div className="activity-left">
                                <div className="activity-day">Day {activity.day}</div>
                                <div>
                                    <h4>{activity.title}</h4>
                                    <span className="activity-date">{activity.date}</span>
                                </div>
                            </div>
                            <div className="activity-score">{activity.score}%</div>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
};
export default ProfilePage;
