package com.drwdom.model.pieces;

public class SPiece extends Piece {
    public SPiece(int column) {
        super(column);
    }

    @Override
    public int[][] getCoordinates(int row) {
        return new int[][] {
            {row, column + 1},
            {row, column + 2},
            {row + 1, column},
            {row + 1, column + 1}
        };
    }

    @Override
    public char getShape() {
        return 'S';
    }

	@Override
	public int getHeight() {
		return 2;
	}
}