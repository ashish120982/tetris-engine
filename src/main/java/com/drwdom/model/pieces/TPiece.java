package com.drwdom.model.pieces;

/**
 * Represents the 'T' Tetris piece, which is shaped like a horizontal row of three blocks
 * with one additional block extending downwards in the middle column.
 */
public class TPiece extends Piece {

    /**
     * Constructs a T-shaped Tetris piece at the specified initial column position.
     *
     * @param column The initial column position of the piece on the grid.
     */
    public TPiece(int column) {
        super(column);
    }

    /**
     * Returns the coordinates of the 'T' piece based on the starting row.
     * The piece consists of three blocks on the top row and one block
     * extending downwards in the middle column.
     *
     * @param row The starting row index where the piece is positioned.
     * @return A 2D array representing the coordinates of the 'T' piece on the grid.
     */
    @Override
    public int[][] getCoordinates(int row) {
        return new int[][] {
            {row, column},
            {row, column + 1},
            {row, column + 2},
            {row + 1, column + 1}
        };
    }

    /**
     * Returns the character representation of the 'T' piece.
     *
     * @return 'T' as the shape identifier of the piece.
     */
    @Override
    public char getShape() {
        return 'T';
    }

    /**
     * Returns the height of the 'T' piece, which is 2, as it spans two rows.
     *
     * @return 2, representing the height of the piece.
     */
    @Override
    public int getHeight() {
        return 2;
    }
}
