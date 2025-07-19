import React from "react";

export default function CodeBlock({ code }) {
  return (
    <div className="mockup-code">
      <pre data-prefix="$"><code>{code}</code></pre>
    </div>
  );
}
