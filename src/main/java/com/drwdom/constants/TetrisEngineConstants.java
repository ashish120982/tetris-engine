package com.drwdom.constants;

/**
 * TetrisEngineConstants contains application-wide constants for the Tetris
 * Engine, such as grid dimensions and symbols for representing grid cells.
 */
public final class TetrisEngineConstants {

    private TetrisEngineConstants() {
        // Private constructor to prevent instantiation
    }

    // Grid dimensions for the Tetris game
    public static final int GRID_WIDTH = 10;  // Standard width for the grid
    public static final int GRID_HEIGHT = 100;  // Maximum height for the grid

    // Represents an empty grid cell
    public static final char EMPTY = '.';  
}
