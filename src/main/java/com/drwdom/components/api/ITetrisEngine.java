package com.drwdom.components.api;

import java.util.List;

/**
 * Represents the Tetris Engine functionality for processing and applying Tetris pieces
 * to a grid based on input lines.
 */
public interface ITetrisEngine {

    /**
     * Processes a list of input lines, applies the corresponding Tetris pieces to the grid,
     * and calculates the resulting grid heights.
     *
     * @param inputLines A list of input strings, where each string represents Tetris piece placements
     * @return A list of integers where each integer represents the resulting grid height
     *         after processing a single input line.
     */
    List<Integer> applyPiecesToGrid(List<String> inputLines);

}