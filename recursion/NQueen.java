/*
 * https://takeuforward.org/data-structure/n-queen-problem-return-all-distinct-solutions-to-the-n-queens-puzzle/
 * https://leetcode.com/problems/n-queens/description/
 * https://youtu.be/i05Ju7AftcM
*/

package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NQueen {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] currBoard = new char[n][n];
        for (char[] row : currBoard) {
            Arrays.fill(row, '.');
        }
        int[][] queenLookupGrid = new int[n][n];
        dfs(0, currBoard, queenLookupGrid, res);

        return res;

        // TODO: Add recursion tree
    }

    private void dfs(int row, char[][] currBoard, int[][] queenLookupGrid, List<List<String>> res) {
        int n = currBoard.length;
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] line : currBoard) {
                solution.add(new String(line));
            }
            res.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (queenLookupGrid[row][col] == 0) {
                // Place queen
                currBoard[row][col] = 'Q';
                // Place queen shadow on other cells
                fillQueenLookupGrid(queenLookupGrid, row, col, 1);

                // Recurse for next row
                dfs(row + 1, currBoard, queenLookupGrid, res);

                // Remove queen shadow from other cells
                fillQueenLookupGrid(queenLookupGrid, row, col, -1);
                // Remove queen
                currBoard[row][col] = '.';
            }
        }
    }

    private void fillQueenLookupGrid(int[][] queenLookupGrid, int x, int y, int delta) {
        int n = queenLookupGrid.length;

        queenLookupGrid[x][y] += delta;
        // Place queen shadow on other rows
        for (int i = 0; i < n; i++) {
            if (i == x)
                continue;
            queenLookupGrid[i][y] += delta;
        }
        // Place queen shadow on other cols
        for (int j = 0; j < n; j++) {
            if (j == y)
                continue;
            queenLookupGrid[x][j] += delta;
        }
        // Place queen shadow in diagnols
        int[][] directions = { { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } };
        for (int[] d : directions) {
            int newX = x + d[0];
            int newY = y + d[1];

            // Move in new direction until boundary is reached
            while (newX >= 0 && newY >= 0 && newX < n && newY < n) {
                // Place queen shadow on a diagnol
                queenLookupGrid[newX][newY] += delta;
                newX += d[0];
                newY += d[1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        NQueen sol = new NQueen();
        List<List<String>> solutions = sol.solveNQueens(n);

        System.out.println("Total solutions: " + solutions.size());
        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }

        sc.close();
    }
}

// Recursive Time Complexity: O(n!), n columns in first row, n - 1 cols in
// second row, .....

// Recursive Space Complexity: O(n), n rows to be filled
