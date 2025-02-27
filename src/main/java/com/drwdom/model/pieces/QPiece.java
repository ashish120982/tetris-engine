package com.drwdom.model.pieces;
public class QPiece extends Piece {
    public QPiece(int column) {
        super(column);
    }

    @Override
    public int[][] getCoordinates(int row) {
        return new int[][] {
            {row, column},
            {row, column + 1},
            {row + 1, column},
            {row + 1, column + 1}
        };
    }

    @Override
    public char getShape() {
        return 'Q';
    }

	@Override
	public int getHeight() {
		return 2;
	}
    
}