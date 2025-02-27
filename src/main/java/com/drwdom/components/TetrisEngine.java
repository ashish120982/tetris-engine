package com.drwdom.components;

import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.drwdom.factories.PieceFactory;
import com.drwdom.model.Grid;
import com.drwdom.model.pieces.Piece;

/**
 * The TetrisEngine class handles the main logic of the Tetris game,
 * including applying pieces to the grid and calculating the resulting height of the grid.
 */
@Component
public class TetrisEngine {

    private final Grid grid;
    private final GridHelper gridHelper;

    /**
     * Constructs a new TetrisEngine with a specified GridHelper.
     *
     * @param gridHelper the GridHelper used for various grid operations
     */
    public TetrisEngine(GridHelper gridHelper) {
    	// Initialize the grid with width 10 and height 100
        this.grid = new Grid(10, 100); 
        this.gridHelper = gridHelper;
    }

    /**
     * Applies a list of pieces to the grid based on input lines and returns the resulting heights of the grid.
     *
     * @param inputLines the list of input lines representing pieces to be applied to the grid
     * @return a list of strings representing the heights of the grid after applying the pieces
     */
    public List<String> applyPiecesToGrid(List<String> inputLines) {
        return inputLines.stream()
                .map(this::applyPieces)
                .collect(Collectors.toList());
    }

    /**
     * Applies a single line of pieces to the grid.
     *
     * @param line the input line representing pieces to be applied to the grid
     * @return the resulting height of the grid after applying the pieces
     */
    private String applyPieces(String line) {
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
        return String.valueOf(gridHelper.calculateHeight(grid));
    }

}
