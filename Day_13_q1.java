//N QUEENS
//Recursion and backtracking 

import java.util.*;

public class NQueensRecursive {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        placeQueens(board, 0, solutions);
        return solutions;
    }

    // Recursive function to place queens row by row
    private static void placeQueens(char[][] board, int row, List<List<String>> solutions) {
        int n = board.length;
        if (row == n) {
            // Found a valid solution
            List<String> sol = new ArrayList<>();
            for (char[] r : board) sol.add(new String(r));
            solutions.add(sol);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';          // place queen
                placeQueens(board, row + 1, solutions); // recurse
                board[row][col] = '.';          // backtrack
            }
        }
    }

    // Check if placing a queen at (row, col) is safe
    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 4; // Example: 4-Queens
        List<List<String>> solutions = solveNQueens(n);
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
