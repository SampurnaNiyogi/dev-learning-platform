import React, { useState } from 'react';

const ExplanationForm = ({ onSubmit, isSubmitting }) => {
    const [answers, setAnswers] = useState({
        q1: '',
        q2: '',
        q3: ''
    });

    const questions = [
        'Why are we mocking the repository?',
        'Why should we avoid @SpringBootTest here?',
        'What does this test NOT verify?'
    ];

    const handleSubmit = () => {
        const allAnswered = Object.values(answers).every(a => a.trim().length > 0);
        if (!allAnswered) {
            alert('Please answer all questions before submitting.');
            return;
        }
        onSubmit(answers);
    };

    return (
        <div className="explanation-form">
            <h2>Explanation Required</h2>
            <p className="explanation-intro">
                Answer these questions to complete the task:
            </p>

            {questions.map((question, idx) => (
                <div key={idx} className="question-block">
                    <label>{idx + 1}. {question}</label>
                    <textarea
                        value={answers[`q${idx + 1}`]}
                        onChange={(e) => setAnswers({...answers, [`q${idx + 1}`]: e.target.value})}
                        placeholder="Type your answer here..."
                        rows="4"
                    />
                </div>
            ))}

            <button
                className="submit-button"
                onClick={handleSubmit}
                disabled={isSubmitting}
            >
                {isSubmitting ? 'Submitting...' : 'Submit Explanation'}
            </button>
        </div>
    );
};
export default ExplanationForm;

