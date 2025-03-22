/*
 * https://www.youtube.com/watch?v=GqOmJHQZivw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=20
 * https://takeuforward.org/data-structure/0-1-knapsack-dp-19/
 * https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
 * 
*/

package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class ZeroOneKnapsackProblemSol {

    public int topDown(int w, int[] val, int[] wt) {
        int n = val.length;
        int[][] memo = new int[n][w+1];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return topDownHelper(w, n - 1, val, wt, memo);
    }

    private int topDownHelper(int w, int n, int[] val, int[] wt, int[][] memo) { // Maximum amount of value
        if(n == 0) {
            if(wt[0] <= w) {
                return val[0];
            } else {
                return 0;
            }
        }

        if(memo[n][w] != -1) {
            return memo[n][w];
        }

        int pick = Integer.MIN_VALUE;
        if(wt[n] <= w) {
            pick = val[n] + topDownHelper(w - wt[n], n - 1, val, wt, memo);
        }
        int notpick = topDownHelper(w, n - 1, val, wt, memo);

        memo[n][w] = Math.max(pick, notpick);
        return memo[n][w];
    }

}

public class ZeroOneKnapsackProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        int W = sc.nextInt();

        ZeroOneKnapsackProblemSol sol = new ZeroOneKnapsackProblemSol();
        System.out.println(sol.topDown(W, val, wt));

        sc.close();
    }
}
