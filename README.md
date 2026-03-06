<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Java Lab Assignments</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=JetBrains+Mono:wght@300;400;600;700&family=Syne:wght@400;600;700;800&display=swap');

:root {
  --bg: #080c14;
  --surface: #0d1425;
  --surface2: #111c30;
  --border: #1a2a42;
  --accent: #00d4ff;
  --accent2: #7c3aed;
  --accent3: #10b981;
  --accent4: #f59e0b;
  --accent5: #f43f5e;
  --text: #dde6f0;
  --muted: #556577;
  --dim: #2a3a50;
}

*, *::before, *::after { margin: 0; padding: 0; box-sizing: border-box; }
html { scroll-behavior: smooth; }

body {
  background: var(--bg);
  color: var(--text);
  font-family: 'JetBrains Mono', 'Courier New', monospace;
  min-height: 100vh;
  overflow-x: hidden;
  -webkit-font-smoothing: antialiased;
}

body::before {
  content: '';
  position: fixed;
  inset: 0;
  background-image:
    linear-gradient(rgba(0,212,255,0.025) 1px, transparent 1px),
    linear-gradient(90deg, rgba(0,212,255,0.025) 1px, transparent 1px);
  background-size: 44px 44px;
  pointer-events: none;
  z-index: 0;
}

body::after {
  content: '';
  position: fixed;
  top: -30vh; left: 50%;
  transform: translateX(-50%);
  width: 80vw; height: 60vh;
  background: radial-gradient(ellipse at center, rgba(0,212,255,0.04) 0%, transparent 70%);
  pointer-events: none;
  z-index: 0;
}

.wrap {
  max-width: 860px;
  margin: 0 auto;
  padding: 72px 28px 80px;
  position: relative;
  z-index: 1;
}

/* HEADER */
.header { margin-bottom: 60px; }

.badge {
  display: inline-flex;
  align-items: center;
  gap: 8px;
  background: rgba(0,212,255,0.06);
  border: 1px solid rgba(0,212,255,0.18);
  border-radius: 3px;
  padding: 5px 13px;
  font-size: 10px;
  letter-spacing: 0.18em;
  color: var(--accent);
  text-transform: uppercase;
  margin-bottom: 28px;
}

.badge-dot {
  width: 5px; height: 5px;
  border-radius: 50%;
  background: var(--accent);
  animation: blink 2s ease-in-out infinite;
}

.title {
  font-family: 'Syne', 'Arial Black', sans-serif;
  font-size: clamp(40px, 7vw, 68px);
  font-weight: 800;
  line-height: 1.0;
  letter-spacing: -0.025em;
  color: #fff;
}

.title-grad {
  display: block;
  background: linear-gradient(120deg, var(--accent) 0%, #7c3aed 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.subtitle {
  margin-top: 18px;
  color: var(--muted);
  font-size: 12px;
  line-height: 1.9;
  max-width: 500px;
}

.meta { display: flex; gap: 20px; margin-top: 26px; flex-wrap: wrap; }

.meta-item {
  display: flex;
  align-items: center;
  gap: 7px;
  font-size: 11px;
  color: var(--muted);
}

.mdot { width: 5px; height: 5px; border-radius: 50%; }

/* TOC */
.toc {
  background: var(--surface);
  border: 1px solid var(--border);
  border-radius: 8px;
  padding: 24px 28px;
  margin-bottom: 52px;
}

.toc-lbl {
  font-size: 9px;
  letter-spacing: 0.22em;
  text-transform: uppercase;
  color: var(--muted);
  margin-bottom: 16px;
}

.toc-list {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  gap: 2px;
}

.toc-link {
  display: flex;
  align-items: center;
  gap: 10px;
  padding: 7px 9px;
  border-radius: 4px;
  text-decoration: none;
  color: var(--text);
  font-size: 12px;
  transition: background 0.12s;
}

.toc-link:hover { background: rgba(255,255,255,0.04); }
.toc-n { font-size: 9px; color: var(--muted); min-width: 18px; }
.toc-sq { width: 7px; height: 7px; border-radius: 2px; flex-shrink: 0; }

/* SECTION */
.sec {
  border: 1px solid var(--border);
  border-radius: 10px;
  padding: 26px 26px 22px;
  margin-bottom: 16px;
  position: relative;
  overflow: hidden;
}

.sec::before {
  content: '';
  position: absolute;
  top: 0; left: 0; right: 0;
  height: 1px;
}

.sec-head {
  display: flex;
  gap: 14px;
  align-items: flex-start;
  margin-bottom: 18px;
}

.sec-icon {
  width: 38px; height: 38px;
  border-radius: 8px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 17px;
  flex-shrink: 0;
}

.sec-meta { flex: 1; }

.sec-num {
  font-size: 9px;
  letter-spacing: 0.18em;
  text-transform: uppercase;
  color: var(--muted);
  margin-bottom: 3px;
}

.sec-title {
  font-family: 'Syne', 'Arial Black', sans-serif;
  font-size: 18px;
  font-weight: 700;
  color: #fff;
  line-height: 1.2;
}

.sec-desc {
  font-size: 11px;
  color: var(--muted);
  margin-top: 5px;
  line-height: 1.75;
}

.sec-desc code {
  font-family: inherit;
  font-size: 10px;
  padding: 1px 5px;
  border-radius: 3px;
  background: rgba(255,255,255,0.05);
}

/* CARDS */
.cards {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  gap: 7px;
}

.card {
  background: rgba(0,0,0,0.25);
  border: 1px solid var(--border);
  border-radius: 6px;
  padding: 13px 15px 11px;
  position: relative;
  overflow: hidden;
  transition: background 0.15s, transform 0.15s, border-color 0.15s;
}

.card:hover { background: rgba(255,255,255,0.03); transform: translateY(-2px); }

.card-bar {
  position: absolute;
  top: 0; left: 0; right: 0;
  height: 2px; opacity: 0;
  transition: opacity 0.15s;
}

.card:hover .card-bar { opacity: 1; }

.card-name {
  font-size: 11px; font-weight: 700;
  color: #e8f0f8; margin-bottom: 5px;
  letter-spacing: 0.01em;
}

.card-desc { font-size: 10px; color: var(--muted); line-height: 1.65; }

.tag {
  display: inline-block;
  margin-top: 9px;
  font-size: 9px;
  letter-spacing: 0.1em;
  text-transform: uppercase;
  padding: 2px 7px;
  border-radius: 3px;
  border: 1px solid;
}

/* CHIPS */
.chips {
  display: flex; flex-wrap: wrap;
  gap: 6px; margin-top: 14px;
  padding-top: 14px;
  border-top: 1px solid var(--border);
}

.chip {
  font-size: 9px; padding: 3px 10px;
  border-radius: 100px;
  letter-spacing: 0.06em;
  text-transform: uppercase;
}

/* TABLE */
.tbl-wrap {
  background: rgba(0,0,0,0.2);
  border: 1px solid var(--border);
  border-radius: 6px;
  overflow: hidden;
}

table { width: 100%; border-collapse: collapse; font-size: 11px; }

thead tr {
  background: rgba(0,0,0,0.3);
  border-bottom: 1px solid var(--border);
}

th {
  padding: 10px 14px; text-align: left;
  font-size: 9px; letter-spacing: 0.18em;
  text-transform: uppercase; color: var(--muted); font-weight: 400;
}

td {
  padding: 10px 14px;
  border-bottom: 1px solid rgba(26,42,66,0.5);
  color: var(--text); line-height: 1.65; vertical-align: top;
}

tr:last-child td { border-bottom: none; }
tbody tr:hover td { background: rgba(255,255,255,0.015); }

.td-name { font-weight: 700; font-size: 11px; white-space: nowrap; color: #e8f0f8; }

.etag {
  display: inline-block;
  font-family: 'JetBrains Mono', monospace;
  font-size: 9px; padding: 2px 7px;
  border-radius: 3px;
  margin: 2px 2px 2px 0;
  white-space: nowrap;
}

.er { background: rgba(244,63,94,0.1); border: 1px solid rgba(244,63,94,0.25); color: #f43f5e; }
.eg { background: rgba(16,185,129,0.1); border: 1px solid rgba(16,185,129,0.2); color: #34d399; }
.ea { background: rgba(245,158,11,0.1); border: 1px solid rgba(245,158,11,0.2); color: #fbbf24; }

/* SETUP */
.setup-grid { display: grid; grid-template-columns: 1fr 1fr; gap: 10px; }

.setup-card {
  background: rgba(0,0,0,0.25);
  border: 1px solid var(--border);
  border-radius: 6px; padding: 16px;
}

.setup-card h3 {
  font-size: 9px; letter-spacing: 0.18em;
  text-transform: uppercase; color: var(--muted); margin-bottom: 11px;
}

.code {
  background: #060910;
  border: 1px solid var(--dim);
  border-radius: 5px;
  padding: 13px 15px;
  font-size: 11px; line-height: 2;
  color: #7a8fa8; overflow-x: auto;
}

.cc { color: #34d399; }
.ca { color: var(--accent); }
.cm { color: var(--dim); }

hr { border: none; height: 1px; background: var(--border); margin: 44px 0; }

footer {
  text-align: center; padding-top: 28px;
  font-size: 10px; color: var(--dim);
  letter-spacing: 0.1em; text-transform: uppercase;
}

/* COLOR THEMES */
.s1 { background: rgba(0,212,255,0.03); }
.s1::before { background: linear-gradient(90deg, var(--accent), transparent); }
.s1 .sec-icon { background: rgba(0,212,255,0.08); }
.s1 .card:hover { border-color: rgba(0,212,255,0.28); }
.s1 .card-bar { background: var(--accent); }
.s1 .tag { color: var(--accent); border-color: rgba(0,212,255,0.22); background: rgba(0,212,255,0.06); }
.s1 .chip { background: rgba(0,212,255,0.07); border: 1px solid rgba(0,212,255,0.18); color: var(--accent); }

.s2 { background: rgba(124,58,237,0.04); }
.s2::before { background: linear-gradient(90deg, var(--accent2), transparent); }
.s2 .sec-icon { background: rgba(124,58,237,0.09); }
.s2 .card:hover { border-color: rgba(124,58,237,0.3); }
.s2 .card-bar { background: var(--accent2); }
.s2 .tag { color: #a78bfa; border-color: rgba(124,58,237,0.25); background: rgba(124,58,237,0.07); }
.s2 .chip { background: rgba(124,58,237,0.08); border: 1px solid rgba(124,58,237,0.22); color: #a78bfa; }
.s2 .sec-desc code { background: rgba(124,58,237,0.12); color: #c4b5fd; }

.s3 { background: rgba(16,185,129,0.03); }
.s3::before { background: linear-gradient(90deg, var(--accent3), transparent); }
.s3 .sec-icon { background: rgba(16,185,129,0.09); }
.s3 .card:hover { border-color: rgba(16,185,129,0.28); }
.s3 .card-bar { background: var(--accent3); }
.s3 .tag { color: var(--accent3); border-color: rgba(16,185,129,0.22); background: rgba(16,185,129,0.06); }
.s3 .chip { background: rgba(16,185,129,0.07); border: 1px solid rgba(16,185,129,0.2); color: #34d399; }
.s3 .sec-desc code { background: rgba(16,185,129,0.1); color: #6ee7b7; }

.s4 { background: rgba(245,158,11,0.03); }
.s4::before { background: linear-gradient(90deg, var(--accent4), transparent); }
.s4 .sec-icon { background: rgba(245,158,11,0.09); }
.s4 .card:hover { border-color: rgba(245,158,11,0.28); }
.s4 .card-bar { background: var(--accent4); }
.s4 .tag { color: var(--accent4); border-color: rgba(245,158,11,0.22); background: rgba(245,158,11,0.06); }
.s4 .chip { background: rgba(245,158,11,0.07); border: 1px solid rgba(245,158,11,0.2); color: #fbbf24; }

.s5 { background: rgba(244,63,94,0.03); }
.s5::before { background: linear-gradient(90deg, var(--accent5), transparent); }
.s5 .sec-icon { background: rgba(244,63,94,0.09); }

.s6 { background: rgba(52,211,153,0.025); }
.s6::before { background: linear-gradient(90deg, #34d399, transparent); }
.s6 .sec-icon { background: rgba(52,211,153,0.09); }

.s7 { background: rgba(251,191,36,0.025); }
.s7::before { background: linear-gradient(90deg, #fbbf24, transparent); }
.s7 .sec-icon { background: rgba(251,191,36,0.09); }

@keyframes blink {
  0%, 100% { opacity: 1; }
  50%       { opacity: 0.25; }
}

@media (max-width: 580px) {
  .setup-grid, .cards, .toc-list { grid-template-columns: 1fr; }
  .wrap { padding: 44px 18px 60px; }
}
</style>
</head>
<body>
<div class="wrap">

  <header class="header">
    <div class="badge"><span class="badge-dot"></span>Laboratory Assignments</div>
    <h1 class="title">Java<span class="title-grad">Programming</span></h1>
    <p class="subtitle">A comprehensive collection of Java lab exercises covering core and advanced programming concepts — from OOP fundamentals to file I/O and custom packages.</p>
    <div class="meta">
      <span class="meta-item"><span class="mdot" style="background:#00d4ff"></span>7 Topics</span>
      <span class="meta-item"><span class="mdot" style="background:#7c3aed"></span>40+ Programs</span>
      <span class="meta-item"><span class="mdot" style="background:#10b981"></span>JDK 8+</span>
    </div>
  </header>

  <nav class="toc">
    <div class="toc-lbl">// Contents</div>
    <div class="toc-list">
      <a href="#s1" class="toc-link"><span class="toc-n">01</span><span class="toc-sq" style="background:#00d4ff"></span>OOP Basics</a>
      <a href="#s2" class="toc-link"><span class="toc-n">02</span><span class="toc-sq" style="background:#7c3aed"></span>Decision-Making Statements</a>
      <a href="#s3" class="toc-link"><span class="toc-n">03</span><span class="toc-sq" style="background:#10b981"></span>Looping Constructs</a>
      <a href="#s4" class="toc-link"><span class="toc-n">04</span><span class="toc-sq" style="background:#f59e0b"></span>Advanced OOP</a>
      <a href="#s5" class="toc-link"><span class="toc-n">05</span><span class="toc-sq" style="background:#f43f5e"></span>Exception Handling</a>
      <a href="#s6" class="toc-link"><span class="toc-n">06</span><span class="toc-sq" style="background:#34d399"></span>I/O Streams &amp; File Handling</a>
      <a href="#s7" class="toc-link"><span class="toc-n">07</span><span class="toc-sq" style="background:#fbbf24"></span>User-Defined Packages</a>
    </div>
  </nav>

  <section class="sec s1" id="s1">
    <div class="sec-head">
      <div class="sec-icon">&#x2615;</div>
      <div class="sec-meta">
        <div class="sec-num">// 01</div>
        <div class="sec-title">Object-Oriented Programming Basics</div>
        <div class="sec-desc">Classes, objects, constructors, and getter&#8211;setter methods demonstrating core Java encapsulation.</div>
      </div>
    </div>
    <div class="cards">
      <div class="card"><div class="card-bar"></div><div class="card-name">Employee Salary</div><div class="card-desc">Calculate yearly salary and apply a 10% raise using class methods.</div><span class="tag">encapsulation</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Rectangle Area</div><div class="card-desc">Calculate area of a rectangle using class-based methods.</div><span class="tag">class design</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Static Members</div><div class="card-desc">Demonstrate static variables, methods, and static blocks.</div><span class="tag">static</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Stack &amp; Queue</div><div class="card-desc">Implement classic stack and queue data structure operations.</div><span class="tag">data structures</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Name Sorter</div><div class="card-desc">Arrange a list of names in alphabetical order.</div><span class="tag">sorting</span></div>
    </div>
    <div class="chips">
      <span class="chip">Encapsulation</span>
      <span class="chip">Object Creation</span>
      <span class="chip">Constructors</span>
      <span class="chip">Getter / Setter</span>
    </div>
  </section>

  <section class="sec s2" id="s2">
    <div class="sec-head">
      <div class="sec-icon">&#x1F500;</div>
      <div class="sec-meta">
        <div class="sec-num">// 02</div>
        <div class="sec-title">Decision-Making Statements</div>
        <div class="sec-desc">Control execution flow using <code>if</code>, <code>if-else</code>, <code>if-else-if</code>, and <code>switch</code>.</div>
      </div>
    </div>
    <div class="cards">
      <div class="card"><div class="card-bar"></div><div class="card-name">Sign Checker</div><div class="card-desc">Check whether a number is positive, negative, or zero.</div><span class="tag">if-else</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Even / Odd</div><div class="card-desc">Determine whether a number is even or odd.</div><span class="tag">if-else</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Vowel / Consonant</div><div class="card-desc">Identify whether a character is a vowel or consonant.</div><span class="tag">switch</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Largest of Three</div><div class="card-desc">Find the largest value among three given numbers.</div><span class="tag">if-else-if</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Leap Year</div><div class="card-desc">Check if a given year is a leap year.</div><span class="tag">if-else</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Simple Calculator</div><div class="card-desc">Perform basic arithmetic using a switch statement.</div><span class="tag">switch</span></div>
    </div>
    <div class="chips">
      <span class="chip">if / else</span><span class="chip">switch</span><span class="chip">Conditional Flow</span>
    </div>
  </section>

  <section class="sec s3" id="s3">
    <div class="sec-head">
      <div class="sec-icon">&#x1F501;</div>
      <div class="sec-meta">
        <div class="sec-num">// 03</div>
        <div class="sec-title">Looping Constructs</div>
        <div class="sec-desc"><code>for</code>, <code>while</code>, and <code>do-while</code> loops with <code>break</code>, <code>continue</code>, and <code>return</code> flow control.</div>
      </div>
    </div>
    <div class="cards">
      <div class="card"><div class="card-bar"></div><div class="card-name">Sum of Naturals</div><div class="card-desc">Calculate the sum of natural numbers.</div><span class="tag">for</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Alphabet Printer</div><div class="card-desc">Print alphabets A to Z using a loop.</div><span class="tag">for</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Factorial</div><div class="card-desc">Find the factorial of a given number.</div><span class="tag">while</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Multiplication Table</div><div class="card-desc">Generate a full multiplication table.</div><span class="tag">for</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Fibonacci Series</div><div class="card-desc">Print the Fibonacci sequence up to N terms.</div><span class="tag">while</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Number Reversal</div><div class="card-desc">Reverse the digits of a given number.</div><span class="tag">do-while</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Palindrome Check</div><div class="card-desc">Check if a number reads the same forwards and backwards.</div><span class="tag">loop</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Prime Checker</div><div class="card-desc">Determine whether a number is prime.</div><span class="tag">break</span></div>
    </div>
    <div class="chips">
      <span class="chip">for</span><span class="chip">while</span><span class="chip">do-while</span><span class="chip">break / continue</span>
    </div>
  </section>

  <section class="sec s4" id="s4">
    <div class="sec-head">
      <div class="sec-icon">&#x1F9EC;</div>
      <div class="sec-meta">
        <div class="sec-num">// 04</div>
        <div class="sec-title">Advanced OOP Concepts</div>
        <div class="sec-desc">Interfaces, inheritance, and abstract classes applied to real-world program structures.</div>
      </div>
    </div>
    <div class="cards">
      <div class="card"><div class="card-bar"></div><div class="card-name">Stack via Interface</div><div class="card-desc">Implement stack operations by defining and using a custom interface.</div><span class="tag">interface</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Shape Interface</div><div class="card-desc">Rectangle and Triangle implement a Shape interface to calculate areas.</div><span class="tag">interface</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Student Result System</div><div class="card-desc">Student, Test, and Result classes using inheritance and a Sports interface.</div><span class="tag">inheritance</span></div>
      <div class="card"><div class="card-bar"></div><div class="card-name">Abstract Shape</div><div class="card-desc">Rectangle and Triangle subclasses implement abstract methods of a Shape base class.</div><span class="tag">abstract</span></div>
    </div>
    <div class="chips">
      <span class="chip">Interface</span><span class="chip">Inheritance</span><span class="chip">Abstract Class</span><span class="chip">Polymorphism</span>
    </div>
  </section>

  <section class="sec s5" id="s5">
    <div class="sec-head">
      <div class="sec-icon">&#x26A0;&#xFE0F;</div>
      <div class="sec-meta">
        <div class="sec-num">// 05</div>
        <div class="sec-title">Exception Handling</div>
        <div class="sec-desc">Try-catch blocks and user-defined exceptions to handle invalid program states gracefully.</div>
      </div>
    </div>
    <div class="tbl-wrap">
      <table>
        <thead><tr><th>Program</th><th>Custom Exceptions</th><th>Description</th></tr></thead>
        <tbody>
          <tr>
            <td class="td-name">Bank Account</td>
            <td><span class="etag er">LowBalanceException</span><br><span class="etag er">NegativeNumberException</span></td>
            <td>Handles invalid deposit, withdrawal, and balance enquiry operations.</td>
          </tr>
          <tr>
            <td class="td-name">Odd Validator</td>
            <td><span class="etag er">OddNumberException</span></td>
            <td>Thrown when an odd number is passed to a method expecting an even value.</td>
          </tr>
          <tr>
            <td class="td-name">Calculator</td>
            <td><span class="etag er">DivisionException</span></td>
            <td>Raised when attempting to divide by zero.</td>
          </tr>
        </tbody>
      </table>
    </div>
  </section>

  <section class="sec s6" id="s6">
    <div class="sec-head">
      <div class="sec-icon">&#x1F4C2;</div>
      <div class="sec-meta">
        <div class="sec-num">// 06</div>
        <div class="sec-title">I/O Streams &amp; File Handling</div>
        <div class="sec-desc">Reading, writing, and analyzing files using Java's built-in stream and reader classes.</div>
      </div>
    </div>
    <div class="tbl-wrap">
      <table>
        <thead><tr><th>Program</th><th>Classes Used</th><th>Description</th></tr></thead>
        <tbody>
          <tr>
            <td class="td-name">File Reader</td>
            <td><span class="etag eg">FileInputStream</span></td>
            <td>Read data from a plain text file using byte streams.</td>
          </tr>
          <tr>
            <td class="td-name">Student Data Store</td>
            <td><span class="etag eg">DataOutputStream</span><br><span class="etag eg">DataInputStream</span></td>
            <td>Store and retrieve structured student records from a binary file.</td>
          </tr>
          <tr>
            <td class="td-name">Text Analyzer</td>
            <td><span class="etag eg">FileReader</span><br><span class="etag eg">BufferedReader</span></td>
            <td>Count vowels, words, and occurrences of a specific character in a file.</td>
          </tr>
        </tbody>
      </table>
    </div>
  </section>

  <section class="sec s7" id="s7">
    <div class="sec-head">
      <div class="sec-icon">&#x1F4E6;</div>
      <div class="sec-meta">
        <div class="sec-num">// 07</div>
        <div class="sec-title">User-Defined Packages</div>
        <div class="sec-desc">Organizing programs into logical namespaces to improve code structure and maintainability.</div>
      </div>
    </div>
    <div class="tbl-wrap">
      <table>
        <thead><tr><th>Package</th><th>Classes</th><th>Description</th></tr></thead>
        <tbody>
          <tr>
            <td class="td-name"><span class="etag ea">LibraryManagement</span></td>
            <td><span class="etag eg">Book</span> <span class="etag eg">Member</span></td>
            <td>Manage library resources including books and member records.</td>
          </tr>
          <tr>
            <td class="td-name"><span class="etag ea">Ecommerce</span></td>
            <td><span class="etag eg">Product</span> <span class="etag eg">Customer</span> <span class="etag eg">Order</span></td>
            <td>Handle product listings, customer accounts, and purchase orders.</td>
          </tr>
          <tr>
            <td class="td-name"><span class="etag ea">MathOperations</span></td>
            <td><span class="etag eg">MathUtils</span></td>
            <td>Utility methods for <code style="font-size:10px;padding:1px 5px;background:rgba(251,191,36,0.1);border-radius:3px;color:#fbbf24">floor</code>, <code style="font-size:10px;padding:1px 5px;background:rgba(251,191,36,0.1);border-radius:3px;color:#fbbf24">ceil</code>, and <code style="font-size:10px;padding:1px 5px;background:rgba(251,191,36,0.1);border-radius:3px;color:#fbbf24">round</code>.</td>
          </tr>
        </tbody>
      </table>
    </div>
  </section>

  <hr>

  <section id="setup">
    <div class="sec-head" style="margin-bottom:16px">
      <div class="sec-icon" style="background:rgba(255,255,255,0.04)">&#x2699;&#xFE0F;</div>
      <div class="sec-meta">
        <div class="sec-num">// Setup</div>
        <div class="sec-title">Prerequisites &amp; Running Programs</div>
      </div>
    </div>
    <div class="setup-grid">
      <div class="setup-card">
        <h3>Requirements</h3>
        <div class="code">
          <span class="cm">// Java Development Kit</span><br>
          JDK <span class="ca">8</span> or higher<br><br>
          <span class="cm">// IDE (pick one)</span><br>
          <span class="cc">IntelliJ IDEA</span><br>
          <span class="cc">Eclipse</span><br>
          <span class="cc">VS Code</span> + Extension Pack
        </div>
      </div>
      <div class="setup-card">
        <h3>Compile &amp; Run</h3>
        <div class="code">
          <span class="cm"># Compile</span><br>
          <span class="cc">javac</span> <span class="ca">FileName.java</span><br><br>
          <span class="cm"># Run</span><br>
          <span class="cc">java</span> <span class="ca">FileName</span><br><br>
          <span class="cm"># With packages</span><br>
          <span class="cc">javac</span> <span class="ca">pkg/File.java</span><br>
          <span class="cc">java</span> <span class="ca">pkg.FileName</span>
        </div>
      </div>
    </div>
  </section>

  <footer>Java Lab Assignments &nbsp;&bull;&nbsp; Object-Oriented Programming</footer>

</div>
</body>
</html>
