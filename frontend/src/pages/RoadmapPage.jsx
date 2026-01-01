import React from 'react';

const RoadmapPage = ({ framework, onNavigate, onBack }) => {
    const roadmap = [
        { day: 1, title: 'Spring Boot Basics', difficulty: 'Easy', completed: true },
        { day: 2, title: 'Dependency Injection', difficulty: 'Easy', completed: true },
        { day: 3, title: 'REST Controllers', difficulty: 'Medium', completed: true },
        { day: 4, title: 'Service Layer Design', difficulty: 'Medium', completed: false },
        { day: 5, title: 'Exception Handling', difficulty: 'Medium', completed: false },
        { day: 6, title: 'Data Validation', difficulty: 'Medium', completed: false },
        { day: 7, title: 'JPA Relationships', difficulty: 'Hard', completed: false },
        { day: 8, title: 'Transaction Management', difficulty: 'Hard', completed: false },
        { day: 9, title: 'Spring Security Basics', difficulty: 'Hard', completed: false },
        { day: 10, title: 'Testing Fundamentals', difficulty: 'Medium', completed: false },
    ];

    return (
        <div className="roadmap-page">
            <button className="back-button" onClick={onBack}>← Back to Frameworks</button>

            <div className="roadmap-header">
                <h1>{framework.name} Roadmap</h1>
                <p>Complete tasks day by day to master backend concepts</p>
            </div>

            <div className="roadmap-list">
                {roadmap.map(task => (
                    <div
                        key={task.day}
                        className={`roadmap-item ${task.completed ? 'completed' : ''}`}
                        onClick={() => onNavigate('task', task)}
                    >
                        <div className="roadmap-item-left">
                            <div className="day-badge">Day {task.day}</div>
                            <div className="task-info">
                                <h3>{task.title}</h3>
                                <span className={`difficulty ${task.difficulty.toLowerCase()}`}>
                  {task.difficulty}
                </span>
                            </div>
                        </div>
                        <div className="roadmap-item-right">
                            {task.completed ? (
                                <span className="status-badge completed">✓ Completed</span>
                            ) : (
                                <span className="status-badge pending">Start →</span>
                            )}
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default RoadmapPage;
