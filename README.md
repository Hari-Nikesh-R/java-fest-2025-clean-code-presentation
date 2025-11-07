# Better Java for 2025 and Beyond

A hands-on, interactive, and future-focused Java presentation designed for beginners who want to move from writing code that works → writing code that's clean, efficient, and scalable.

## 📋 Overview

This is a Reveal.js presentation with 6 main segments plus a bonus section, covering Java best practices from basics to modern features.

**Total Duration:** 90 Minutes  
**Level:** Beginner

## 🗂️ Project Structure

```
java-fest-preparation/
├── index.html                 # Main navigation page
├── segment1.html             # Warm-Up: Why Better Java Matters
├── segment2.html             # Getting Back to Basics
├── segment3.html             # Object-Oriented Thinking
├── segment4.html             # From Logic to Clean Code
├── segment5.html             # Modern Java Features
├── segment6.html             # The Java Developer Mindset
├── bonus.html                # Refactoring Challenge
├── css/
│   └── custom.css            # Custom styling
├── js/
│   └── config.js             # Reveal.js configuration
└── code-examples/            # All Java code examples
    ├── BadExample.java
    ├── GoodExample.java
    ├── NamingExamples.java
    ├── ImmutabilityDemo.java
    ├── PrimitiveWrapperDemo.java
    ├── MessyCode.java
    ├── CohesionCouplingDemo.java
    ├── EncapsulationExample.java
    ├── MethodDesign.java
    ├── ErrorHandling.java
    ├── LoggingExample.java
    ├── BuggyMethod.java
    ├── ModernJavaFeatures.java
    ├── LoopToStream.java
    ├── RecordExample.java
    ├── PatternMatching.java
    ├── TestableCode.java
    ├── JUnitExample.java
    ├── RefactoringChallenge.java
    ├── RefactoringChallengeSolution.java
    └── LibraryManagement/
        ├── Book.java
        ├── Member.java
        ├── Library.java
        └── LibraryDemo.java
```

## Setup Instructions

### Prerequisites

- A modern web browser (Chrome, Firefox, Safari, Edge)
- Java 17 or above (for running code examples)
- A text editor or IDE (IntelliJ IDEA, VS Code, etc.)

### Running the Presentation

1. **Clone or download this repository**

2. **Open the presentation:**
   - Simply open `index.html` in your web browser
   - Or use a local web server:
     ```bash
     # Using Python 3
     python -m http.server 8000
     
     # Using Python 2
     python -m SimpleHTTPServer 8000
     
     # Using Node.js (http-server)
     npx http-server
     ```
   - Then navigate to `http://localhost:8000` in your browser

3. **Navigation:**
   - Use arrow keys or click navigation buttons to move between slides
   - Press `ESC` to see slide overview
   - Press `F` for fullscreen mode
   - Press `S` for speaker notes (if available)

## 💻 Running Java Code Examples

### Compiling and Running Individual Files

For simple examples (no packages):

```bash
# Compile
javac code-examples/Filename.java

# Run
java -cp code-examples Filename
```

### Running Package Examples

For the LibraryManagement package:

```bash
# Navigate to code-examples directory
cd code-examples

# Compile all files in the package
javac LibraryManagement/*.java

# Run the demo
java LibraryManagement.LibraryDemo
```

### Using an IDE

1. **IntelliJ IDEA:**
   - Open the project folder
   - Mark `code-examples` as source root
   - Right-click any `.java` file → Run

2. **VS Code:**
   - Install Java Extension Pack
   - Open any `.java` file
   - Click "Run" button or use F5

3. **Eclipse:**
   - Import project as Java project
   - Run configurations will be auto-detected

## 📚 Presentation Segments

### 1️⃣ Warm-Up: Why "Better Java" Matters (10 mins)
- Java's current state in 2025
- Code longevity and maintainability
- Common beginner mistakes
- **Code Examples:** `BadExample.java`, `GoodExample.java`

### 2️⃣ Getting Back to Basics (20 mins)
- Proper variable naming and scoping
- Understanding immutability
- Primitive vs Wrapper classes
- **Code Examples:** `NamingExamples.java`, `ImmutabilityDemo.java`, `PrimitiveWrapperDemo.java`, `MessyCode.java`

### 3️⃣ Object-Oriented Thinking (25 mins)
- Cohesion & Coupling
- Encapsulation
- DRY principle
- **Code Examples:** `CohesionCouplingDemo.java`, `EncapsulationExample.java`, `LibraryManagement/` package

### 4️⃣ From Logic to Clean Code (20 mins)
- Code formatting & indentation
- Method design (single responsibility)
- Error handling best practices
- Logging vs System.out.println()
- **Code Examples:** `MethodDesign.java`, `ErrorHandling.java`, `LoggingExample.java`, `BuggyMethod.java`

### 5️⃣ Modern Java Features (15 mins)
- `var` keyword and type inference
- Enhanced switch expressions
- Records for lightweight data holders
- Pattern matching
- Stream API
- **Code Examples:** `ModernJavaFeatures.java`, `LoopToStream.java`, `RecordExample.java`, `PatternMatching.java`

### 6️⃣ The Java Developer Mindset (15 mins)
- Writing testable code
- Git & Version Control
- Reading JavaDocs
- Following style guides
- Continuous learning
- **Code Examples:** `TestableCode.java`, `JUnitExample.java`

### 🎁 Bonus: Refactoring Challenge
- Old Java code refactoring exercise
- Modern Java 21 solution
- **Code Examples:** `RefactoringChallenge.java`, `RefactoringChallengeSolution.java`

## 🎨 Customization

### Changing Theme

The presentation uses Reveal.js white theme. To change it:

1. Edit any segment HTML file
2. Change the theme link:
   ```html
   <!-- Current -->
   <link rel="stylesheet" href=".../theme/white.css">
   
   <!-- Alternatives -->
   <link rel="stylesheet" href=".../theme/black.css">
   <link rel="stylesheet" href=".../theme/league.css">
   <link rel="stylesheet" href=".../theme/beige.css">
   ```

### Custom Styling

Edit `css/custom.css` to modify:
- Colors and fonts
- Code block styling
- Slide layouts
- Activity boxes

## 📝 Notes for Presenters

1. **Code Examples:** All code examples are runnable. Test them before presenting.

2. **Timing:** Each segment has suggested timing, but adjust based on audience.

3. **Activities:** Encourage audience participation in refactoring exercises.

4. **Modern Java:** Ensure you're using Java 17+ to run all modern examples.

5. **Interactive Elements:** Use the discussion questions to engage the audience.

## 🛠️ Troubleshooting

### Code Examples Won't Compile

- **Check Java version:** `java -version` (should be 17+)
- **Check package structure:** Ensure package declarations match folder structure
- **Check imports:** Some examples may need additional dependencies

### Presentation Not Loading

- **Check browser console:** Look for JavaScript errors
- **Try different browser:** Some features may vary
- **Check internet connection:** Reveal.js and highlight.js load from CDN

### Syntax Highlighting Not Working

- Ensure internet connection (highlight.js loads from CDN)
- Check browser console for errors
- Try refreshing the page

## 📖 Learning Resources

### Books
- **Effective Java** by Joshua Bloch
- **Clean Code** by Robert C. Martin
- **Java: The Complete Reference** by Herbert Schildt

### Online Resources
- [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- [Baeldung Java Guides](https://www.baeldung.com/java)
- [JavaWorld](https://www.javaworld.com/)

### Style Guides
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- [Oracle Code Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)

