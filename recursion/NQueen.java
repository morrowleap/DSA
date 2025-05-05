/*
 * https://takeuforward.org/data-structure/n-queen-problem-return-all-distinct-solutions-to-the-n-queens-puzzle/
 * https://youtu.be/i05Ju7AftcM
 * 
 * https://leetcode.com/problems/n-queens/description/
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueen {
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

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] currBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                currBoard[i][j] = '.';
            }
        }

        int[][] queenAttackMap = new int[n][n];

        backtrack(n, 0, currBoard, queenAttackMap, res);

        return res;
    }

    private void backtrack(int n, int row, char[][] currBoard, int[][] queenAttackMap, List<List<String>> res) {
        if (row == n) {
            List<String> board = new ArrayList<>();
            for (char[] x : currBoard) {
                board.add(new String(x));
            }
            res.add(board);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (queenAttackMap[row][col] == 0) {
                currBoard[row][col] = 'Q';
                fillQueenAttackMap(queenAttackMap, row, col, 1);
                backtrack(n, row + 1, currBoard, queenAttackMap, res);
                fillQueenAttackMap(queenAttackMap, row, col, -1);
                currBoard[row][col] = '.';
            }
        }
    }

    private void fillQueenAttackMap(int[][] queenAttackMap, int i, int j, int delta) {
        int n = queenAttackMap.length;
        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        for (int[] d : directions) {
            int newi = i + d[0], newj = j + d[1];
            while (newi >= 0 && newi < n && newj >= 0 && newj < n) {
                queenAttackMap[newi][newj] += delta;
                newi += d[0];
                newj += d[1];
            }
        }
    }
}

// Recursive Time Complexity: O(n!), n columns in first row, n - 1 cols in
// second row, .....

// Recursive Space Complexity: O(n), n rows to be filled
