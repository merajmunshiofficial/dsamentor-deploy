import React, { useState, useEffect } from "react";
import TopicSelector from "./components/TopicSelector";
import ProblemList from "./components/ProblemList";
import ProblemDetails from "./components/ProblemDetails";
import InputForm from "./components/InputForm";
import OutputPanel from "./components/OutputPanel";

export default function App() {
  const [topics, setTopics] = useState([]);
  const [problemsByTopic, setProblemsByTopic] = useState({});
  const [selectedTopic, setSelectedTopic] = useState(() => localStorage.getItem("lastSelectedTopic") || "");
  const [selectedProblemIdx, setSelectedProblemIdx] = useState(() => {
    const idx = localStorage.getItem("lastSelectedProblemIdx");
    return idx ? parseInt(idx, 10) : 0;
  });
  const [input, setInput] = useState({});
  const [output, setOutput] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  // Discover topics and load their problems.json files
  useEffect(() => {
    async function loadAllProblems() {
      setLoading(true);
      setError("");
      try {
        // List of topics (hardcoded, or you can fetch from backend if available)
        const topicList = [
          "arrays", "dynamicprogramming", "binarysearch", "binarysearchtree", "binarytree", "bitmanipulation", "graph", "greedyalgorithm", "hashing", "heaps", "linkedlist", "maths", "recursion", "slidingwindow", "sorting", "stackandqueue", "string", "tries"
        ];
        const problemsByTopicTemp = {};
        for (const topic of topicList) {
          try {
            const res = await fetch(`/src/data/${topic}/problems.json`);
            if (!res.ok) continue;
            const problems = await res.json();
            problemsByTopicTemp[topic] = problems;
          } catch {
            // skip topic if fetch fails
          }
        }
        const loadedTopics = Object.keys(problemsByTopicTemp);
        setTopics(loadedTopics);
        setProblemsByTopic(problemsByTopicTemp);
        // Restore last selected topic/problem if available, else default
        let topicToSelect = localStorage.getItem("lastSelectedTopic");
        let idxToSelect = parseInt(localStorage.getItem("lastSelectedProblemIdx"), 10);
        if (!topicToSelect || !problemsByTopicTemp[topicToSelect]) {
          topicToSelect = loadedTopics[0] || "";
        }
        if (isNaN(idxToSelect) || !problemsByTopicTemp[topicToSelect]?.[idxToSelect]) {
          idxToSelect = 0;
        }
        setSelectedTopic(topicToSelect);
        setSelectedProblemIdx(idxToSelect);
        setInput(
          problemsByTopicTemp[topicToSelect]?.[idxToSelect]?.defaultInput || {}
        );
        setLoading(false);
        if (loadedTopics.length === 0) {
          setError("No topics found. Please check your data files.");
        }
      } catch (err) {
        setError("Failed to load problems data.");
        setLoading(false);
      }
    }
    loadAllProblems();
  }, []);

  // Update input when problem changes
  useEffect(() => {
    if (!selectedTopic || !problemsByTopic[selectedTopic]) return;
    const selectedProblem = problemsByTopic[selectedTopic][selectedProblemIdx];
    setInput(selectedProblem?.defaultInput || {});
    setOutput(null);
    setError("");
    // Persist selection
    localStorage.setItem("lastSelectedTopic", selectedTopic);
    localStorage.setItem("lastSelectedProblemIdx", selectedProblemIdx);
  }, [selectedTopic, selectedProblemIdx, problemsByTopic]);

  // Update selected problem index when topic changes
  useEffect(() => {
    setSelectedProblemIdx(0);
  }, [selectedTopic]);

  const problems = problemsByTopic[selectedTopic] || [];
  const selectedProblem = problems[selectedProblemIdx];

  const handleRun = async () => {
    setOutput(null);
    setError("");
    if (!selectedProblem) return;
    try {
      const res = await fetch(selectedProblem.endpoint, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(input),
      });
      if (!res.ok) throw new Error(`HTTP ${res.status}`);
      const data = await res.json();
      setOutput(data);
    } catch (err) {
      setError(err.message || "Error running solution");
      // Do not reset selection on error
    }
  };

  if (loading) {
    return (
      <div className="flex items-center justify-center h-screen text-xl">Loading topics and problems...</div>
    );
  }
  if (error) {
    return (
      <div className="flex items-center justify-center h-screen text-red-600 text-xl">{error}</div>
    );
  }

  return (
    <div className="flex h-screen bg-gray-50">
      <TopicSelector
        topics={topics}
        selectedTopic={selectedTopic}
        onSelectTopic={setSelectedTopic}
      />
      <ProblemList
        problems={problems}
        selectedProblemIdx={selectedProblemIdx}
        onSelectProblem={setSelectedProblemIdx}
      />
      <main className="flex-1 flex flex-col p-0 overflow-auto">
        <div className="flex flex-row gap-6 p-6">
          <div className="flex-1 min-w-[350px]">
            <ProblemDetails problem={selectedProblem} />
          </div>
          <div className="w-[350px] flex flex-col gap-4">
            <InputForm
              input={input}
              setInput={setInput}
              onRun={handleRun}
              loading={false}
            />
            <OutputPanel output={output} loading={false} error={error} />
          </div>
        </div>
      </main>
    </div>
  );
}
