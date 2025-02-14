import java.util.Scanner;

class Solution {
    private int topDownHelper(int n, int[] memo) {
        if(n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        if(memo[n] != -1) {
            return memo[n];
        }

        int oneStep = topDownHelper(n - 1, memo);
        int twoStep = topDownHelper(n - 2, memo);

        memo[n] = oneStep + twoStep;
        return memo[n];
    }

    public int topDown(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return topDownHelper(n, memo);
    }

    public int bottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}


public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        Solution sol = new Solution();

        System.out.println(sol.topDown(n));
        System.out.println(sol.bottomUp(n));

        scanner.close();
    }
}
