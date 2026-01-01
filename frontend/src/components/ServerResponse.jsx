import React from 'react';

const ServerResponse = ({ response, onRun, isLoading }) => {
    return (
        <div className="server-response">
            <div className="response-header">
                <span>Server Response</span>
                <button
                    className="run-button"
                    onClick={onRun}
                    disabled={isLoading}
                >
                    {isLoading ? 'Running...' : 'Run Task'}
                </button>
            </div>
            <div className="response-content">
                {response ? (
                    <div className={`response-message ${response.success ? 'success' : 'error'}`}>
                        {response.message}
                    </div>
                ) : (
                    <div className="response-placeholder">
                        Click "Run Task" to see results
                    </div>
                )}
            </div>
        </div>
    );
};
export default ServerResponse;
