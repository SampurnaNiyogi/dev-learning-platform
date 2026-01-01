import { useState } from 'react';
import HomePage from './pages/HomePage';
import RoadmapPage from './pages/RoadmapPage';
import TaskPage from './pages/TaskPage';
import ProfilePage from './pages/ProfilePage';

export default function App() {
    const [currentPage, setCurrentPage] = useState('home');
    const [selectedFramework, setSelectedFramework] = useState(null);
    const [selectedTask, setSelectedTask] = useState(null);

    const handleNavigate = (page, data) => {
        setCurrentPage(page);
        if (page === 'roadmap') setSelectedFramework(data);
        if (page === 'task') setSelectedTask(data);
    };

    const handleBack = () => {
        if (currentPage === 'task') setCurrentPage('roadmap');
        else setCurrentPage('home');
    };

    return (
        <div className="app">
            <header className="app-header">
                <h1 onClick={() => setCurrentPage('home')}>
                    Backend Learning Platform
                </h1>

                <nav>
                    <span onClick={() => setCurrentPage('home')}>Frameworks</span>
                    <span onClick={() => setCurrentPage('profile')}>Profile</span>
                </nav>
            </header>

            <main className="app-main">
                {currentPage === 'home' && <HomePage onNavigate={handleNavigate} />}
                {currentPage === 'roadmap' && (
                    <RoadmapPage
                        framework={selectedFramework}
                        onNavigate={handleNavigate}
                        onBack={handleBack}
                    />
                )}
                {currentPage === 'task' && <TaskPage onBack={handleBack} />}
                {currentPage === 'profile' && <ProfilePage />}
            </main>
        </div>
    );
}
