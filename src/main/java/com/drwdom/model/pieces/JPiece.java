package com.drwdom.model.pieces;

/**
 * Represents the 'J' Tetris piece, which has a vertical line of three blocks with an additional block at the bottom-left.
 */
public class JPiece extends Piece {

    /**
     * Constructs a J-shaped Tetris piece at the specified initial column position.
     *
     * @param column The initial column position of the piece on the grid.
     */
    public JPiece(int column) {
        super(column);
    }

    /**
     * Returns the coordinates of the 'J' piece based on the starting row.
     * The piece consists of a vertical line of three blocks and one block
     * extending to the left at the bottom.
     *
     * @param row The starting row index where the piece is positioned.
     * @return A 2D array representing the coordinates of the 'J' piece on the grid.
     */
    @Override
    public int[][] getCoordinates(int row) {
        return new int[][] {
            {row, column + 1},
            {row + 1, column + 1},
            {row + 2, column + 1},
            {row + 2, column}
        };
    }

    /**
     * Returns the character representation of the 'J' piece.
     *
     * @return 'J' as the shape identifier of the piece.
     */
    @Override
    public char getShape() {
        return 'J';
    }

    /**
     * Returns the height of the 'J' piece, which is 3, since it spans three rows.
     *
     * @return 3, representing the height of the piece.
     */
    @Override
    public int getHeight() {
        return 3;
    }
}
