/*
 * https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
 * https://www.geeksforgeeks.org/problems/minimal-cost/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimal-cost
*/

package dynamic_programming;

import java.util.Scanner;

class MinimalCostSolution {
    private int topDownHelper(int n, int k, int[] arr, int[] memo) {
        if(n == 0) {
            return 0;
        }

        if(memo[n] != -1) {
            return memo[n];
        }
        
        int minCost = Integer.MAX_VALUE;
        for(int jump = 1; jump <= k; jump++) {
            if(n - jump >= 0) {
                int cost = Math.abs(arr[n] - arr[n - jump]) + topDownHelper(n - jump, k, arr, memo);
                minCost = Math.min(minCost, cost);
            }
        }

        memo[n] = minCost;
        return minCost;
    }

    public int topDown(int k, int[] arr) {
        int n = arr.length;
        int[] memo = new int[n];
        for(int i=0;i<n;i++) {memo[i] = -1;}
        return topDownHelper(n - 1, k, arr, memo);
    }

    public int bottomUp(int k, int[] arr) {
        int n = arr.length;
        int[] memo = new int[n];

        memo[0] = 0;

        for(int i = 1; i < n; i++) {
            int minCost = Integer.MAX_VALUE;

            for(int jump = 1; jump <= k; jump++) {
                if(i - jump >= 0) {
                    int cost = Math.abs(arr[i] - arr[i - jump]) + memo[i - jump];
                    minCost = Math.min(minCost, cost);
                }
            }

            memo[i] = minCost;
        }

        return memo[n - 1];
    }
}

public class FrogJumpWithKdistances {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] heights = new int[n];
        for(int i=0;i<n;i++) {
            heights[i] = scanner.nextInt();
        }

        MinimalCostSolution sol = new MinimalCostSolution();
        System.out.println(sol.topDown(k, heights));

        scanner.close();
    }
}