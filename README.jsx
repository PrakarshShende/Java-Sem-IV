import { useState } from "react";

const sections = [
  {
    id: "s1", num: "01", icon: "☕", label: "OOP Basics",
    title: "Object-Oriented Programming Basics",
    desc: "Classes, objects, constructors, and getter–setter methods demonstrating core Java encapsulation.",
    color: "#00d4ff",
    bg: "rgba(0,212,255,0.05)",
    border: "rgba(0,212,255,0.18)",
    tagColor: "#00d4ff",
    tagBg: "rgba(0,212,255,0.08)",
    chipColor: "#00d4ff",
    chipBorder: "rgba(0,212,255,0.2)",
    type: "cards",
    items: [
      { name: "Employee Salary", desc: "Calculate yearly salary and apply a 10% raise using class methods.", tag: "encapsulation" },
      { name: "Rectangle Area", desc: "Calculate area of a rectangle using class-based methods.", tag: "class design" },
      { name: "Static Members", desc: "Demonstrate static variables, methods, and static blocks.", tag: "static" },
      { name: "Stack & Queue", desc: "Implement classic stack and queue data structure operations.", tag: "data structures" },
      { name: "Name Sorter", desc: "Arrange a list of names in alphabetical order.", tag: "sorting" },
    ],
    chips: ["Encapsulation", "Object Creation", "Constructors", "Getter / Setter"],
  },
  {
    id: "s2", num: "02", icon: "🔀", label: "Decision-Making",
    title: "Decision-Making Statements",
    desc: "Control execution flow using if, if-else, if-else-if, and switch statements.",
    color: "#7c3aed",
    bg: "rgba(124,58,237,0.05)",
    border: "rgba(124,58,237,0.18)",
    tagColor: "#a78bfa",
    tagBg: "rgba(124,58,237,0.08)",
    chipColor: "#a78bfa",
    chipBorder: "rgba(124,58,237,0.22)",
    type: "cards",
    items: [
      { name: "Sign Checker", desc: "Check whether a number is positive, negative, or zero.", tag: "if-else" },
      { name: "Even / Odd", desc: "Determine whether a number is even or odd.", tag: "if-else" },
      { name: "Vowel / Consonant", desc: "Identify whether a character is a vowel or consonant.", tag: "switch" },
      { name: "Largest of Three", desc: "Find the largest value among three given numbers.", tag: "if-else-if" },
      { name: "Leap Year", desc: "Check if a given year is a leap year.", tag: "if-else" },
      { name: "Simple Calculator", desc: "Perform basic arithmetic using a switch statement.", tag: "switch" },
    ],
    chips: ["if / else", "switch", "Conditional Flow"],
  },
  {
    id: "s3", num: "03", icon: "🔁", label: "Looping Constructs",
    title: "Looping Constructs",
    desc: "for, while, and do-while loops with break, continue, and return flow control.",
    color: "#10b981",
    bg: "rgba(16,185,129,0.05)",
    border: "rgba(16,185,129,0.18)",
    tagColor: "#10b981",
    tagBg: "rgba(16,185,129,0.08)",
    chipColor: "#34d399",
    chipBorder: "rgba(16,185,129,0.22)",
    type: "cards",
    items: [
      { name: "Sum of Naturals", desc: "Calculate the sum of natural numbers.", tag: "for" },
      { name: "Alphabet Printer", desc: "Print alphabets A to Z using a loop.", tag: "for" },
      { name: "Factorial", desc: "Find the factorial of a given number.", tag: "while" },
      { name: "Multiplication Table", desc: "Generate a full multiplication table.", tag: "for" },
      { name: "Fibonacci Series", desc: "Print the Fibonacci sequence up to N terms.", tag: "while" },
      { name: "Number Reversal", desc: "Reverse the digits of a given number.", tag: "do-while" },
      { name: "Palindrome Check", desc: "Check if a number reads the same forwards and backwards.", tag: "loop" },
      { name: "Prime Checker", desc: "Determine whether a number is prime.", tag: "break" },
    ],
    chips: ["for", "while", "do-while", "break / continue"],
  },
  {
    id: "s4", num: "04", icon: "🧬", label: "Advanced OOP",
    title: "Advanced OOP Concepts",
    desc: "Interfaces, inheritance, and abstract classes applied to real-world program structures.",
    color: "#f59e0b",
    bg: "rgba(245,158,11,0.05)",
    border: "rgba(245,158,11,0.18)",
    tagColor: "#f59e0b",
    tagBg: "rgba(245,158,11,0.08)",
    chipColor: "#fbbf24",
    chipBorder: "rgba(245,158,11,0.22)",
    type: "cards",
    items: [
      { name: "Stack via Interface", desc: "Implement stack operations by defining and using a custom interface.", tag: "interface" },
      { name: "Shape Interface", desc: "Rectangle and Triangle implement a Shape interface to calculate areas.", tag: "interface" },
      { name: "Student Result System", desc: "Student, Test, and Result classes using inheritance and a Sports interface.", tag: "inheritance" },
      { name: "Abstract Shape", desc: "Rectangle and Triangle subclasses implement abstract methods of a Shape base class.", tag: "abstract" },
    ],
    chips: ["Interface", "Inheritance", "Abstract Class", "Polymorphism"],
  },
  {
    id: "s5", num: "05", icon: "⚠️", label: "Exception Handling",
    title: "Exception Handling",
    desc: "Try-catch blocks and user-defined exceptions to handle invalid program states gracefully.",
    color: "#f43f5e",
    bg: "rgba(244,63,94,0.05)",
    border: "rgba(244,63,94,0.18)",
    type: "table-exc",
    rows: [
      { name: "Bank Account", exceptions: ["LowBalanceException", "NegativeNumberException"], desc: "Handles invalid deposit, withdrawal, and balance enquiry operations." },
      { name: "Odd Validator", exceptions: ["OddNumberException"], desc: "Thrown when an odd number is passed to a method expecting an even value." },
      { name: "Calculator", exceptions: ["DivisionException"], desc: "Raised when attempting to divide by zero." },
    ],
  },
  {
    id: "s6", num: "06", icon: "📂", label: "I/O & File Handling",
    title: "I/O Streams & File Handling",
    desc: "Reading, writing, and analyzing files using Java's built-in stream and reader classes.",
    color: "#34d399",
    bg: "rgba(52,211,153,0.04)",
    border: "rgba(52,211,153,0.16)",
    type: "table-io",
    rows: [
      { name: "File Reader", classes: ["FileInputStream"], desc: "Read data from a plain text file using byte streams." },
      { name: "Student Data Store", classes: ["DataOutputStream", "DataInputStream"], desc: "Store and retrieve structured student records from a binary file." },
      { name: "Text Analyzer", classes: ["FileReader", "BufferedReader"], desc: "Count vowels, words, and occurrences of a specific character in a file." },
    ],
  },
  {
    id: "s7", num: "07", icon: "📦", label: "User-Defined Packages",
    title: "User-Defined Packages",
    desc: "Organizing programs into logical namespaces to improve code structure and maintainability.",
    color: "#fbbf24",
    bg: "rgba(251,191,36,0.04)",
    border: "rgba(251,191,36,0.16)",
    type: "table-pkg",
    rows: [
      { pkg: "LibraryManagement", classes: ["Book", "Member"], desc: "Manage library resources including books and member records." },
      { pkg: "Ecommerce", classes: ["Product", "Customer", "Order"], desc: "Handle product listings, customer accounts, and purchase orders." },
      { pkg: "MathOperations", classes: ["MathUtils"], desc: "Utility methods for floor, ceil, and round operations." },
    ],
  },
];

function Tag({ children, color, bg, border }) {
  return (
    <span style={{
      display: "inline-block", fontSize: 9, letterSpacing: "0.1em",
      textTransform: "uppercase", padding: "2px 7px", borderRadius: 3,
      border: `1px solid ${border || color + "44"}`,
      color, background: bg || color + "11",
      fontFamily: "monospace", whiteSpace: "nowrap",
      marginRight: 3, marginBottom: 3,
    }}>{children}</span>
  );
}

function Card({ item, sec }) {
  const [hov, setHov] = useState(false);
  return (
    <div
      onMouseEnter={() => setHov(true)}
      onMouseLeave={() => setHov(false)}
      style={{
        background: hov ? "rgba(255,255,255,0.04)" : "rgba(0,0,0,0.25)",
        border: `1px solid ${hov ? sec.color + "44" : "#1a2a42"}`,
        borderRadius: 6, padding: "13px 15px 12px",
        position: "relative", overflow: "hidden",
        transform: hov ? "translateY(-2px)" : "none",
        transition: "all 0.15s ease", cursor: "default",
      }}
    >
      <div style={{
        position: "absolute", top: 0, left: 0, right: 0, height: 2,
        background: sec.color, opacity: hov ? 1 : 0, transition: "opacity 0.15s",
      }} />
      <div style={{ fontSize: 11, fontWeight: 700, color: "#e8f0f8", marginBottom: 5 }}>{item.name}</div>
      <div style={{ fontSize: 10, color: "#556577", lineHeight: 1.65 }}>{item.desc}</div>
      <Tag color={sec.tagColor} bg={sec.tagBg}>{item.tag}</Tag>
    </div>
  );
}

function TableExc({ rows }) {
  return (
    <div style={{ background: "rgba(0,0,0,0.2)", border: "1px solid #1a2a42", borderRadius: 6, overflow: "hidden" }}>
      <table style={{ width: "100%", borderCollapse: "collapse", fontSize: 11 }}>
        <thead>
          <tr style={{ background: "rgba(0,0,0,0.3)", borderBottom: "1px solid #1a2a42" }}>
            {["Program","Custom Exceptions","Description"].map(h => (
              <th key={h} style={{ padding: "10px 14px", textAlign: "left", fontSize: 9, letterSpacing: "0.18em", textTransform: "uppercase", color: "#556577", fontWeight: 400 }}>{h}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {rows.map((r, i) => (
            <tr key={i} style={{ borderBottom: i < rows.length - 1 ? "1px solid rgba(26,42,66,0.5)" : "none" }}>
              <td style={{ padding: "10px 14px", fontWeight: 700, color: "#e8f0f8", whiteSpace: "nowrap", verticalAlign: "top" }}>{r.name}</td>
              <td style={{ padding: "10px 14px", verticalAlign: "top" }}>
                {r.exceptions.map(e => <Tag key={e} color="#f43f5e" bg="rgba(244,63,94,0.1)" border="rgba(244,63,94,0.25)">{e}</Tag>)}
              </td>
              <td style={{ padding: "10px 14px", color: "#8da0b5", lineHeight: 1.65, verticalAlign: "top" }}>{r.desc}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

function TableIO({ rows }) {
  return (
    <div style={{ background: "rgba(0,0,0,0.2)", border: "1px solid #1a2a42", borderRadius: 6, overflow: "hidden" }}>
      <table style={{ width: "100%", borderCollapse: "collapse", fontSize: 11 }}>
        <thead>
          <tr style={{ background: "rgba(0,0,0,0.3)", borderBottom: "1px solid #1a2a42" }}>
            {["Program","Classes Used","Description"].map(h => (
              <th key={h} style={{ padding: "10px 14px", textAlign: "left", fontSize: 9, letterSpacing: "0.18em", textTransform: "uppercase", color: "#556577", fontWeight: 400 }}>{h}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {rows.map((r, i) => (
            <tr key={i} style={{ borderBottom: i < rows.length - 1 ? "1px solid rgba(26,42,66,0.5)" : "none" }}>
              <td style={{ padding: "10px 14px", fontWeight: 700, color: "#e8f0f8", whiteSpace: "nowrap", verticalAlign: "top" }}>{r.name}</td>
              <td style={{ padding: "10px 14px", verticalAlign: "top" }}>
                {r.classes.map(c => <Tag key={c} color="#34d399" bg="rgba(16,185,129,0.1)" border="rgba(16,185,129,0.2)">{c}</Tag>)}
              </td>
              <td style={{ padding: "10px 14px", color: "#8da0b5", lineHeight: 1.65, verticalAlign: "top" }}>{r.desc}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

function TablePkg({ rows }) {
  return (
    <div style={{ background: "rgba(0,0,0,0.2)", border: "1px solid #1a2a42", borderRadius: 6, overflow: "hidden" }}>
      <table style={{ width: "100%", borderCollapse: "collapse", fontSize: 11 }}>
        <thead>
          <tr style={{ background: "rgba(0,0,0,0.3)", borderBottom: "1px solid #1a2a42" }}>
            {["Package","Classes","Description"].map(h => (
              <th key={h} style={{ padding: "10px 14px", textAlign: "left", fontSize: 9, letterSpacing: "0.18em", textTransform: "uppercase", color: "#556577", fontWeight: 400 }}>{h}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {rows.map((r, i) => (
            <tr key={i} style={{ borderBottom: i < rows.length - 1 ? "1px solid rgba(26,42,66,0.5)" : "none" }}>
              <td style={{ padding: "10px 14px", verticalAlign: "top" }}>
                <Tag color="#fbbf24" bg="rgba(245,158,11,0.1)" border="rgba(245,158,11,0.22)">{r.pkg}</Tag>
              </td>
              <td style={{ padding: "10px 14px", verticalAlign: "top" }}>
                {r.classes.map(c => <Tag key={c} color="#34d399" bg="rgba(16,185,129,0.1)" border="rgba(16,185,129,0.2)">{c}</Tag>)}
              </td>
              <td style={{ padding: "10px 14px", color: "#8da0b5", lineHeight: 1.65, verticalAlign: "top" }}>{r.desc}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default function App() {
  return (
    <div style={{
      background: "#080c14", minHeight: "100vh", color: "#dde6f0",
      fontFamily: "'JetBrains Mono', 'Courier New', monospace",
      WebkitFontSmoothing: "antialiased",
    }}>
      {/* Grid bg */}
      <div style={{
        position: "fixed", inset: 0, pointerEvents: "none", zIndex: 0,
        backgroundImage: "linear-gradient(rgba(0,212,255,0.025) 1px, transparent 1px), linear-gradient(90deg, rgba(0,212,255,0.025) 1px, transparent 1px)",
        backgroundSize: "44px 44px",
      }} />
      <div style={{
        position: "fixed", top: "-30vh", left: "50%", transform: "translateX(-50%)",
        width: "80vw", height: "60vh", pointerEvents: "none", zIndex: 0,
        background: "radial-gradient(ellipse at center, rgba(0,212,255,0.04) 0%, transparent 70%)",
      }} />

      <div style={{ maxWidth: 860, margin: "0 auto", padding: "64px 28px 80px", position: "relative", zIndex: 1 }}>

        {/* HEADER */}
        <div style={{ marginBottom: 56 }}>
          <div style={{
            display: "inline-flex", alignItems: "center", gap: 8,
            background: "rgba(0,212,255,0.06)", border: "1px solid rgba(0,212,255,0.18)",
            borderRadius: 3, padding: "5px 13px", fontSize: 10, letterSpacing: "0.18em",
            color: "#00d4ff", textTransform: "uppercase", marginBottom: 24,
          }}>
            <span style={{ width: 5, height: 5, borderRadius: "50%", background: "#00d4ff", display: "inline-block", animation: "pulse 2s infinite" }} />
            Laboratory Assignments
          </div>
          <div style={{ fontSize: "clamp(40px, 7vw, 64px)", fontWeight: 800, lineHeight: 1.0, letterSpacing: "-0.025em", color: "#fff", fontFamily: "system-ui, sans-serif" }}>
            Java
          </div>
          <div style={{
            fontSize: "clamp(40px, 7vw, 64px)", fontWeight: 800, lineHeight: 1.0, letterSpacing: "-0.025em",
            background: "linear-gradient(120deg, #00d4ff 0%, #7c3aed 100%)",
            WebkitBackgroundClip: "text", WebkitTextFillColor: "transparent",
            backgroundClip: "text", fontFamily: "system-ui, sans-serif",
          }}>
            Programming
          </div>
          <p style={{ marginTop: 18, color: "#556577", fontSize: 12, lineHeight: 1.9, maxWidth: 500 }}>
            A comprehensive collection of Java lab exercises covering core and advanced programming concepts — from OOP fundamentals to file I/O and custom packages.
          </p>
          <div style={{ display: "flex", gap: 20, marginTop: 24, flexWrap: "wrap" }}>
            {[["#00d4ff","7 Topics"],["#7c3aed","40+ Programs"],["#10b981","JDK 8+"]].map(([c, l]) => (
              <span key={l} style={{ display: "flex", alignItems: "center", gap: 7, fontSize: 11, color: "#556577" }}>
                <span style={{ width: 5, height: 5, borderRadius: "50%", background: c, display: "inline-block" }} />
                {l}
              </span>
            ))}
          </div>
        </div>

        {/* TOC */}
        <div style={{ background: "#0d1425", border: "1px solid #1a2a42", borderRadius: 8, padding: "22px 26px", marginBottom: 48 }}>
          <div style={{ fontSize: 9, letterSpacing: "0.22em", textTransform: "uppercase", color: "#556577", marginBottom: 14 }}>// Contents</div>
          <div style={{ display: "grid", gridTemplateColumns: "repeat(auto-fill, minmax(240px, 1fr))", gap: 2 }}>
            {sections.map(s => (
              <a key={s.id} href={`#${s.id}`} style={{
                display: "flex", alignItems: "center", gap: 10,
                padding: "7px 9px", borderRadius: 4, textDecoration: "none",
                color: "#dde6f0", fontSize: 12,
              }}>
                <span style={{ fontSize: 9, color: "#556577", minWidth: 18 }}>{s.num}</span>
                <span style={{ width: 7, height: 7, borderRadius: 2, background: s.color, flexShrink: 0 }} />
                {s.label}
              </a>
            ))}
          </div>
        </div>

        {/* SECTIONS */}
        {sections.map(sec => (
          <div key={sec.id} id={sec.id} style={{
            background: sec.bg, border: `1px solid ${sec.border}`,
            borderRadius: 10, padding: "24px 24px 20px", marginBottom: 14,
            position: "relative", overflow: "hidden",
          }}>
            <div style={{ position: "absolute", top: 0, left: 0, right: 0, height: 1, background: `linear-gradient(90deg, ${sec.color}, transparent)` }} />

            <div style={{ display: "flex", gap: 14, alignItems: "flex-start", marginBottom: 18 }}>
              <div style={{
                width: 38, height: 38, borderRadius: 8,
                background: sec.color + "18",
                display: "flex", alignItems: "center", justifyContent: "center",
                fontSize: 18, flexShrink: 0,
              }}>{sec.icon}</div>
              <div>
                <div style={{ fontSize: 9, letterSpacing: "0.18em", textTransform: "uppercase", color: "#556577", marginBottom: 3 }}>// {sec.num}</div>
                <div style={{ fontSize: 17, fontWeight: 700, color: "#fff", fontFamily: "system-ui, sans-serif" }}>{sec.title}</div>
                <div style={{ fontSize: 11, color: "#556577", marginTop: 4, lineHeight: 1.75 }}>{sec.desc}</div>
              </div>
            </div>

            {sec.type === "cards" && (
              <>
                <div style={{ display: "grid", gridTemplateColumns: "repeat(auto-fill, minmax(200px, 1fr))", gap: 7 }}>
                  {sec.items.map(item => <Card key={item.name} item={item} sec={sec} />)}
                </div>
                <div style={{ display: "flex", flexWrap: "wrap", gap: 6, marginTop: 14, paddingTop: 14, borderTop: "1px solid #1a2a42" }}>
                  {sec.chips.map(c => (
                    <span key={c} style={{
                      fontSize: 9, padding: "3px 10px", borderRadius: 100,
                      letterSpacing: "0.06em", textTransform: "uppercase",
                      background: sec.color + "11", border: `1px solid ${sec.color}33`, color: sec.chipColor,
                    }}>{c}</span>
                  ))}
                </div>
              </>
            )}
            {sec.type === "table-exc" && <TableExc rows={sec.rows} />}
            {sec.type === "table-io"  && <TableIO  rows={sec.rows} />}
            {sec.type === "table-pkg" && <TablePkg rows={sec.rows} />}
          </div>
        ))}

        {/* DIVIDER */}
        <div style={{ height: 1, background: "#1a2a42", margin: "40px 0" }} />

        {/* SETUP */}
        <div>
          <div style={{ display: "flex", gap: 14, alignItems: "flex-start", marginBottom: 16 }}>
            <div style={{ width: 38, height: 38, borderRadius: 8, background: "rgba(255,255,255,0.04)", display: "flex", alignItems: "center", justifyContent: "center", fontSize: 18 }}>⚙️</div>
            <div>
              <div style={{ fontSize: 9, letterSpacing: "0.18em", textTransform: "uppercase", color: "#556577", marginBottom: 3 }}>// Setup</div>
              <div style={{ fontSize: 17, fontWeight: 700, color: "#fff", fontFamily: "system-ui, sans-serif" }}>Prerequisites & Running Programs</div>
            </div>
          </div>
          <div style={{ display: "grid", gridTemplateColumns: "1fr 1fr", gap: 10 }}>
            {[
              {
                title: "Requirements",
                lines: [
                  { type: "comment", text: "// Java Development Kit" },
                  { type: "plain", text: "JDK " }, { type: "arg", text: "8" }, { type: "plain", text: " or higher" },
                  { type: "br" },
                  { type: "comment", text: "// IDE (pick one)" },
                  { type: "cmd", text: "IntelliJ IDEA" },
                  { type: "cmd", text: "Eclipse" },
                  { type: "cmd", text: "VS Code" }, { type: "plain", text: " + Extension Pack" },
                ],
              },
              {
                title: "Compile & Run",
                lines: [
                  { type: "comment", text: "# Compile" },
                  { type: "cmd", text: "javac " }, { type: "arg", text: "FileName.java" },
                  { type: "br" },
                  { type: "comment", text: "# Run" },
                  { type: "cmd", text: "java " }, { type: "arg", text: "FileName" },
                  { type: "br" },
                  { type: "comment", text: "# With packages" },
                  { type: "cmd", text: "javac " }, { type: "arg", text: "pkg/File.java" },
                  { type: "cmd", text: "java " }, { type: "arg", text: "pkg.FileName" },
                ],
              },
            ].map(card => (
              <div key={card.title} style={{ background: "rgba(0,0,0,0.25)", border: "1px solid #1a2a42", borderRadius: 6, padding: 16 }}>
                <div style={{ fontSize: 9, letterSpacing: "0.18em", textTransform: "uppercase", color: "#556577", marginBottom: 11 }}>{card.title}</div>
                <div style={{ background: "#060910", border: "1px solid #2a3a50", borderRadius: 5, padding: "13px 15px", fontSize: 11, lineHeight: 2, color: "#7a8fa8" }}>
                  {card.lines.map((l, i) => {
                    if (l.type === "br") return <br key={i} />;
                    if (l.type === "comment") return <div key={i} style={{ color: "#2a3a50" }}>{l.text}</div>;
                    if (l.type === "cmd") return <span key={i} style={{ color: "#34d399" }}>{l.text}</span>;
                    if (l.type === "arg") return <span key={i} style={{ color: "#00d4ff" }}>{l.text}</span>;
                    return <span key={i}>{l.text}</span>;
                  })}
                </div>
              </div>
            ))}
          </div>
        </div>

        {/* FOOTER */}
        <div style={{ textAlign: "center", paddingTop: 40, fontSize: 10, color: "#2a3a50", letterSpacing: "0.1em", textTransform: "uppercase" }}>
          Java Lab Assignments &nbsp;·&nbsp; Object-Oriented Programming
        </div>
      </div>

      <style>{`
        @keyframes pulse { 0%,100%{opacity:1} 50%{opacity:0.25} }
        a:hover { background: rgba(255,255,255,0.04) !important; }
        * { box-sizing: border-box; }
      `}</style>
    </div>
  );
}
