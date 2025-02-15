import java.util.Scanner;

class Solution {
    private int topDownHelper(int n, int k, int[] height, int[] memo) {
        if(n <= 0) {
            return 0;
        }

        if(memo[n] != -1) {
            return memo[n];
        }

        int minCost = Integer.MAX_VALUE;
        for(int jump = 1; jump <= k; jump++) {
            if(n - jump >= 0) {
                int stepCost = Math.abs(height[n] - height[n - jump]) + topDownHelper(n - jump, k, height, memo);
                minCost = Math.min(minCost, stepCost);
            }
        }

        memo[n] = minCost;
        return minCost;
    }

    private int topDown(int k, int[] height) {
        int n = height.length;
        int[] memo = new int[n];
        for(int i = 0; i < n; i++) {memo[i] = -1;}
        return topDownHelper(n - 1, k, height, memo);
    }

    private int bottomUp(int k, int[] height) {
        int n = height.length;
        int[] dp = new int[n];

        dp[0] = 0;
        for(int i = 1; i < n; i++) {
            int minCost = Integer.MAX_VALUE;
            for(int jump = 1; jump <= k; jump++) {
                if(i - jump >= 0) {
                    int stepCost = Math.abs(height[i] - height[i - jump]) + dp[i - jump];
                    minCost = Math.min(minCost, stepCost);
                }
            }
            dp[i] = minCost;
        }

        return dp[n - 1];
    }
}

public class MinimalCost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] height = {10, 30, 40, 50, 20};
        int k = 3;

        Solution sol = new Solution();
        System.out.println(sol.topDown(k, height));
        System.out.println(sol.bottomUp(k, height));

        scanner.close();
    }
}