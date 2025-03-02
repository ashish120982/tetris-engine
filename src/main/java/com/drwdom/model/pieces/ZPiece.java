package com.drwdom.model.pieces;

/**
 * Represents the 'Z' Tetris piece, which is shaped like the letter "Z" and spans two rows.
 * This piece consists of two horizontally aligned blocks on the top row and two
 * horizontally aligned blocks on the bottom row, offset by one column.
 */
public class ZPiece extends Piece {

    /**
     * Constructs a Z-shaped Tetris piece at the specified initial column position.
     *
     * @param column The initial column position of the piece on the grid.
     */
    public ZPiece(int column) {
        super(column);
    }

    /**
     * Returns the coordinates of the 'Z' piece based on the starting row.
     * The piece consists of two blocks on the top row and two blocks
     * on the bottom row, offset to the right.
     *
     * @param row The starting row index where the piece is positioned.
     * @return A 2D array representing the coordinates of the 'Z' piece on the grid.
     */
    @Override
    public int[][] getCoordinates(int row) {
        return new int[][] {
            {row, column},
            {row, column + 1},
            {row + 1, column + 1},
            {row + 1, column + 2}
        };
    }

    /**
     * Returns the character representation of the 'Z' piece.
     *
     * @return 'Z' as the shape identifier of the piece.
     */
    @Override
    public char getShape() {
        return 'Z';
    }

    /**
     * Returns the height of the 'Z' piece, which is 2, as it spans two rows.
     *
     * @return 2, representing the height of the piece.
     */
    @Override
    public int getHeight() {
        return 2;
    }
}
