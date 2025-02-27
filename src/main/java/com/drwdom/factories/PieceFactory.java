package com.drwdom.factories;

import com.drwdom.model.pieces.IPiece;
import com.drwdom.model.pieces.JPiece;
import com.drwdom.model.pieces.LPiece;
import com.drwdom.model.pieces.Piece;
import com.drwdom.model.pieces.QPiece;
import com.drwdom.model.pieces.SPiece;
import com.drwdom.model.pieces.TPiece;
import com.drwdom.model.pieces.ZPiece;

/**
 * Factory class to create Tetris pieces based on the specified shape.
 */
public class PieceFactory {

    /**
     * Creates a Tetris piece based on the specified shape.
     * 
     * @param shape the shape of the Tetris piece
     * @param column the starting column for the piece
     * @return the created Tetris piece
     * @throws IllegalArgumentException if the piece shape is invalid
     */
    public static Piece createPiece(char shape, int column) {
        return switch (shape) {
            case 'Q' -> new QPiece(column);
            case 'Z' -> new ZPiece(column);
            case 'S' -> new SPiece(column);
            case 'T' -> new TPiece(column);
            case 'I' -> new IPiece(column);
            case 'L' -> new LPiece(column);
            case 'J' -> new JPiece(column);
            default -> throw new IllegalArgumentException("Invalid piece shape: " + shape);
        };
    }
}
