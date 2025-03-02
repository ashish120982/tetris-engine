package com.drwdom.model.pieces;

/**
 * Represents the 'Q' Tetris piece, which is a square block occupying two rows
 * and two columns on the grid.
 */
public class QPiece extends Piece {

    /**
     * Constructs a Q-shaped Tetris piece at the specified initial column position.
     *
     * @param column The initial column position of the piece on the grid.
     */
    public QPiece(int column) {
        super(column);
    }

    /**
     * Returns the coordinates of the 'Q' piece based on the starting row.
     * The piece occupies a 2x2 area on the grid.
     *
     * @param row The starting row index where the piece is positioned.
     * @return A 2D array representing the coordinates of the 'Q' piece on the grid.
     */
    @Override
    public int[][] getCoordinates(int row) {
        return new int[][] {
            {row, column},
            {row, column + 1},
            {row + 1, column},
            {row + 1, column + 1}
        };
    }

    /**
     * Returns the character representation of the 'Q' piece.
     *
     * @return 'Q' as the shape identifier of the piece.
     */
    @Override
    public char getShape() {
        return 'Q';
    }

    /**
     * Returns the height of the 'Q' piece, which is 2, as it spans two rows.
     *
     * @return 2, representing the height of the piece.
     */
    @Override
    public int getHeight() {
        return 2;
    }
}
