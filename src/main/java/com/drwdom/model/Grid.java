package com.drwdom.model;

import com.drwdom.constants.TetrisEngineConstants;
import com.drwdom.model.pieces.Piece;

import lombok.Getter;

import java.util.Arrays;

/**
 * Represents the Tetris grid.
 */
@Getter
public class Grid {
	private final int width;
	private final int height;
	private final char[][] grid;

	/**
	 * Constructs a Grid with the specified width and height.
	 *
	 * @param width  the width of the grid
	 * @param height the height of the grid
	 */
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		this.grid = new char[height][width];
	}

	/**
	 * Initializes the grid by setting all cells to empty.
	 */
	public void initializeGrid() {
		Arrays.stream(grid).forEach(row -> Arrays.fill(row, TetrisEngineConstants.EMPTY));
	}

	/**
	 * Sets a piece on the grid at the specified row number.
	 *
	 * @param rowNumber the row number to place the piece
	 * @param piece     the piece to be placed
	 */
	public void setPiece(int rowNumber, Piece piece) {
		int[][] coordinates = piece.getCoordinates(rowNumber);
		for (int[] coordinate : coordinates) {
			int row = coordinate[0];
			int col = coordinate[1];
			grid[row][col] = piece.getShape();
		}
	}
}
