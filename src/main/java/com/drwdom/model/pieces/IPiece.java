package com.drwdom.model.pieces;

/**
 * Represents the 'I' Tetris piece, which is a straight line that spans 4 columns.
 */
public class IPiece extends Piece {

    /**
     * Constructs an I-shaped Tetris piece at the specified initial column position.
     *
     * @param column The initial column position of the piece on the grid.
     */
    public IPiece(int column) {
        super(column);
    }

    /**
     * Returns the coordinates of the 'I' piece based on the starting row.
     * The piece spans a single row across four consecutive columns.
     *
     * @param row The starting row index where the piece is positioned.
     * @return A 2D array representing the coordinates of the 'I' piece on the grid.
     */
    @Override
    public int[][] getCoordinates(int row) {
        return new int[][] {
            {row, column},
            {row, column + 1},
            {row, column + 2},
            {row, column + 3}
        };
    }

    /**
     * Returns the character representation of the 'I' piece.
     *
     * @return 'I' as the shape identifier of the piece.
     */
    @Override
    public char getShape() {
        return 'I';
    }

    /**
     * Returns the height of the 'I' piece, which is always 1 since it spans a single row.
     *
     * @return 1, representing the height of the piece.
     */
    @Override
    public int getHeight() {
        return 1;
    }
}
