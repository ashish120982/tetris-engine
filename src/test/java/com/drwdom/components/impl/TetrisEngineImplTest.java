package com.drwdom.components.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.drwdom.components.api.IGridHelper;
import com.drwdom.components.api.ITetrisEngine;
import com.drwdom.model.Grid;

/**
 * Parameterized tests for TetrisEngineImpl with input strings and expected heights.
 */
class TetrisEngineImplTest {

    private Grid grid;
    private ITetrisEngine tetrisEngine;

    @BeforeEach
    void setUp() {
        // Initialize Grid and TetrisEngineImpl before each test
        grid = new Grid(10, 100);
        IGridHelper gridHelper = new GridHelperImpl();
        tetrisEngine = new TetrisEngineImpl(grid, gridHelper);
    }

    // Provide test cases as arguments: input line and expected grid height
    private static Stream<Arguments> provideInputLinesAndHeights() {
        return Stream.of(
            Arguments.of(List.of("I0,I4,Q8"), 1), // Case 1
            Arguments.of(List.of("T1,Z3,I4"), 4), // Case 2
            Arguments.of(List.of("Q0,I2,I6,I0,I6,I6,Q2,Q4"), 3) // Case 3
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputLinesAndHeights")
    void testApplyPiecesToGrid(List<String> inputLines, int expectedHeight) {
        // Apply pieces to the grid
        List<Integer> result = tetrisEngine.applyPiecesToGrid(inputLines);
        // Verify the resulting grid heights
        assertEquals(inputLines.size(), result.size(), "The number of resulting heights should match the input lines");
        assertEquals(expectedHeight, result.get(result.size() - 1), "The final grid height should match the expected value");
    }
}
