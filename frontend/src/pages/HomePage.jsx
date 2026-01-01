import React from 'react';

const HomePage = ({ onNavigate }) => {
    const frameworks = [
        {
            id: 'spring',
            name: 'Spring Boot',
            description: 'Master backend development with Spring Framework',
            topics: 15,
            icon: '🍃'
        },
        {
            id: 'django',
            name: 'Django',
            description: 'Build robust backends with Python Django',
            topics: 12,
            icon: '🐍'
        },
        {
            id: 'express',
            name: 'Express.js',
            description: 'Learn Node.js backend development',
            topics: 10,
            icon: '⚡'
        },
        {
            id: 'fastapi',
            name: 'FastAPI',
            description: 'Modern async Python web framework',
            topics: 8,
            icon: '🚀'
        }
    ];

    return (
        <div className="home-page">
            <div className="hero-section">
                <h1>Backend Learning Platform</h1>
                <p>Master backend reasoning through hands-on practice</p>
            </div>

            <div className="frameworks-grid">
                {frameworks.map(framework => (
                    <div
                        key={framework.id}
                        className="framework-card"
                        onClick={() => onNavigate('roadmap', framework)}
                    >
                        <div className="framework-icon">{framework.icon}</div>
                        <h3>{framework.name}</h3>
                        <p>{framework.description}</p>
                        <div className="framework-meta">
                            <span>{framework.topics} Topics</span>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};
export default HomePage;

