package com.drwdom;

import static com.drwdom.constants.TetrisEngineConstants.GRID_HEIGHT;
import static com.drwdom.constants.TetrisEngineConstants.GRID_WIDTH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import com.drwdom.components.api.IGridHelper;
import com.drwdom.components.api.ITetrisEngine;
import com.drwdom.components.impl.GridHelperImpl;
import com.drwdom.components.impl.TetrisEngineImpl;
import com.drwdom.model.Grid;

/**
 * TetrisEngineApplication serves as the entry point for the Tetris Engine application.
 * <p>
 * It reads input from STDIN, initializes the necessary components of the Tetris engine,
 * processes the input, and outputs the resulting grid heights to STDOUT.
 * </p>
 */
public class TetrisEngineApplication {

    /**
     * The main method reads input from STDIN, initializes the TetrisEngine components,
     * processes the input lines, and outputs the resulting grid heights to STDOUT.
     *
     * @param args Command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(System.out);
        ) {
            // Read input lines from STDIN
            List<String> inputLines = reader.lines().collect(Collectors.toList());

            // Initialize the Tetris engine components using default grid dimensions
            Grid grid = new Grid(GRID_WIDTH, GRID_HEIGHT);
            IGridHelper gridHelper = new GridHelperImpl();
            ITetrisEngine tetrisEngine = new TetrisEngineImpl(grid, gridHelper);

            // Process input lines and calculate the resulting grid heights
            List<Integer> outputLines = tetrisEngine.applyPiecesToGrid(inputLines);

            // Write the resulting grid heights to STDOUT using PrintWriter
            outputLines.forEach(writer::println);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}