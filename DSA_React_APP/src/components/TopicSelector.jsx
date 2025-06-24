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
    <div className="flex flex-col gap-2 p-4 bg-gray-100 h-full min-w-[180px] overflow-y-auto">
      <h2 className="font-bold text-lg mb-2">Topics</h2>
      {topics.map((topic, idx) => (
        <button
          key={topic}
          ref={el => topicRefs.current[idx] = el}
          className={`text-left px-3 py-2 rounded hover:bg-blue-200 transition-colors ${selectedTopic === topic ? "bg-blue-500 text-white ring-2 ring-blue-700" : "bg-white"}`}
          onClick={() => onSelectTopic(topic)}
        >
          {topic.charAt(0).toUpperCase() + topic.slice(1)}
        </button>
      ))}
    </div>
  );
}