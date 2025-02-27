package com.drwdom.model.pieces;

public class LPiece extends Piece {
    public LPiece(int column) {
        super(column);
    }

    @Override
    public int[][] getCoordinates(int row) {
        return new int[][] {
            {row, column},
            {row + 1, column},
            {row + 2, column},
            {row + 2, column + 1}
        };
    }

    @Override
    public char getShape() {
        return 'L';
    }

	@Override
	public int getHeight() {
		return 3;
	}
}