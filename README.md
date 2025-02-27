# Tetris Engine

Welcome to the Tetris Engine! This project is a Java-based implementation of the classic Tetris game. The Tetris Engine reads input pieces from a file, processes them, and applies them to a grid.

## Table of Contents
1. [Introduction](#introduction)
2. [Features](#features)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Code Structure](#code-structure)

## Introduction
The Tetris Engine is designed to simulate the gameplay of Tetris. It reads a sequence of Tetris pieces from an input file and applies them to a grid, providing the final state of the grid as output. This project demonstrates clean code practices, SOLID principles, and modern Java features.

## Features
- Read Tetris pieces from a text file
- Apply pieces to a grid
- Clear full rows
- Output the final state of the grid
- Simple and modular code structure

## Installation
To run the Tetris Engine, you need to have Java installed on your machine. Follow these steps to set up the project:

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/tetris-engine.git
   cd tetris-engine

## Usage
To run the Tetris Engine, use the following command:
```sh
java -jar target/tetris-engine-1.0.jar

## Code Structure
The code is organized into the following packages:

- `com.drwdom`: Contains the main application class.
- `com.drwdom.components`: Contains the Tetris engine and grid helper classes.
- `com.drwdom.constants`: Contains the Tetris engine constants.
- `com.drwdom.factories`: Contains the factory class for creating input readers.
- `com.drwdom.model`: Contains the grid and piece model classes.
- `com.drwdom.model.pieces`: Contains the specific Tetris piece classes.
- `com.drwdom.reader`: Contains the input reader classes.

### Main Classes and Their Responsibilities
- `TetrisEngineApplication`: The entry point of the application. It reads the input file, processes the input using `TetrisEngine`, and prints the output.
- `TetrisEngine`: The core engine that applies pieces to the grid and manages the game logic.
- `GridHelper`: Provides helper methods for various grid operations, such as placing pieces and clearing full rows.
- `TextFileReader`: Reads input from a text file using modern Java features.
