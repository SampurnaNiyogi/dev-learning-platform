import React, { useState } from 'react';
import backend from '../api/backend';

import TaskDescription from '../components/TaskDescription';
import CodeEditor from '../components/CodeEditor';
import ServerResponse from '../components/ServerResponse';
import ExplanationForm from '../components/ExplanationForm';

const TaskPage = ({ onBack }) => {
    const [code, setCode] = useState('');
    const [response, setResponse] = useState(null);
    const [showExplanation, setShowExplanation] = useState(false);
    const [isLoading, setIsLoading] = useState(false);
    const [isSubmitting, setIsSubmitting] = useState(false);
    const [completed, setCompleted] = useState(false);

    const task = {
        id: 'day10',
        title: 'DAY 10 — Testing Fundamentals',
        difficulty: 'Medium',
        concepts: ['Unit Testing', 'Mocking', 'Service Logic'],
        context: 'In production systems, service logic often depends on repositories, external APIs, or other services. Testing service logic without spinning up the full Spring context is crucial for fast, isolated unit tests. This task focuses on testing a service method using mocks, ensuring that the logic itself is correct without involving databases or the Spring container.',
        constraints: [
            { text: 'No @SpringBootTest', allowed: false },
            { text: 'No database', allowed: false },
            { text: 'No application startup', allowed: false },
            { text: 'Use mocks only', allowed: true }
        ],
        docs: [
            { title: 'JUnit 5 Official Documentation', url: 'https://junit.org/junit5/docs/current/user-guide/' },
            { title: 'Mockito Official Documentation', url: 'https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html' }
        ]
    };

    const handleRunTask = async () => {
        setIsLoading(true);
        const result = await backend.runTask(code);
        setResponse(result);
        setIsLoading(false);

        if (result.success) {
            setShowExplanation(true);
        }
    };

    const handleSubmitExplanation = async (answers) => {
        setIsSubmitting(true);
        const result = await backend.submitExplanation(task.id, answers);
        setIsSubmitting(false);

        if (result.success) {
            setCompleted(true);
            alert('Task completed successfully! 🎉');
        }
    };

    return (
        <div className="task-page">
            <button className="back-button" onClick={onBack}>← Back to Roadmap</button>

            <div className="task-split-view">
                {/* LEFT SIDE - Description */}
                <div className="task-left-panel">
                    <TaskDescription task={task} />
                </div>

                {/* RIGHT SIDE - Code Editor and Response */}
                <div className="task-right-panel">
                    <CodeEditor value={code} onChange={setCode} />
                    <ServerResponse
                        response={response}
                        onRun={handleRunTask}
                        isLoading={isLoading}
                    />
                </div>
            </div>

            {/* Explanation Section - Full Width Below */}
            {showExplanation && !completed && (
                <div className="explanation-section">
                    <ExplanationForm
                        onSubmit={handleSubmitExplanation}
                        isSubmitting={isSubmitting}
                    />
                </div>
            )}

            {completed && (
                <div className="completion-message">
                    <h2>✅ Task Completed!</h2>
                    <p>Great work! You've successfully completed Day 10.</p>
                </div>
            )}
        </div>
    );
};
export default TaskPage;
