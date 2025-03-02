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
 * A factory class for creating Tetris piece objects based on their shape and initial column position.
 */
public class PieceFactory {

    /**
     * Creates a Tetris piece object based on the given shape and column position.
     *
     * @param shape  The character representing the shape of the Tetris piece (e.g., 'Q', 'Z', etc.).
     * @param column The initial column position of the piece on the grid.
     * @return A Piece object corresponding to the given shape.
     * @throws IllegalArgumentException if the shape is invalid.
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
