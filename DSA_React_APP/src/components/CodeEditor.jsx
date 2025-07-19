import React from 'react';
import MonacoEditor from '@monaco-editor/react';

const CodeEditor = ({
  value,
  onChange,
  language = 'javascript',
  height = '100%',
  width = '100%',
  options = {},
}) => {
  const handleEditorChange = (value) => {
    if (onChange) onChange(value);
  };

  const handleEditorError = (error) => {
    return (
      <div className="alert alert-error">
        <span>Failed to load code editor: {error?.message || 'Unknown error'}</span>
      </div>
    );
  };

  return (
    <div className="w-full h-full">
      <MonacoEditor
        height={height}
        width={width}
        language={language}
        value={value}
        onChange={handleEditorChange}
        options={{
          fontSize: 14,
          minimap: { enabled: false },
          scrollBeyondLastLine: false,
          automaticLayout: true,
          theme: "vs-dark",
          ...options,
        }}
        loading={
          <div className="flex items-center justify-center h-full">
            <span className="loading loading-spinner loading-md"></span>
          </div>
        }
        onError={handleEditorError}
      />
    </div>
  );
};

export default CodeEditor;
