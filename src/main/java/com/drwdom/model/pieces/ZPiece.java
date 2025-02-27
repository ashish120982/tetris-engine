package com.drwdom.model.pieces;

public class ZPiece extends Piece {
    public ZPiece(int column) {
        super(column);
    }

    @Override
    public int[][] getCoordinates(int row) {
        return new int[][] {
            {row, column},
            {row, column + 1},
            {row + 1, column + 1},
            {row + 1, column + 2}
        };
    }

    @Override
    public char getShape() {
        return 'Z';
    }

	@Override
	public int getHeight() {
		return 2;
	}
}