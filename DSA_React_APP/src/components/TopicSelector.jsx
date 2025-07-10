import React, { useEffect, useRef } from "react";

export default function TopicSelector({ topics, selectedTopic, onSelectTopic }) {
  const topicRefs = useRef([]);

  useEffect(() => {
    const idx = topics.indexOf(selectedTopic);
    if (topicRefs.current[idx]) {
      topicRefs.current[idx].scrollIntoView({ behavior: "smooth", block: "center" });
    }
  }, [selectedTopic, topics]);

  return (
    <div className="flex flex-col bg-gray-100 w-[200px] overflow-hidden border-r border-gray-300">
      <div className="p-4 border-b border-gray-300 bg-gray-200">
        <h2 className="font-bold text-lg">Topics</h2>
      </div>
      <div className="flex-1 overflow-y-auto p-2">
        {topics.map((topic, idx) => (
          <button
            key={topic}
            ref={el => topicRefs.current[idx] = el}
            className={`w-full text-left px-3 py-2 mb-1 rounded hover:bg-blue-200 transition-colors ${selectedTopic === topic ? "bg-blue-500 text-white ring-2 ring-blue-700" : "bg-white"}`}
            onClick={() => onSelectTopic(topic)}
          >
            {topic.charAt(0).toUpperCase() + topic.slice(1)}
          </button>
        ))}
      </div>
    </div>
  );
}