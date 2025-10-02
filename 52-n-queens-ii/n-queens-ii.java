class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) board[i][j] = '.';
        }
        return solve(board, 0, n);
    }

    // Backtracking function
    private int solve(char[][] board, int row, int n) {
        if (row == n) {
            return 1;  // found a valid arrangement
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                count += solve(board, row + 1, n);
                board[row][col] = '.'; // backtrack
            }
        }
        return count;
    }

    // Check if it's safe to place a queen at (row, col)
    private boolean isSafe(char[][] board, int row, int col, int n) {
        // vertical up
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // diagonal up-left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // diagonal up-right
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}
