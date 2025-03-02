package com.drwdom.components.impl;

import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import com.drwdom.components.api.IGridHelper;
import com.drwdom.components.api.ITetrisEngine;
import com.drwdom.factories.PieceFactory;
import com.drwdom.model.Grid;
import com.drwdom.model.pieces.Piece;

/**
 * Implementation of ITetrisEngine for managing Tetris gameplay operations.
 * Processes input strings to apply Tetris pieces to a grid and calculates the resulting grid heights.
 */
public class TetrisEngineImpl implements ITetrisEngine {

    private final Grid grid;
    private final IGridHelper gridHelper;

    /**
     * Constructs a TetrisEngineImpl with the specified grid and grid helper.
     *
     * @param grid       The grid to manage piece placements.
     * @param gridHelper The helper class for performing grid-related operations.
     */
    public TetrisEngineImpl(Grid grid, IGridHelper gridHelper) {
        this.grid = grid; 
        this.gridHelper = gridHelper;
    }

    /**
     * Processes a list of input lines, applies the corresponding Tetris pieces to the grid,
     * and calculates the resulting grid heights.
     *
     * @param inputLines A list of input strings, where each string represents Tetris piece placements
     *                   in the format "ShapeColumn,ShapeColumn,...".
     * @return A list of integers where each integer represents the resulting grid height
     *         after processing a single input line.
     */
    @Override
    public List<Integer> applyPiecesToGrid(List<String> inputLines) {
        return inputLines.stream()
                .map(this::applyPieces)
                .collect(Collectors.toList());
    }

    /**
     * Processes a single line of input, applies the specified Tetris pieces to the grid,
     * clears full rows, and calculates the resulting grid height.
     *
     * @param line A single input string representing piece placements.
     *             Format: "ShapeColumn,ShapeColumn,...".
     * @return The resulting height of the grid as an integer after processing the input line.
     */
    private int applyPieces(String line) {
        grid.initializeGrid();
        StringTokenizer tokenizer = new StringTokenizer(line, ",");
        while (tokenizer.hasMoreTokens()) {
            String pieceInfo = tokenizer.nextToken();
            char shape = pieceInfo.charAt(0);
            int column = Character.getNumericValue(pieceInfo.charAt(1));
            Piece piece = PieceFactory.createPiece(shape, column);
            gridHelper.placePiece(grid, piece);
            gridHelper.clearFullRows(grid);
        }
        return gridHelper.calculateHeight(grid);
    }
}
