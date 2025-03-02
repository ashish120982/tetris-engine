package com.drwdom.factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.drwdom.model.pieces.*;

/**
 * Unit tests for the PieceFactory class.
 */
class PieceFactoryTest {

    @Test
    void testCreatePiece() {
        // Test creating each type of piece
        assertEquals(QPiece.class, PieceFactory.createPiece('Q', 0).getClass(), "Should create a QPiece");
        assertEquals(ZPiece.class, PieceFactory.createPiece('Z', 1).getClass(), "Should create a ZPiece");
        assertEquals(SPiece.class, PieceFactory.createPiece('S', 2).getClass(), "Should create an SPiece");
        assertEquals(TPiece.class, PieceFactory.createPiece('T', 3).getClass(), "Should create a TPiece");
        assertEquals(IPiece.class, PieceFactory.createPiece('I', 4).getClass(), "Should create an IPiece");
        assertEquals(LPiece.class, PieceFactory.createPiece('L', 5).getClass(), "Should create an LPiece");
        assertEquals(JPiece.class, PieceFactory.createPiece('J', 6).getClass(), "Should create a JPiece");
    }

    @Test
    void testInvalidPiece() {
        // Test invalid piece creation
        assertThrows(IllegalArgumentException.class, () -> PieceFactory.createPiece('X', 0), "Invalid shape should throw IllegalArgumentException");
    }
}
