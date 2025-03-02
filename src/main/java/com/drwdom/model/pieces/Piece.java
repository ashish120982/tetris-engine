package com.drwdom.model.pieces;

import lombok.Getter;

/**
 * Represents an abstract Tetris piece with a defined column position.
 * Each specific Tetris piece (e.g., I, J, L) extends this class and provides
 * its unique implementation for shape, coordinates, and height.
 */
@Getter
public abstract class Piece {

    /**
     * The initial column position of the Tetris piece on the grid.
     */
    protected final int column;

    /**
     * Constructs a Tetris piece with the specified initial column position.
     *
     * @param column The initial column index where the piece is placed.
     */
    public Piece(int column) {
        this.column = column;
    }

    /**
     * Retrieves the coordinates of the Tetris piece based on a starting row.
     *
     * @param row The starting row index for the piece's position.
     * @return A 2D array of integers representing the coordinates of the piece on the grid.
     */
    public abstract int[][] getCoordinates(int row);

    /**
     * Returns the character that represents the shape of the Tetris piece.
     *
     * @return A character identifier for the piece (e.g., 'I', 'J', 'L').
     */
    public abstract char getShape();

    /**
     * Returns the height of the Tetris piece, representing the number of rows it spans.
     *
     * @return An integer representing the height of the piece.
     */
    public abstract int getHeight();
}
