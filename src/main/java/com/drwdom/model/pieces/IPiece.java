package com.drwdom.model.pieces;

public class IPiece extends Piece {

    public IPiece(int column) {
        super(column);
    }

    @Override
    public int[][] getCoordinates(int row) {
        return new int[][] {
            {row, column},
            {row, column + 1},
            {row, column + 2},
            {row, column + 3}
        };
    }

    @Override
    public char getShape() {
        return 'I';
    }

    @Override
    public int getHeight() {
        return 1;
    }
}
