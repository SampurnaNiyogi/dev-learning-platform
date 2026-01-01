import React from 'react';

const TaskDescription = ({ task }) => {
    return (
        <div className="task-description">
            <div className="task-header">
                <h1>{task.title}</h1>
                <span className={`difficulty ${task.difficulty.toLowerCase()}`}>
          {task.difficulty}
        </span>
            </div>

            <div className="task-meta">
                <strong>Concepts:</strong> {task.concepts.join(', ')}
            </div>

            <section className="task-section">
                <h2>Context</h2>
                <p>{task.context}</p>
            </section>

            <section className="task-section constraints">
                <h2>Constraints</h2>
                <ul>
                    {task.constraints.map((constraint, idx) => (
                        <li key={idx} className={constraint.allowed ? 'allowed' : 'forbidden'}>
                            <span className="icon">{constraint.allowed ? '✅' : '❌'}</span>
                            {constraint.text}
                        </li>
                    ))}
                </ul>
            </section>

            <section className="task-section docs">
                <h2>Documentation</h2>
                <ul>
                    {task.docs.map((doc, idx) => (
                        <li key={idx}>
                            <a href={doc.url} target="_blank" rel="noopener noreferrer">
                                {doc.title}
                            </a>
                        </li>
                    ))}
                </ul>
            </section>
        </div>
    );
};
export default TaskDescription;
