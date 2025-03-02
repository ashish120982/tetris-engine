package com.drwdom.model.pieces;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Parameterized tests for all Piece classes to ensure full code coverage.
 */
class AllPiecesTest {

    // Provide all pieces with their expected properties
    static Stream<Arguments> providePiecesForTesting() {
        return Stream.of(
            Arguments.of(new IPiece(0), 'I', new int[][] {
                {0, 0}, {0, 1}, {0, 2}, {0, 3} // IPiece lying horizontally
            }),
            Arguments.of(new QPiece(0), 'Q', new int[][] {
                {0, 0}, {0, 1}, {1, 0}, {1, 1} // QPiece forming a 2x2 block
            }),
            Arguments.of(new LPiece(0), 'L', new int[][] {
                {0, 0}, {1, 0}, {2, 0}, {2, 1} // LPiece forming an L-shape
            }),
            Arguments.of(new TPiece(0), 'T', new int[][] {
                {0, 0}, {0, 1}, {0, 2}, {1, 1} // TPiece forming a T-shape
            }),
            Arguments.of(new ZPiece(0), 'Z', new int[][] {
                {0, 0}, {0, 1}, {1, 1}, {1, 2} // ZPiece forming a Z-shape
            }),
            Arguments.of(new SPiece(0), 'S', new int[][] {
                {0, 1}, {0, 2}, {1, 0}, {1, 1} // SPiece forming an S-shape
            }),
            Arguments.of(new JPiece(0), 'J', new int[][] {
                {0, 1}, {1, 1}, {2, 1}, {2, 0} // JPiece forming a J-shape
            })
        );
    }

    @ParameterizedTest
    @MethodSource("providePiecesForTesting")
    void testShapeAndCoordinates(Piece piece, char expectedShape, int[][] expectedCoordinates) {
        // Test shape
        assertEquals(expectedShape, piece.getShape(), "Shape should match the expected value");

        // Test coordinates
        assertArrayEquals(expectedCoordinates, piece.getCoordinates(0), "Coordinates should match the expected initial position");
    }

    @ParameterizedTest
    @MethodSource("providePiecesForTesting")
    void testInitialization(Piece piece, char expectedShape, int[][] expectedCoordinates) {
        // Test that the piece is initialized correctly with its initial properties
        assertNotNull(piece, "Piece should not be null after initialization");
        assertEquals(expectedShape, piece.getShape(), "Piece should have the correct shape identifier");
    }
}
