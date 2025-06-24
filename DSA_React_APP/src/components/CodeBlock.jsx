import React from "react";

export default function CodeBlock({ code }) {
  return (
    <pre className="bg-gray-900 text-green-200 rounded p-4 overflow-x-auto text-sm">
      <code>{code}</code>
    </pre>
  );
} 