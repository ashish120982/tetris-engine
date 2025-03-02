package com.drwdom.model.pieces;

/**
 * Represents the 'L' Tetris piece, which consists of a vertical line of three blocks
 * and one additional block extending to the right at the bottom.
 */
public class LPiece extends Piece {

    /**
     * Constructs an L-shaped Tetris piece at the specified initial column position.
     *
     * @param column The initial column position of the piece on the grid.
     */
    public LPiece(int column) {
        super(column);
    }

    /**
     * Returns the coordinates of the 'L' piece based on the starting row.
     * The piece consists of a vertical line of three blocks and one block
     * extending to the right at the bottom.
     *
     * @param row The starting row index where the piece is positioned.
     * @return A 2D array representing the coordinates of the 'L' piece on the grid.
     */
    @Override
    public int[][] getCoordinates(int row) {
        return new int[][] {
            {row, column},
            {row + 1, column},
            {row + 2, column},
            {row + 2, column + 1}
        };
    }

    /**
     * Returns the character representation of the 'L' piece.
     *
     * @return 'L' as the shape identifier of the piece.
     */
    @Override
    public char getShape() {
        return 'L';
    }

    /**
     * Returns the height of the 'L' piece, which is 3, as it spans three rows.
     *
     * @return 3, representing the height of the piece.
     */
    @Override
    public int getHeight() {
        return 3;
    }
}
