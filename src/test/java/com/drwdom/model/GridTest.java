package com.drwdom.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.drwdom.constants.TetrisEngineConstants;
import com.drwdom.model.pieces.IPiece;

/**
 * Unit tests for the Grid class.
 */
class GridTest {

    private Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid(TetrisEngineConstants.GRID_WIDTH, TetrisEngineConstants.GRID_HEIGHT);
    }

    @Test
    void testGridInitialization() {
        // Test that the grid is initialized with the correct dimensions and empty cells
        grid.initializeGrid();
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                assertEquals(TetrisEngineConstants.EMPTY, grid.getGrid()[i][j], "Cell should be empty after initialization");
            }
        }
    }

    @Test
    void testSetPieceValidPlacement() {
        // Test placing a piece on the grid
        grid.initializeGrid();
        IPiece piece = new IPiece(0);
        grid.setPiece(0, piece);
        int[][] coordinates = piece.getCoordinates(0);
        for (int[] coord : coordinates) {
            assertEquals(piece.getShape(), grid.getGrid()[coord[0]][coord[1]], "Grid cell should match the piece shape");
        }
    }

    @Test
    void testSetPieceOutOfBounds() {
        // Test placing a piece that exceeds the grid bounds
        grid.initializeGrid();
        IPiece piece = new IPiece(TetrisEngineConstants.GRID_WIDTH - 1); // Position exceeds boundary
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> grid.setPiece(0, piece),
                "Setting a piece out of bounds should throw ArrayIndexOutOfBoundsException");
    }
}
