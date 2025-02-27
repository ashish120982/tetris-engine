package com.drwdom.model.pieces;

public class JPiece extends Piece {
    public JPiece(int column) {
        super(column);
    }

    @Override
    public int[][] getCoordinates(int row) {
        return new int[][] {
            {row, column + 1},
            {row + 1, column + 1},
            {row + 2, column + 1},
            {row + 2, column}
        };
    }

    @Override
    public char getShape() {
        return 'J';
    }

	@Override
	public int getHeight() {
		return 3;
	}
}