package com.drwdom.components;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.drwdom.constants.TetrisEngineConstants;
import com.drwdom.model.Grid;
import com.drwdom.model.pieces.Piece;

/**
 * The GridHelper class contains helper methods for various grid operations,
 * including placing pieces, checking for block collisions, clearing full rows,
 * and calculating the height of the grid.
 */
@Component
class GridHelper {

    /**
     * Places a piece on the grid at the appropriate row.
     *
     * @param grid the tetris grid
     * @param piece the piece to be placed on the grid
     */
    public void placePiece(Grid grid, Piece piece) {
        int row = 0;
        while (row + piece.getHeight() < grid.getHeight()) {
            int[][] coordinates = piece.getCoordinates(row);
            Arrays.sort(coordinates, Comparator.comparingInt((int[] coord) -> coord[0]).reversed());
            if (isAnyBlockDetectedBelow(grid, coordinates)) {
                break;
            }
            row++;
        }
        grid.setPiece(row, piece);
    }

    /**
     * Checks if there is any block detected below the given coordinates in the grid.
     *
     * @param grid the tetris grid
     * @param coordinates the coordinates of the piece to check 
     * @return true if a block is detected below the given coordinates, false otherwise
     */
    public boolean isAnyBlockDetectedBelow(Grid grid, int[][] coordinates) {
        // A set to keep track of checked columns to avoid redundant checks
        Set<Integer> checkedColumns = new HashSet<>();
        // Iterate through each coordinate
        for (int[] coord : coordinates) {
            // Calculate the row number below the current coordinate
            int belowRowNum = coord[0] + 1;
            int col = coord[1];
            // Skip columns that have already been checked
            if (checkedColumns.contains(col)) {
                continue;
            }
            // Add the current column to the set of checked columns
            checkedColumns.add(col);
            // Check if the cell below the current coordinate is not empty
            if (grid.getGrid()[belowRowNum][col] != TetrisEngineConstants.EMPTY) {
                return true; // Block detected
            }
        }
        return false; // No block detected
    }

    /**
     * Clears full rows in the grid and shifts rows down if necessary.
     *
     * @param grid the tetris grid
     */
    public void clearFullRows(Grid grid) {
        // Iterate from the bottom row to the top row
        for (int i = grid.getHeight() - 1; i >= 0; i--) {
            // Check if the current row is full
            if (isRowFull(grid, i)) {
                // Shift all rows above the current row down by one position
                IntStream.iterate(i, k -> k > 0, k -> k - 1)
                        .forEach(k -> grid.getGrid()[k] = grid.getGrid()[k - 1]);
                // Fill the top row of the grid with EMPTY
                Arrays.fill(grid.getGrid()[0], TetrisEngineConstants.EMPTY);
                // Re-check the same row index after shifting
                i++;
            }
        }
    }

    /**
     * Checks if a row in the grid is full.
     *
     * @param grid the tetris grid
     * @param row the row index to check
     * @return true if the row is full, false otherwise
     */
    private boolean isRowFull(Grid grid, int row) {
        return IntStream.range(0, grid.getWidth())
                .allMatch(col -> grid.getGrid()[row][col] != TetrisEngineConstants.EMPTY);
    }

    /**
     * Calculates the height of the grid by counting non-empty rows, iterating from bottom to top.
     *
     * @param grid the tetris grid
     * @return the height of the grid (number of non-empty rows)
     */
    public int calculateHeight(Grid grid) {
        return (int) IntStream.iterate(grid.getHeight() - 1, i -> i >= 0, i -> i - 1)
                .filter(i -> IntStream.range(0, grid.getWidth())
                        .anyMatch(j -> grid.getGrid()[i][j] != TetrisEngineConstants.EMPTY))
                .count();
    }
}
