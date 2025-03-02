package com.drwdom.components.api;

import com.drwdom.model.Grid;
import com.drwdom.model.pieces.Piece;

/**
 * Defines operations for interacting with and manipulating a Tetris grid.
 */
public interface IGridHelper {

    /**
     * Places a Tetris piece on the specified grid.
     *
     * @param grid  The grid where the piece will be placed.
     * @param piece The piece to be placed on the grid.
     */
    void placePiece(Grid grid, Piece piece);

    /**
     * Checks if any block is detected directly below the specified coordinates in the grid.
     *
     * @param grid        The grid to check.
     * @param coordinates The coordinates of the piece to check.
     * @return true if there is a block directly below, false otherwise.
     */
    boolean hasBlockBelow(Grid grid, int[][] coordinates);

    /**
     * Clears full rows in the grid and updates the grid state.
     *
     * @param grid The grid in which rows will be cleared.
     */
    void clearFullRows(Grid grid);

    /**
     * Calculates the current height of the Tetris grid (number of non-empty rows).
     *
     * @param grid The grid whose height will be calculated.
     * @return The height of the grid.
     */
    int calculateHeight(Grid grid);
}
