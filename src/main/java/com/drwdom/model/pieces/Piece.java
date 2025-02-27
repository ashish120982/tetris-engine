package com.drwdom.model.pieces;

import lombok.Getter;

@Getter
public abstract class Piece {
    protected final int column;

    public Piece(int column) {
        this.column = column;
    }

    public abstract int[][] getCoordinates(int row);
    public abstract char getShape();

    public abstract int getHeight();
}
