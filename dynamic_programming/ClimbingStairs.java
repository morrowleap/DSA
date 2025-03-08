package dynamic_programming;

import java.util.Scanner;

class Solution {
    private int topDownHelper(int n, int[] memo) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return 1;
        }

        if(memo[n] != -1) {
            return memo[n];
        }

        memo[n] = topDownHelper(n - 1, memo) + topDownHelper(n - 2, memo);
        return memo[n];
    }

    public int topDown(int n) {
        int[] memo = new int[n + 1];
        for(int i=0;i<=n;i++) {memo[i] = -1;}
        return topDownHelper(n, memo);
    }

    public int bottomUp(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;

        for(int i=2;i<=n;i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
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
