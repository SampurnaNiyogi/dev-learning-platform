import React from 'react';

const CodeEditor = ({ value, onChange }) => {
    return (
        <div className="code-editor">
            <div className="editor-header">
                <span>Code Editor</span>
            </div>
            <textarea
                className="code-textarea"
                placeholder="Paste your code here (optional)..."
                value={value}
                onChange={(e) => onChange(e.target.value)}
            />
        </div>
    );
};
export default CodeEditor;

