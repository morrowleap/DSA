import java.util.Scanner;
import java.util.Arrays;

class Solution {
    private int topDownHelper(int n, int[] height, int[] memo) {
        if(n <= 0) {
            return 0;
        }

        if(memo[n] != -1) {
            return memo[n];
        }
        
        int oneStep = Integer.MAX_VALUE, twoStep = Integer.MAX_VALUE;
        if(n - 1 >= 0) {
            oneStep = Math.abs(height[n] - height[n - 1]) + topDownHelper(n - 1, height, memo);
        }
        if(n - 2 >= 0) {
            twoStep = Math.abs(height[n] - height[n - 2]) + topDownHelper(n - 2, height, memo);
        }
        memo[n] = Math.min(oneStep, twoStep);
        return memo[n];
    }

    private int topDown(int[] height) {
        int n = height.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return topDownHelper(n - 1, height, memo);
    }

    private int bottomUp(int[] height) {
        int n = height.length;
        int[] dp = new int[n];

        dp[0] = 0;

        for(int i=1; i<n; i++) {
            int oneStep = Integer.MAX_VALUE, twoStep = Integer.MAX_VALUE;
            if(i - 1 >= 0) {
                oneStep = Math.abs(height[i] - height[i - 1]) + dp[i - 1];
            }
            if(i - 2 >= 0) {
                twoStep = Math.abs(height[i] - height[i - 2]) + dp[i - 2];
            }
            dp[i] = Math.min(oneStep, twoStep);
        }

        return dp[n - 1];
    }
}

public class FrogJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] height = {20, 30, 40, 20};
        int n = height.length;

        Solution sol = new Solution();
        System.out.println(sol.topDown(height));

        scanner.close();
    }
}
