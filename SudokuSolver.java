//github user Jeffligit

import java.util.LinkedList;
import java.util.List;

public class SudokuSolver {
	int[][] grid;
	List<int[][]> answers = new LinkedList<int[][]>();
	
	public SudokuSolver(int[][] grid) {
		this.grid = grid;
	}
	
	// checks if a number can be put in the square in a given x and y
	public boolean possible(int x, int y, int number) {
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][x] == number) {
				return false;
			}
		}
		for (int i = 0; i < grid[0].length; i++) {
			if (grid[y][i] == number) {
				return false;
			}
		}
		int xQuadrant = x / 3;
		int yQuadrant = y / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i + (yQuadrant * 3)][j + (xQuadrant * 3)] == number) {
					return false;
				}
			}
		}
		return true;
	}
	
	// finds all possible solutions and adds it into a list of solutions
	public void solver() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					for (int k = 1; k < 10; k++) {
						if (possible(j, i, k)) {
							grid[i][j] = k;
							solver();
							grid[i][j] = 0;
						}
					}
					return;
				}
			}	
		}
		int[][] answer = new int[9][9];
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[0].length; j++) {
				answer[i][j] = grid[i][j];
			}
		}
		answers.add(answer);
	}
	
	// prints out the suduko grid
	public void printGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (j % 3 == 0 && j != 0) {
					System.out.print(" ");
				}
				System.out.print("[" + grid[i][j] + "]");
			}
			System.out.println();
			if (i % 3 == 2) {
				System.out.println();
			}
		}
		System.out.println();
	}
	

	
	
}
