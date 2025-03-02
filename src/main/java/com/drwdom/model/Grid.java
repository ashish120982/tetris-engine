package com.drwdom.model;

import java.util.Arrays;

import com.drwdom.constants.TetrisEngineConstants;
import com.drwdom.model.pieces.Piece;

import lombok.Getter;

/**
 * Represents the Tetris game grid and provides methods for initializing the grid
 * and placing Tetris pieces on it.
 */
@Getter
public class Grid {
    /**
     * The width of the grid (number of columns).
     */
    private final int width;

    /**
     * The height of the grid (number of rows).
     */
    private final int height;

    /**
     * The 2D character array representing the grid, where each cell can be empty or occupied by a piece.
     */
    private final char[][] grid;

    /**
     * Constructs a new Grid with the specified width and height.
     *
     * @param width  The width of the grid (number of columns).
     * @param height The height of the grid (number of rows).
     */
    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new char[height][width];
    }

    /**
     * Initializes the grid by filling all cells with the empty character defined
     * in {@link com.drwdom.constants.TetrisEngineConstants#EMPTY}.
     */
    public void initializeGrid() {
        Arrays.stream(grid).forEach(row -> Arrays.fill(row, TetrisEngineConstants.EMPTY));
    }

    /**
     * Places a Tetris piece onto the grid at the specified row.
     *
     * @param rowNumber The row index where the piece's placement starts.
     * @param piece     The Tetris piece to be placed on the grid.
     * @throws ArrayIndexOutOfBoundsException if the coordinates of the piece exceed the grid's bounds.
     */
    public void setPiece(int rowNumber, Piece piece) {
        int[][] coordinates = piece.getCoordinates(rowNumber);
        for (int[] coordinate : coordinates) {
            int row = coordinate[0];
            int col = coordinate[1];
            grid[row][col] = piece.getShape();
        }
    }
}
