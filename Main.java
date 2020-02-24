//github user Jeffligit

import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int[] example = {1, 2, 3, 0, 5, 6, 7, 8, 9};
		int[][] grid = new int[9][9];
		Scanner in = new Scanner(System.in);
		
		System.out.println("This is how you enter your grid.");
		System.out.println("If your row looks like this\n");
		
		for (int i = 0; i < example.length; i++) {
			if (example[i] == 0) {
				System.out.print("[ ]");
			} else {
				System.out.print("[" + example[i] + "]");
			}
		}
		
		System.out.println("\n\nEnter the row like this:\n");
		System.out.println("1,2,3,0,5,6,7,8,9\n");
		System.out.println("Where 0 represents the empty square.\n");
		
		for (int i = 0; i < grid.length; i++) {
			System.out.println("Please enter row " + (i+1) + ":");
			String line = in.next();
			String[] numbers = line.split(",");
			if (numbers.length != 9) {
				System.out.println("Please enter 9 integers separated using commas.\n");
				i--;
			} else {
				for (int j = 0; j < numbers.length; j++) {
					if (!(numbers[j].length() == 1) || 
					    !(numbers[j].charAt(0) >= '0' && numbers[j].charAt(0) <= '9')) {
						System.out.println("Please enter a number 0 through 9.\n");
						i--;
						break;
					}
					grid[i][j] = Integer.parseInt(numbers[j]);
				}
			}
			
		}
		
		System.out.println();
		SudokuSolver solver = new SudokuSolver(grid);
		solver.solver();
		
		if (solver.answers.size() > 0) {
			Iterator<int[][]> iter = solver.answers.iterator();
			while (iter.hasNext()) {
				solver.printGrid(iter.next());
				System.out.println("Would you like more solutions? n/N to finish.");
				String getAnswer = in.next();
				if (getAnswer.equals("N") || getAnswer.equals("n")) {
					in.close();
					System.out.println("\nDone.");
					return;
				}
				System.out.println("Next Solution.\n");
			}
			System.out.println("There are no more solutions. Done.");
		} else {
			System.out.println("This suduko is unsolvable.");
		}
		
		in.close();
	}
}
