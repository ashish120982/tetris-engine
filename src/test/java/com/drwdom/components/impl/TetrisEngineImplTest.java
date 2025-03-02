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
 * Parameterized tests for TetrisEngineImpl with input strings and expected
 * heights.
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
	        Arguments.of(List.of("Q0"), 2),
	        Arguments.of(List.of("Q0,Q1"), 4),
	        Arguments.of(List.of("Q0,Q2,Q4,Q6,Q8"), 0),
	        Arguments.of(List.of("Q0,Q2,Q4,Q6,Q8,Q1"), 2),
	        Arguments.of(List.of("Q0,Q2,Q4,Q6,Q8,Q1,Q1"), 4),
	        Arguments.of(List.of("I0,I4,Q8"), 1),
	        Arguments.of(List.of("I0,I4,Q8,I0,I4"), 0),
	        Arguments.of(List.of("L0,J2,L4,J6,Q8"), 2),
	        Arguments.of(List.of("L0,Z1,Z3,Z5,Z7"), 2),
	        Arguments.of(List.of("T0,T3"), 2),
	        Arguments.of(List.of("T0,T3,I6,I6"), 1),
	        Arguments.of(List.of("I0,I6,S4"), 1),
	        Arguments.of(List.of("T1,Z3,I4"), 4),
	        Arguments.of(List.of("L0,J3,L5,J8,T1"), 3),
	        Arguments.of(List.of("L0,J3,L5,J8,T1,T6"), 1),
	        Arguments.of(List.of("L0,J3,L5,J8,T1,T6,J2,L6,T0,T7"), 2),
	        Arguments.of(List.of("L0,J3,L5,J8,T1,T6,J2,L6,T0,T7,Q4"), 1),
	        Arguments.of(List.of("S0,S2,S4,S6"), 8),
	        Arguments.of(List.of("S0,S2,S4,S5,Q8,Q8,Q8,Q8,T1,Q1,I0,Q4"), 8),
	        Arguments.of(List.of("L0,J3,L5,J8,T1,T6,S2,Z5,T0,T7"), 0),
	        Arguments.of(List.of("Q0,I2,I6,I0,I6,I6,Q2,Q4"), 3)
	    );
	}

	@ParameterizedTest
	@MethodSource("provideInputLinesAndHeights")
	void testApplyPiecesToGrid(List<String> inputLines, int expectedHeight) {
		// Apply pieces to the grid
		List<Integer> result = tetrisEngine.applyPiecesToGrid(inputLines);
		// Verify the resulting grid heights
		assertEquals(inputLines.size(), result.size(), "The number of resulting heights should match the input lines");
		assertEquals(expectedHeight, result.get(result.size() - 1),
				"The final grid height should match the expected value");
	}
}
