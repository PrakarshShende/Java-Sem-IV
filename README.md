<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Java Lab Assignments</title>
<link href="https://fonts.googleapis.com/css2?family=JetBrains+Mono:wght@300;400;600;700&family=Syne:wght@400;600;700;800&display=swap" rel="stylesheet">
<style>
  :root {
    --bg: #0a0e17;
    --surface: #0f1623;
    --surface2: #151d2e;
    --border: #1e2d47;
    --accent: #00d4ff;
    --accent2: #7c3aed;
    --accent3: #10b981;
    --accent4: #f59e0b;
    --accent5: #f43f5e;
    --text: #e2e8f0;
    --muted: #64748b;
    --dim: #334155;
  }

  * { margin: 0; padding: 0; box-sizing: border-box; }

  body {
    background: var(--bg);
    color: var(--text);
    font-family: 'JetBrains Mono', monospace;
    min-height: 100vh;
    overflow-x: hidden;
  }

  /* Animated grid background */
  body::before {
    content: '';
    position: fixed;
    inset: 0;
    background-image:
      linear-gradient(rgba(0,212,255,0.03) 1px, transparent 1px),
      linear-gradient(90deg, rgba(0,212,255,0.03) 1px, transparent 1px);
    background-size: 40px 40px;
    pointer-events: none;
    z-index: 0;
  }

  .container {
    max-width: 900px;
    margin: 0 auto;
    padding: 60px 24px;
    position: relative;
    z-index: 1;
  }

  /* ── HEADER ── */
  .header {
    margin-bottom: 64px;
    animation: fadeDown 0.7s ease both;
  }

  .header-badge {
    display: inline-flex;
    align-items: center;
    gap: 8px;
    background: rgba(0,212,255,0.07);
    border: 1px solid rgba(0,212,255,0.2);
    border-radius: 4px;
    padding: 6px 14px;
    font-size: 11px;
    letter-spacing: 0.15em;
    color: var(--accent);
    text-transform: uppercase;
    margin-bottom: 24px;
  }

  .header-badge::before {
    content: '';
    width: 6px; height: 6px;
    border-radius: 50%;
    background: var(--accent);
    animation: pulse 2s infinite;
  }

  h1 {
    font-family: 'Syne', sans-serif;
    font-size: clamp(36px, 6vw, 64px);
    font-weight: 800;
    line-height: 1.05;
    letter-spacing: -0.02em;
    color: #fff;
  }

  h1 span {
    display: block;
    background: linear-gradient(135deg, var(--accent) 0%, var(--accent2) 100%);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
  }

  .header-sub {
    margin-top: 20px;
    color: var(--muted);
    font-size: 13px;
    line-height: 1.8;
    max-width: 520px;
  }

  .header-meta {
    display: flex;
    gap: 24px;
    margin-top: 28px;
    flex-wrap: wrap;
  }

  .meta-pill {
    display: flex;
    align-items: center;
    gap: 6px;
    font-size: 12px;
    color: var(--muted);
  }

  .meta-pill .dot {
    width: 4px; height: 4px;
    border-radius: 50%;
  }

  /* ── TOC ── */
  .toc {
    background: var(--surface);
    border: 1px solid var(--border);
    border-radius: 8px;
    padding: 28px 32px;
    margin-bottom: 56px;
    animation: fadeUp 0.6s 0.2s ease both;
  }

  .toc-title {
    font-size: 10px;
    letter-spacing: 0.2em;
    text-transform: uppercase;
    color: var(--muted);
    margin-bottom: 20px;
  }

  .toc-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(260px, 1fr));
    gap: 6px;
  }

  .toc-item {
    display: flex;
    align-items: center;
    gap: 12px;
    padding: 8px 10px;
    border-radius: 4px;
    cursor: pointer;
    transition: background 0.15s;
    text-decoration: none;
    color: var(--text);
  }

  .toc-item:hover { background: rgba(255,255,255,0.04); }

  .toc-num {
    font-size: 10px;
    color: var(--muted);
    min-width: 20px;
  }

  .toc-dot {
    width: 8px; height: 8px;
    border-radius: 2px;
    flex-shrink: 0;
  }

  .toc-label { font-size: 12px; }

  /* ── SECTIONS ── */
  .section {
    margin-bottom: 48px;
    animation: fadeUp 0.5s ease both;
  }

  .section-header {
    display: flex;
    align-items: flex-start;
    gap: 16px;
    margin-bottom: 20px;
  }

  .section-icon {
    width: 40px; height: 40px;
    border-radius: 8px;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 18px;
    flex-shrink: 0;
  }

  .section-title-wrap { flex: 1; }

  .section-num {
    font-size: 10px;
    letter-spacing: 0.15em;
    text-transform: uppercase;
    color: var(--muted);
    margin-bottom: 4px;
  }

  h2 {
    font-family: 'Syne', sans-serif;
    font-size: 20px;
    font-weight: 700;
    color: #fff;
  }

  .section-desc {
    font-size: 12px;
    color: var(--muted);
    margin-top: 4px;
    line-height: 1.7;
  }

  /* ── CARDS ── */
  .cards {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(240px, 1fr));
    gap: 8px;
  }

  .card {
    background: var(--surface);
    border: 1px solid var(--border);
    border-radius: 6px;
    padding: 14px 16px;
    transition: border-color 0.2s, background 0.2s, transform 0.2s;
    cursor: default;
    position: relative;
    overflow: hidden;
  }

  .card::before {
    content: '';
    position: absolute;
    top: 0; left: 0; right: 0;
    height: 2px;
    opacity: 0;
    transition: opacity 0.2s;
  }

  .card:hover {
    background: var(--surface2);
    transform: translateY(-1px);
  }

  .card:hover::before { opacity: 1; }

  .card-name {
    font-size: 12px;
    font-weight: 600;
    color: #fff;
    margin-bottom: 5px;
  }

  .card-desc {
    font-size: 11px;
    color: var(--muted);
    line-height: 1.6;
  }

  .card-tag {
    display: inline-block;
    margin-top: 8px;
    font-size: 9px;
    letter-spacing: 0.1em;
    text-transform: uppercase;
    padding: 2px 7px;
    border-radius: 3px;
    border: 1px solid;
  }

  /* ── TABLE VARIANT ── */
  .prog-table {
    width: 100%;
    border-collapse: collapse;
    font-size: 12px;
  }

  .prog-table thead tr {
    background: var(--surface2);
    border-bottom: 1px solid var(--border);
  }

  .prog-table th {
    padding: 10px 14px;
    text-align: left;
    font-size: 10px;
    letter-spacing: 0.15em;
    text-transform: uppercase;
    color: var(--muted);
    font-weight: 400;
  }

  .prog-table td {
    padding: 10px 14px;
    border-bottom: 1px solid rgba(30,45,71,0.6);
    color: var(--text);
    line-height: 1.6;
  }

  .prog-table tr:last-child td { border-bottom: none; }
  .prog-table tr:hover td { background: rgba(255,255,255,0.02); }

  .prog-table .name-cell {
    font-weight: 600;
    white-space: nowrap;
  }

  .exc-tag {
    font-family: 'JetBrains Mono', monospace;
    font-size: 10px;
    padding: 2px 7px;
    border-radius: 3px;
    background: rgba(244,63,94,0.1);
    border: 1px solid rgba(244,63,94,0.25);
    color: #f43f5e;
    white-space: nowrap;
    display: inline-block;
    margin: 2px 2px 2px 0;
  }

  .class-tag {
    font-family: 'JetBrains Mono', monospace;
    font-size: 10px;
    padding: 2px 7px;
    border-radius: 3px;
    background: rgba(16,185,129,0.1);
    border: 1px solid rgba(16,185,129,0.2);
    color: var(--accent3);
    white-space: nowrap;
    display: inline-block;
    margin: 2px 2px 2px 0;
  }

  .pkg-tag {
    font-family: 'JetBrains Mono', monospace;
    font-size: 10px;
    padding: 2px 7px;
    border-radius: 3px;
    background: rgba(245,158,11,0.1);
    border: 1px solid rgba(245,158,11,0.2);
    color: var(--accent4);
    white-space: nowrap;
    display: inline-block;
    margin: 2px 2px 2px 0;
  }

  /* ── CONCEPTS BAR ── */
  .concepts {
    display: flex;
    flex-wrap: wrap;
    gap: 6px;
    margin-top: 14px;
  }

  .concept-chip {
    font-size: 10px;
    padding: 4px 10px;
    border-radius: 100px;
    background: rgba(124,58,237,0.1);
    border: 1px solid rgba(124,58,237,0.25);
    color: #a78bfa;
    letter-spacing: 0.05em;
  }

  /* ── SETUP SECTION ── */
  .setup-grid {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 12px;
  }

  @media (max-width: 600px) {
    .setup-grid { grid-template-columns: 1fr; }
    .cards { grid-template-columns: 1fr; }
    .toc-grid { grid-template-columns: 1fr; }
  }

  .setup-card {
    background: var(--surface);
    border: 1px solid var(--border);
    border-radius: 6px;
    padding: 18px;
  }

  .setup-card h3 {
    font-size: 11px;
    letter-spacing: 0.12em;
    text-transform: uppercase;
    color: var(--muted);
    margin-bottom: 12px;
  }

  .code-block {
    background: #080c14;
    border: 1px solid var(--border);
    border-radius: 5px;
    padding: 14px 16px;
    font-size: 12px;
    line-height: 1.9;
    color: #94a3b8;
    overflow-x: auto;
  }

  .code-block .cmd { color: var(--accent3); }
  .code-block .arg { color: var(--accent); }
  .code-block .comment { color: var(--dim); }

  /* ── DIVIDER ── */
  .divider {
    border: none;
    height: 1px;
    background: var(--border);
    margin: 48px 0;
  }

  /* ── FOOTER ── */
  .footer {
    text-align: center;
    padding-top: 32px;
    font-size: 11px;
    color: var(--dim);
    letter-spacing: 0.05em;
  }

  /* ── COLORS PER SECTION ── */
  .c1 { background: rgba(0,212,255,0.08); }
  .c1 .section-icon { background: rgba(0,212,255,0.1); }
  .c1 .toc-dot, .c1 .card::before { background: var(--accent); }
  .c1 .card-tag { color: var(--accent); border-color: rgba(0,212,255,0.25); background: rgba(0,212,255,0.06); }
  .c1 .card:hover { border-color: rgba(0,212,255,0.3); }

  .c2 { background: rgba(124,58,237,0.08); }
  .c2 .section-icon { background: rgba(124,58,237,0.1); }
  .c2 .toc-dot, .c2 .card::before { background: var(--accent2); }
  .c2 .card-tag { color: #a78bfa; border-color: rgba(124,58,237,0.25); background: rgba(124,58,237,0.06); }
  .c2 .card:hover { border-color: rgba(124,58,237,0.3); }

  .c3 { background: rgba(16,185,129,0.08); }
  .c3 .section-icon { background: rgba(16,185,129,0.1); }
  .c3 .toc-dot, .c3 .card::before { background: var(--accent3); }
  .c3 .card-tag { color: var(--accent3); border-color: rgba(16,185,129,0.25); background: rgba(16,185,129,0.06); }
  .c3 .card:hover { border-color: rgba(16,185,129,0.3); }

  .c4 { background: rgba(245,158,11,0.08); }
  .c4 .section-icon { background: rgba(245,158,11,0.1); }
  .c4 .toc-dot, .c4 .card::before { background: var(--accent4); }
  .c4 .card-tag { color: var(--accent4); border-color: rgba(245,158,11,0.25); background: rgba(245,158,11,0.06); }
  .c4 .card:hover { border-color: rgba(245,158,11,0.3); }

  .c5 { background: rgba(244,63,94,0.08); }
  .c5 .section-icon { background: rgba(244,63,94,0.1); }
  .c5 .toc-dot, .c5 .card::before { background: var(--accent5); }
  .c5 .card-tag { color: var(--accent5); border-color: rgba(244,63,94,0.25); background: rgba(244,63,94,0.06); }
  .c5 .card:hover { border-color: rgba(244,63,94,0.3); }

  .c6 { background: rgba(16,185,129,0.06); }
  .c6 .section-icon { background: rgba(16,185,129,0.1); }
  .c6 .toc-dot { background: #34d399; }
  .c6 .card:hover { border-color: rgba(16,185,129,0.3); }

  .c7 { background: rgba(245,158,11,0.06); }
  .c7 .section-icon { background: rgba(245,158,11,0.1); }
  .c7 .toc-dot { background: #fcd34d; }

  /* ── ANIMATIONS ── */
  @keyframes fadeDown {
    from { opacity: 0; transform: translateY(-20px); }
    to   { opacity: 1; transform: translateY(0); }
  }

  @keyframes fadeUp {
    from { opacity: 0; transform: translateY(16px); }
    to   { opacity: 1; transform: translateY(0); }
  }

  @keyframes pulse {
    0%, 100% { opacity: 1; }
    50%       { opacity: 0.3; }
  }

  .section:nth-child(1) { animation-delay: 0.1s; }
  .section:nth-child(2) { animation-delay: 0.15s; }
  .section:nth-child(3) { animation-delay: 0.2s; }
  .section:nth-child(4) { animation-delay: 0.25s; }
  .section:nth-child(5) { animation-delay: 0.3s; }
  .section:nth-child(6) { animation-delay: 0.35s; }
  .section:nth-child(7) { animation-delay: 0.4s; }
</style>
</head>
<body>
<div class="container">

  <!-- HEADER -->
  <header class="header">
    <div class="header-badge">Laboratory Assignments</div>
    <h1>Java<span>Programming</span></h1>
    <p class="header-sub">
      A comprehensive collection of Java lab exercises covering core and advanced programming concepts — from OOP fundamentals to file I/O and custom packages.
    </p>
    <div class="header-meta">
      <span class="meta-pill"><span class="dot" style="background:#00d4ff"></span>7 Topics</span>
      <span class="meta-pill"><span class="dot" style="background:#7c3aed"></span>40+ Programs</span>
      <span class="meta-pill"><span class="dot" style="background:#10b981"></span>JDK 8+</span>
    </div>
  </header>

  <!-- TOC -->
  <div class="toc">
    <div class="toc-title">// Contents</div>
    <div class="toc-grid">
      <a href="#s1" class="toc-item"><span class="toc-num">01</span><span class="toc-dot" style="background:#00d4ff;border-radius:2px"></span><span class="toc-label">OOP Basics</span></a>
      <a href="#s2" class="toc-item"><span class="toc-num">02</span><span class="toc-dot" style="background:#7c3aed;border-radius:2px"></span><span class="toc-label">Decision-Making Statements</span></a>
      <a href="#s3" class="toc-item"><span class="toc-num">03</span><span class="toc-dot" style="background:#10b981;border-radius:2px"></span><span class="toc-label">Looping Constructs</span></a>
      <a href="#s4" class="toc-item"><span class="toc-num">04</span><span class="toc-dot" style="background:#f59e0b;border-radius:2px"></span><span class="toc-label">Advanced OOP</span></a>
      <a href="#s5" class="toc-item"><span class="toc-num">05</span><span class="toc-dot" style="background:#f43f5e;border-radius:2px"></span><span class="toc-label">Exception Handling</span></a>
      <a href="#s6" class="toc-item"><span class="toc-num">06</span><span class="toc-dot" style="background:#34d399;border-radius:2px"></span><span class="toc-label">I/O Streams & File Handling</span></a>
      <a href="#s7" class="toc-item"><span class="toc-num">07</span><span class="toc-dot" style="background:#fcd34d;border-radius:2px"></span><span class="toc-label">User-Defined Packages</span></a>
    </div>
  </div>

  <!-- S1: OOP Basics -->
  <section class="section c1" id="s1" style="border:1px solid var(--border);border-radius:10px;padding:28px;">
    <div class="section-header">
      <div class="section-icon">☕</div>
      <div class="section-title-wrap">
        <div class="section-num">// 01</div>
        <h2>Object-Oriented Programming Basics</h2>
        <p class="section-desc">Classes, objects, constructors, and getter–setter methods demonstrating core Java encapsulation.</p>
      </div>
    </div>
    <div class="cards">
      <div class="card c1"><div class="card-name">Employee Salary</div><div class="card-desc">Calculate yearly salary and apply a 10% raise using class methods.</div><span class="card-tag">encapsulation</span></div>
      <div class="card c1"><div class="card-name">Rectangle Area</div><div class="card-desc">Calculate area of a rectangle using class-based methods.</div><span class="card-tag">class design</span></div>
      <div class="card c1"><div class="card-name">Static Members</div><div class="card-desc">Demonstrate static variables, methods, and static blocks.</div><span class="card-tag">static</span></div>
      <div class="card c1"><div class="card-name">Stack & Queue</div><div class="card-desc">Implement classic stack and queue data structure operations.</div><span class="card-tag">data structures</span></div>
      <div class="card c1"><div class="card-name">Name Sorter</div><div class="card-desc">Arrange a list of names in alphabetical order.</div><span class="card-tag">sorting</span></div>
    </div>
    <div class="concepts">
      <span class="concept-chip">Encapsulation</span>
      <span class="concept-chip">Object Creation</span>
      <span class="concept-chip">Constructors</span>
      <span class="concept-chip">Getter / Setter</span>
    </div>
  </section>

  <!-- S2: Decision Making -->
  <section class="section c2" id="s2" style="border:1px solid var(--border);border-radius:10px;padding:28px;">
    <div class="section-header">
      <div class="section-icon">🔀</div>
      <div class="section-title-wrap">
        <div class="section-num">// 02</div>
        <h2>Decision-Making Statements</h2>
        <p class="section-desc">Control execution flow using <code style="color:#a78bfa;font-size:11px">if</code>, <code style="color:#a78bfa;font-size:11px">if-else</code>, <code style="color:#a78bfa;font-size:11px">if-else-if</code>, and <code style="color:#a78bfa;font-size:11px">switch</code>.</p>
      </div>
    </div>
    <div class="cards">
      <div class="card c2"><div class="card-name">Sign Checker</div><div class="card-desc">Check whether a number is positive, negative, or zero.</div><span class="card-tag">if-else</span></div>
      <div class="card c2"><div class="card-name">Even / Odd</div><div class="card-desc">Determine whether a number is even or odd.</div><span class="card-tag">if-else</span></div>
      <div class="card c2"><div class="card-name">Vowel / Consonant</div><div class="card-desc">Identify whether a character is a vowel or consonant.</div><span class="card-tag">switch</span></div>
      <div class="card c2"><div class="card-name">Largest of Three</div><div class="card-desc">Find the largest value among three given numbers.</div><span class="card-tag">if-else-if</span></div>
      <div class="card c2"><div class="card-name">Leap Year</div><div class="card-desc">Check if a given year is a leap year.</div><span class="card-tag">if-else</span></div>
      <div class="card c2"><div class="card-name">Simple Calculator</div><div class="card-desc">Perform basic arithmetic using a switch statement.</div><span class="card-tag">switch</span></div>
    </div>
  </section>

  <!-- S3: Loops -->
  <section class="section c3" id="s3" style="border:1px solid var(--border);border-radius:10px;padding:28px;">
    <div class="section-header">
      <div class="section-icon">🔁</div>
      <div class="section-title-wrap">
        <div class="section-num">// 03</div>
        <h2>Looping Constructs</h2>
        <p class="section-desc"><code style="color:#6ee7b7;font-size:11px">for</code>, <code style="color:#6ee7b7;font-size:11px">while</code>, and <code style="color:#6ee7b7;font-size:11px">do-while</code> loops with <code style="color:#6ee7b7;font-size:11px">break</code>, <code style="color:#6ee7b7;font-size:11px">continue</code>, and <code style="color:#6ee7b7;font-size:11px">return</code> flow control.</p>
      </div>
    </div>
    <div class="cards">
      <div class="card c3"><div class="card-name">Sum of Naturals</div><div class="card-desc">Calculate the sum of natural numbers.</div><span class="card-tag">for</span></div>
      <div class="card c3"><div class="card-name">Alphabet Printer</div><div class="card-desc">Print alphabets A to Z using a loop.</div><span class="card-tag">for</span></div>
      <div class="card c3"><div class="card-name">Factorial</div><div class="card-desc">Find the factorial of a given number.</div><span class="card-tag">while</span></div>
      <div class="card c3"><div class="card-name">Multiplication Table</div><div class="card-desc">Generate a full multiplication table.</div><span class="card-tag">for</span></div>
      <div class="card c3"><div class="card-name">Fibonacci Series</div><div class="card-desc">Print the Fibonacci sequence up to N terms.</div><span class="card-tag">while</span></div>
      <div class="card c3"><div class="card-name">Number Reversal</div><div class="card-desc">Reverse the digits of a given number.</div><span class="card-tag">do-while</span></div>
      <div class="card c3"><div class="card-name">Palindrome Check</div><div class="card-desc">Check if a number reads the same forwards and backwards.</div><span class="card-tag">loop</span></div>
      <div class="card c3"><div class="card-name">Prime Checker</div><div class="card-desc">Determine whether a number is prime.</div><span class="card-tag">break</span></div>
    </div>
  </section>

  <!-- S4: Advanced OOP -->
  <section class="section c4" id="s4" style="border:1px solid var(--border);border-radius:10px;padding:28px;">
    <div class="section-header">
      <div class="section-icon">🧬</div>
      <div class="section-title-wrap">
        <div class="section-num">// 04</div>
        <h2>Advanced OOP Concepts</h2>
        <p class="section-desc">Interfaces, inheritance, and abstract classes applied to real-world program structures.</p>
      </div>
    </div>
    <div class="cards">
      <div class="card c4"><div class="card-name">Stack via Interface</div><div class="card-desc">Implement stack operations by defining and using a custom interface.</div><span class="card-tag">interface</span></div>
      <div class="card c4"><div class="card-name">Shape Interface</div><div class="card-desc">Rectangle and Triangle classes implement a Shape interface to calculate areas.</div><span class="card-tag">interface</span></div>
      <div class="card c4"><div class="card-name">Student Result System</div><div class="card-desc">Student, Test, and Result classes using inheritance and a Sports interface.</div><span class="card-tag">inheritance</span></div>
      <div class="card c4"><div class="card-name">Abstract Shape</div><div class="card-desc">Rectangle and Triangle subclasses implement abstract methods of a Shape base class.</div><span class="card-tag">abstract</span></div>
    </div>
    <div class="concepts">
      <span class="concept-chip">Interface</span>
      <span class="concept-chip">Inheritance</span>
      <span class="concept-chip">Abstract Class</span>
      <span class="concept-chip">Polymorphism</span>
    </div>
  </section>

  <!-- S5: Exception Handling -->
  <section class="section c5" id="s5" style="border:1px solid var(--border);border-radius:10px;padding:28px;">
    <div class="section-header">
      <div class="section-icon">⚠️</div>
      <div class="section-title-wrap">
        <div class="section-num">// 05</div>
        <h2>Exception Handling</h2>
        <p class="section-desc">Try-catch blocks and user-defined exceptions to handle invalid program states gracefully.</p>
      </div>
    </div>
    <table class="prog-table" style="background:var(--surface);border:1px solid var(--border);border-radius:6px;overflow:hidden">
      <thead>
        <tr>
          <th>Program</th>
          <th>Custom Exceptions</th>
          <th>Description</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td class="name-cell">Bank Account</td>
          <td><span class="exc-tag">LowBalanceException</span><span class="exc-tag">NegativeNumberException</span></td>
          <td>Handles invalid deposit, withdrawal, and balance enquiry operations.</td>
        </tr>
        <tr>
          <td class="name-cell">Odd Number Validator</td>
          <td><span class="exc-tag">OddNumberException</span></td>
          <td>Thrown when an odd number is passed to a method expecting an even value.</td>
        </tr>
        <tr>
          <td class="name-cell">Calculator</td>
          <td><span class="exc-tag">DivisionException</span></td>
          <td>Raised when attempting to divide by zero.</td>
        </tr>
      </tbody>
    </table>
  </section>

  <!-- S6: I/O -->
  <section class="section c6" id="s6" style="border:1px solid var(--border);border-radius:10px;padding:28px;">
    <div class="section-header">
      <div class="section-icon">📂</div>
      <div class="section-title-wrap">
        <div class="section-num">// 06</div>
        <h2>I/O Streams &amp; File Handling</h2>
        <p class="section-desc">Reading, writing, and analyzing files using Java's built-in stream and reader classes.</p>
      </div>
    </div>
    <table class="prog-table" style="background:var(--surface);border:1px solid var(--border);border-radius:6px;overflow:hidden">
      <thead>
        <tr><th>Program</th><th>Classes Used</th><th>Description</th></tr>
      </thead>
      <tbody>
        <tr>
          <td class="name-cell">File Reader</td>
          <td><span class="class-tag">FileInputStream</span></td>
          <td>Read data from a plain text file using byte streams.</td>
        </tr>
        <tr>
          <td class="name-cell">Student Data Store</td>
          <td><span class="class-tag">DataOutputStream</span><span class="class-tag">DataInputStream</span></td>
          <td>Store and retrieve structured student records from a binary file.</td>
        </tr>
        <tr>
          <td class="name-cell">Text Analyzer</td>
          <td><span class="class-tag">FileReader</span><span class="class-tag">BufferedReader</span></td>
          <td>Count vowels, words, and occurrences of a specific character in a file.</td>
        </tr>
      </tbody>
    </table>
  </section>

  <!-- S7: Packages -->
  <section class="section c7" id="s7" style="border:1px solid var(--border);border-radius:10px;padding:28px;">
    <div class="section-header">
      <div class="section-icon">📦</div>
      <div class="section-title-wrap">
        <div class="section-num">// 07</div>
        <h2>User-Defined Packages</h2>
        <p class="section-desc">Organizing programs into logical namespaces to improve code structure and maintainability.</p>
      </div>
    </div>
    <table class="prog-table" style="background:var(--surface);border:1px solid var(--border);border-radius:6px;overflow:hidden">
      <thead>
        <tr><th>Package</th><th>Classes</th><th>Description</th></tr>
      </thead>
      <tbody>
        <tr>
          <td class="name-cell"><span class="pkg-tag">LibraryManagement</span></td>
          <td><span class="class-tag">Book</span><span class="class-tag">Member</span></td>
          <td>Manage library resources including books and member records.</td>
        </tr>
        <tr>
          <td class="name-cell"><span class="pkg-tag">Ecommerce</span></td>
          <td><span class="class-tag">Product</span><span class="class-tag">Customer</span><span class="class-tag">Order</span></td>
          <td>Handle product listings, customer accounts, and purchase orders.</td>
        </tr>
        <tr>
          <td class="name-cell"><span class="pkg-tag">MathOperations</span></td>
          <td><span class="class-tag">MathUtils</span></td>
          <td>Utility methods for <code style="color:#fcd34d;font-size:11px">floor</code>, <code style="color:#fcd34d;font-size:11px">ceil</code>, and <code style="color:#fcd34d;font-size:11px">round</code> operations.</td>
        </tr>
      </tbody>
    </table>
  </section>

  <hr class="divider">

  <!-- SETUP -->
  <section class="section" id="setup" style="animation-delay:0.45s">
    <div class="section-header">
      <div class="section-icon" style="background:rgba(100,116,139,0.12)">⚙️</div>
      <div class="section-title-wrap">
        <div class="section-num">// Setup</div>
        <h2>Prerequisites &amp; Running Programs</h2>
      </div>
    </div>
    <div class="setup-grid">
      <div class="setup-card">
        <h3>Requirements</h3>
        <div class="code-block">
          <span class="comment">// Java Development Kit</span><br>
          JDK <span class="arg">8</span> or higher<br><br>
          <span class="comment">// IDE (any of)</span><br>
          <span class="cmd">IntelliJ IDEA</span><br>
          <span class="cmd">Eclipse</span><br>
          <span class="cmd">VS Code</span> + Extension Pack
        </div>
      </div>
      <div class="setup-card">
        <h3>Compile &amp; Run</h3>
        <div class="code-block">
          <span class="comment"># Compile</span><br>
          <span class="cmd">javac</span> <span class="arg">FileName.java</span><br><br>
          <span class="comment"># Run</span><br>
          <span class="cmd">java</span> <span class="arg">FileName</span><br><br>
          <span class="comment"># With packages</span><br>
          <span class="cmd">javac</span> <span class="arg">pkg/File.java</span><br>
          <span class="cmd">java</span> <span class="arg">pkg.FileName</span>
        </div>
      </div>
    </div>
  </section>

  <div class="footer">
    Java Lab Assignments &nbsp;·&nbsp; Object-Oriented Programming
  </div>

</div>
</body>
</html>
