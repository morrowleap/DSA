/*
 * https://takeuforward.org/data-structure/minimum-path-sum-in-triangular-grid-dp-11/
 * https://leetcode.com/problems/triangle/description/
*/

package dynamic_programming;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class TriangleSolution {
    private int topDownHelper(List<List<Integer>> triangle, int i, int j, int[][] memo) {
        int m = triangle.size();
        if(i == m - 1) {
            return triangle.get(i).get(j);
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        int down = topDownHelper(triangle, i + 1, j, memo);
        int diagnol = topDownHelper(triangle, i + 1, j + 1, memo);

        memo[i][j] = triangle.get(i).get(j) + Math.min(down, diagnol);
        return memo[i][j];
    }
    
    public int topDown(List<List<Integer>> triangle) {
        int m = triangle.size();
        int i = 0, j = 0;
        int[][] memo = new int[m][m];
        for(int x=0;x<m;x++) {
            for(int y=0;y<m;y++) {
                memo[x][y] = -1;
            }
        }
        return topDownHelper(triangle, i, j, memo);
    }

    public int bottomUp(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] memo = new int[m][m];

        for(int j=0;j<m;j++) {
            memo[m - 1][j] = triangle.get(m - 1).get(j);
        }

        for(int j=m-2;j>=0;j--) {
            for(int i=0;i<=j;i++) {
                int down = memo[j+1][i];
                int diagnol = memo[j+1][i+1];

                memo[j][i] = triangle.get(j).get(i) + Math.min(down, diagnol);
            }
        }

        return memo[0][0];
    }
}

public class MinimumPathSumInTriangularGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        List<List<Integer>> triangle = new ArrayList<>();

        for(int i=0;i<m;i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<i+1;j++) {
                row.add(sc.nextInt());
            }
            triangle.add(row);
        }

        for (List<Integer> row : triangle) {
            System.out.println(row);
        }

        TriangleSolution sol = new TriangleSolution();
        System.out.println(sol.topDown(triangle));

        sc.close();
    }
}