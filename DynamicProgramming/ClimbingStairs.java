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
}

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Solution sol = new Solution();
        System.out.println(sol.topDown(n));

        scanner.close();
    }
}
