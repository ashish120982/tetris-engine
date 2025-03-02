package com.drwdom.components.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.drwdom.constants.TetrisEngineConstants;
import com.drwdom.model.Grid;
import com.drwdom.model.pieces.IPiece;
import com.drwdom.model.pieces.QPiece;

/**
 * Unit tests for the final version of GridHelperImpl.
 */
class GridHelperImplTest {

    private GridHelperImpl gridHelper;
    private Grid grid;

    @BeforeEach
    void setUp() {
        gridHelper = new GridHelperImpl();
        grid = new Grid(TetrisEngineConstants.GRID_WIDTH, TetrisEngineConstants.GRID_HEIGHT);
        grid.initializeGrid();
    }

    @Test
    void testPlacePieceAtLowestPosition() {
        // Create an IPiece starting at column 0
        IPiece piece = new IPiece(0);

        // Place the piece on the grid
        gridHelper.placePiece(grid, piece);

        // Get the coordinates for the piece
        int[][] coordinates = piece.getCoordinates(grid.getHeight()-1);

        // Verify the piece lies horizontally in the bottom-most row
        for (int[] coord : coordinates) {
            assertEquals(piece.getShape(), grid.getGrid()[coord[0]][coord[1]], "Piece should be placed correctly at the lowest position");
        }
    }



    @Test
    void testHasBlockBelowDetection() {
        // Test detecting blocks below a placed piece
        QPiece piece = new QPiece(0);
        gridHelper.placePiece(grid, piece);
        int[][] coordinates = piece.getCoordinates(0);
        assertFalse(gridHelper.hasBlockBelow(grid, coordinates), "No blocks below the piece");
    }

    @Test
    void testClearFullRowsFunctionality() {
        // Simulate a full row and ensure it gets cleared
        Arrays.fill(grid.getGrid()[grid.getHeight() - 1], 'Q'); // Fill the bottom row
        gridHelper.clearFullRows(grid);
        for (char cell : grid.getGrid()[grid.getHeight() - 1]) {
            assertEquals(TetrisEngineConstants.EMPTY, cell, "All cells in the row should be cleared");
        }
    }

    @Test
    void testCalculateGridHeightAfterPlacement() {
        // Test height calculation after placing a piece
        QPiece piece = new QPiece(0);
        gridHelper.placePiece(grid, piece);
        int height = gridHelper.calculateHeight(grid);
        assertEquals(2, height, "Height should reflect the number of non-empty rows");
    }

    @Test
    void testShiftRowsDownAfterRowClear() {
        // Test that rows shift down after clearing
    	Arrays.fill(grid.getGrid()[grid.getHeight() - 1], 'Q');
        grid.getGrid()[grid.getHeight() - 2][0] = 'X'; // Second-to-last row, first cell
        gridHelper.clearFullRows(grid);
        assertEquals('X', grid.getGrid()[grid.getHeight() - 1][0], "Row above should shift down");
        assertEquals(TetrisEngineConstants.EMPTY, grid.getGrid()[grid.getHeight() - 2][0], "Row above should now be empty");
    }
}
