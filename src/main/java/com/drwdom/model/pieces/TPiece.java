package com.drwdom.model.pieces;

public class TPiece extends Piece {
    public TPiece(int column) {
        super(column);
    }

    @Override
    public int[][] getCoordinates(int row) {
        return new int[][] {
            {row, column},
            {row, column + 1},
            {row, column + 2},
            {row + 1, column + 1}
        };
    }

    @Override
    public char getShape() {
        return 'T';
    }

	@Override
	public int getHeight() {
		return 2;
	}
}