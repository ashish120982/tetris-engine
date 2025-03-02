# Tetris Engine

Welcome to the Tetris Engine! This project is a Java-based implementation of the classic Tetris game. The Tetris Engine reads input pieces from STDIN, processes them, and applies them to a grid and calculates the height of the grid after removing the full rows. The Tetris engine uses a grid that pieces enter from top and come to rest at the bottom, as if pulled down by gravity. Each piece is made up of four unit squares. No two unit squares can occupy the same space in the grid at the same time. The pieces are rigid, and come to rest as soon as any part of a piece contacts the bottom of the grid or any resting block. Whenever an entire row of the grid is filled, it disappears, and any higher rows drop into the vacated space without any change to the internal pattern of blocks in any row.

---

## Table of Contents
1. [Introduction](#introduction)
2. [Features](#features)
3. [Code Packages, Main Classes, and Their Responsibilities](#code-packages-main-classes-and-their-responsibilities)
4. [Architecture](#architecture)
5. [Prerequisites](#prerequisites)
6. [Usage](#usage)
7. [Complexity Analysis](#complexity-analysis)

---

## Introduction
The Tetris Engine is designed to simulate the game of Tetris. It reads a sequence of Tetris pieces from STDIN and applies them to a grid, providing the final height of the grid as output to STDOUT after removing the full rows.

---

## Features
- Reads a sequence of Tetris pieces from `STDIN`.
- Applies pieces to a grid, ensuring they fall due to gravity.
- Handles all standard Tetris pieces (`I`, `J`, `L`, `Q`, `S`, `T`, `Z`).
  - For example, `Q0` represents a square piece starting at column 0.
- Clears full rows and shifts rows above downward to fill cleared spaces.
- Outputs the final height of the grid after all pieces are placed and rows cleared.

---

## Code Packages, Main Classes, and Their Responsibilities

---

##### **1. Package: `com.drwdom.components.api`**
##### **Main Classes**
- **`IGridHelper`**
  - Defines the interface for helper methods used for manipulating the Tetris grid, such as placing pieces, clearing rows, etc.

- **`ITetrisEngine`**
  - Defines the interface for the core Tetris engine. Includes methods for processing piece placements and managing the grid state.

---

##### **2. Package: `com.drwdom.components.impl`**
##### **Main Classes**
- **`GridHelperImpl`**
  - Implements the `IGridHelper` interface.
  - Provides helper methods to:
    - Place Tetris pieces on the grid.
    - Detect blocks below a piece.
    - Clear full rows and shift rows down.

- **`TetrisEngineImpl`**
  - Implements the `ITetrisEngine` interface.
  - Processes input lines with Tetris piece placements.
  - Applies the pieces to the grid and calculates the resulting grid height.

---

##### **3. Package: `com.drwdom.constants`**
##### **Main Classes**
- **`TetrisEngineConstants`**
  - Centralizes constants for the Tetris engine:
    - Grid dimensions (`GRID_WIDTH`, `GRID_HEIGHT`).
    - Empty cell representation.

---

##### **4. Package: `com.drwdom.factories`**
##### **Main Classes**
- **`PieceFactory`**
  - Factory class responsible for creating instances of `Piece` subclasses (e.g., `IPiece`, `QPiece`) based on the shape identifier and initial column.

---

##### **5. Package: `com.drwdom.model`**
##### **Main Classes**
- **`Grid`**
  - Represents the Tetris grid.
  - Manages the internal 2D array structure and provides methods to initialize the grid and place pieces.

---

##### **6. Package: `com.drwdom.model.pieces`**
##### **Main Classes**
- **`Piece` (Abstract Class)**
  - The base class for all Tetris pieces.
  - Defines common attributes and methods:
    - Initial column position.
    - Abstract methods like `getCoordinates`, `getShape`, and `getHeight`.

- **Specific Piece Classes**:
  - **`IPiece`**: Represents the straight-line piece.
  - **`JPiece`**: Represents the "J"-shaped piece.
  - **`LPiece`**: Represents the "L"-shaped piece.
  - **`QPiece`**: Represents the square piece.
  - **`SPiece`**: Represents the "S"-shaped piece.
  - **`TPiece`**: Represents the "T"-shaped piece.
  - **`ZPiece`**: Represents the "Z"-shaped piece.
  - Each subclass implements the `Piece` methods for its unique shape, coordinates, and height.

---

##### **7. Package: `tests`**
##### **Main Classes**
- **`GridHelperImplTest`**
  - Unit tests for `GridHelperImpl`, verifying the functionality of methods like piece placement, row clearing, and height calculations.

- **`GridTest`**
  - Unit tests for the `Grid` class, ensuring the grid initialization and piece placement logic works as expected.

- **`TetrisEngineImplTest`**
  - Parameterized tests for the Tetris engine, covering input processing and final grid height calculation.

- **`PieceFactoryTest`**
  - Unit tests for the `PieceFactory`, verifying correct creation of each Tetris piece and handling of invalid shapes.

- **`AllPiecesTest`**
  - Parameterized tests for all piece classes (`IPiece`, `JPiece`, etc.), ensuring shape identifiers and coordinates match expectations.

---

##### **8. Package: `com.drwdom`**
##### **Main Class**
- **`TetrisEngineApplication`**
  - The main entry point of the Tetris Engine project.
  - Reads input, processes it using `TetrisEngineImpl`, and outputs the resulting grid height.

---

## Architecture

The project is organized with a focus on modularity:

- **Core Components**:
  - `Grid`: Represents the Tetris grid.
  - `Piece` and its subclasses (`IPiece`, `JPiece`, etc.): Represent individual Tetris pieces with specific shapes and behaviors.
  - `GridHelper`: Provides utility methods for grid manipulation, such as placing pieces and clearing rows.
  - `TetrisEngine`: Processes input, applies pieces to the grid, and calculates results.

- **Factories**:
  - `PieceFactory`: Creates instances of Tetris pieces based on the input.

- **Constants**:
  - Centralized in `TetrisEngineConstants` for grid dimensions and cell states.

---

## Prerequisites

To run this project, ensure you have:

- **Java 11 or higher**
- A build tool like **Maven** or **Gradle** (optional for dependency management)

---

## Usage

Follow these steps to compile, run, and interact with the Tetris Engine application.

---

##### 1. Compile the Project

Use the following command to compile all Java files within the `src/` directory:

```bash
javac -d bin $(find src -name "*.java")
```

---

##### 2. Run the Application

To start the Tetris Engine application, use the following command:

```bash
java -cp bin com.drwdom.TetrisEngineApplication
```

---

##### 3. Provide Input

The application reads input from **standard input (STDIN)**. Each input line should specify a sequence of Tetris piece placements:
- Each piece placement is represented in the format **`ShapeColumn`**, where:
  - `Shape`: A character indicating the type of Tetris piece (`I`, `J`, `L`, `Q`, `S`, `T`, `Z`).
  - `Column`: A 0-based column index representing the starting position of the piece.
- Pieces on the same line should be comma-separated.

 **Example Input:**

	Q0,Q1
	Q0,Q2,Q4,Q6,Q8
	Q0,Q2,Q4,Q6,Q8,Q1
	
 **Explanation of Input**:
  - Line 1: Places three square (`Q`) pieces at columns 0, 2, and 4, respectively.
  - Line 2: Places one `T` piece at column 1, one `Z` piece at column 3, and one `I` piece at column 4.
  - Line 3: Places one `L` piece at column 0, one `J` piece at column 2, and so on.

---

##### 4. View Output

The program outputs the resulting grid height after each line of input is processed. The output is displayed in **standard output (STDOUT)**.

 **Example Output:**

	4
	0
	2
	
 **Explanation of Output**:
  - Line 1 Output (`2`): After processing `Q0,Q2,Q4`, the final grid height is 2.
  - Line 2 Output (`4`): After processing `T1,Z3,I4`, the final grid height is 4.
  - Line 3 Output (`3`): After processing `L0,J2,L4,J6,Q8`, the final grid height is 3.

---

##### 5. Testing the Application

The project includes comprehensive unit tests to validate its behavior. Use the following commands to execute the test suite (if using Maven):

```bash
mvn test
```

This command runs all tests and displays the results in your terminal. The tests ensure that:
- Pieces are placed correctly on the grid.
- Full rows are cleared, and the above rows shift down.
- Grid height calculations are accurate.

---

##### 6. Debugging Tips

- **Input Format**:
  Ensure the input strictly follows the `ShapeColumn` format. For instance, an input like `Q-1` (negative column) will likely cause an error.
  
- **Class Not Found**:
  If you encounter a "Class Not Found" error, double-check the `-cp` argument and ensure all `.class` files are in the `bin/` directory.

- **Dependencies**:
  If you added any external dependencies, ensure they are correctly included in your classpath.

---

##### 7. Key Features to Explore

While running the application, try exploring:
- Placing pieces to test full-row clearance (e.g., filling the bottom-most row completely).
- Using different combinations of shapes and observing how they stack on the grid.
- Testing edge cases like pieces starting at the far-left or far-right columns.

---

##### Input Format

Input is provided via standard input (`STDIN`). Each line represents a series of Tetris piece placements, where:
- Each piece placement is represented as `ShapeColumn` (e.g., `Q0`, `T3`).
- Pieces are comma-separated (e.g., `Q0,Q2,Q4`).

Example Input: 
	Q0,Q2,Q4

---

##### Output Format

The output is provided via standard output (`STDOUT`). Each line represents the resulting grid height after processing the corresponding input line.

Example Output: 
	2

---

## Complexity Analysis

---

**1. Grid Operations**
- **Placing Pieces (`GridHelperImpl#placePiece`)**:
  - The piece's coordinates are iterated row by row to find the lowest possible placement.
  - **Time Complexity**:
    - Worst-case scenario: Iterating through all rows (`O(height)`), with additional constant-time operations for checking cells (`O(1)` per cell).
    - Overall complexity: **O(height × width)** for large grids.

- **Row Clearing (`GridHelperImpl#clearFullRows`)**:
  - Each row is checked for fullness.
  - Rows above a cleared row are shifted down.
  - **Time Complexity**:
    - Checking rows: **O(height × width)**.
    - Shifting rows down: **O(height × width)** in the worst case.
    - Overall: **O(height × width)**.

- **Calculating Height (`GridHelperImpl#calculateHeight`)**:
  - Iterates through rows to determine the first non-empty one.
  - **Time Complexity**: **O(height × width)**.

---

**2. Piece Factory and Piece Operations**
- **Piece Creation (`PieceFactory#createPiece`)**:
  - Selection of the correct `Piece` implementation is handled via a `switch` statement.
  - **Time Complexity**: **O(1)**.

- **Coordinate Retrieval (`Piece#getCoordinates`)**:
  - Predefined for each type of piece; calculations are constant-time.
  - **Time Complexity**: **O(1)**.

---

**3. Input Processing**
- **Parsing Input (`TetrisEngineImpl#applyPieces`)**:
  - Tokenizes the input line into individual piece placements and processes each one sequentially.
  - **Time Complexity**:
    - Parsing each line: **O(k)**, where `k` is the length of the input string.
    - Processing pieces: Dependent on grid operations, so this is **O(height × width)** for each piece.

- **Overall Complexity**: For `n` input lines and `m` pieces per line:
  - Parsing: **O(n × k)**.
  - Placing pieces: **O(n × m × height × width)** in the worst case.

---

**4. Total Complexity**
The total complexity depends on the number of input lines, pieces per line, and grid dimensions. In the worst-case scenario:
- Input lines: **n**.
- Pieces per line: **m**.
- Grid height and width: **h** and **w**.

**Overall Time Complexity**: **O(n × m × h × w)**.

---

**Space Complexity**
- **Grid Representation**:
  - The grid is stored as a 2D array of size **h × w**.
  - **Space Complexity**: **O(h × w)**.

- **Auxiliary Space**:
  - Piece coordinates and temporary variables use constant space.
  - Input parsing and tokenization are proportional to the input size.

**Overall Space Complexity**: **O(h × w)**.
