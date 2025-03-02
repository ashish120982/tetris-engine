package com.drwdom.components.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import com.drwdom.components.api.IGridHelper;
import com.drwdom.constants.TetrisEngineConstants;
import com.drwdom.model.Grid;
import com.drwdom.model.pieces.Piece;

/**
 * Implementation of IGridHelper for managing operations on a Tetris grid.
 */
public class GridHelperImpl implements IGridHelper {

	/**
	 * Places a Tetris piece onto the grid at the lowest available position,
	 * respecting existing blocks.
	 *
	 * @param grid  The grid where the piece will be placed.
	 * @param piece The piece to be placed.
	 */
	@Override
	public void placePiece(Grid grid, Piece piece) {
		int row = 0;
		while (row + piece.getHeight() < grid.getHeight()) {
			int[][] coordinates = piece.getCoordinates(row);
			Arrays.sort(coordinates, Comparator.comparingInt((int[] coord) -> coord[0]).reversed());
			if (hasBlockBelow(grid, coordinates)) {
				break;
			}
			row++;
		}
		grid.setPiece(row, piece);
	}

	/**
	 * Checks if any block is detected directly below the specified coordinates in
	 * the grid.
	 *
	 * @param grid        The grid to check.
	 * @param coordinates The coordinates of the piece to check.
	 * @return true if there is a block directly below, false otherwise.
	 */
	@Override
	public boolean hasBlockBelow(Grid grid, int[][] coordinates) {
		Set<Integer> checkedColumns = new HashSet<>();
		for (int[] coord : coordinates) {
			int belowRowNum = coord[0] + 1;
			int col = coord[1];
			if (checkedColumns.contains(col)) {
				continue;
			}
			checkedColumns.add(col);
			if (grid.getGrid()[belowRowNum][col] != TetrisEngineConstants.EMPTY) {
				return true; // Block detected
			}
		}
		return false;
	}

	/**
	 * Clears full rows in the grid, updating the grid state after shifting rows
	 * down.
	 *
	 * @param grid The grid in which rows will be cleared.
	 */
	@Override
	public void clearFullRows(Grid grid) {
		for (int i = grid.getHeight() - 1; i >= 0; i--) {
			if (isRowFull(grid, i)) {
				shiftRowsDown(grid, i);
				i++; // Re-check the same row index after shifting
			}
		}
	}

	/**
	 * Shifts all rows above the specified row down by one position in the grid.
	 *
	 * @param grid     The grid where rows will be shifted.
	 * @param startRow The row from which shifting starts.
	 */
	private void shiftRowsDown(Grid grid, int startRow) {
		IntStream.iterate(startRow, k -> k > 0, k -> k - 1).forEach(k -> grid.getGrid()[k] = grid.getGrid()[k - 1]);
		Arrays.fill(grid.getGrid()[0], TetrisEngineConstants.EMPTY);
	}

	/**
	 * Determines if a row in the grid is full (contains no empty cells).
	 *
	 * @param grid The grid to check.
	 * @param row  The row to check for fullness.
	 * @return true if the row is full, false otherwise.
	 */
	private boolean isRowFull(Grid grid, int row) {
		return IntStream.range(0, grid.getWidth())
				.allMatch(col -> grid.getGrid()[row][col] != TetrisEngineConstants.EMPTY);
	}

	/**
	 * Calculates the current height of the Tetris grid (number of non-empty rows).
	 *
	 * @param grid The grid whose height will be calculated.
	 * @return The height of the grid.
	 */
	@Override
	public int calculateHeight(Grid grid) {
		return (int) IntStream.iterate(grid.getHeight() - 1, i -> i >= 0, i -> i - 1).filter(i -> IntStream
				.range(0, grid.getWidth()).anyMatch(j -> grid.getGrid()[i][j] != TetrisEngineConstants.EMPTY)).count();
	}
}
