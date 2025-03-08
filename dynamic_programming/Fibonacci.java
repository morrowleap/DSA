package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

class FibonacciSolution {
    static final int MOD = 1_000_000_007;

    static int topDown(int n, int[] memo) {
        if (n < 2) return n;
        if (memo[n] != -1) return memo[n];
        memo[n] = (topDown(n - 1, memo) + topDown(n - 2, memo)) % MOD;
        return memo[n];
    }

    static long topDown(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return topDown(n, memo);
    }

    static long bottomUp(int n) {
        if (n < 2) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = (a + b) % MOD;
            a = b;
            b = temp;
        }
        return b;
    }
}

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(n + "th index fibonacci number from top down approach: " + FibonacciSolution.topDown(n));
        System.out.println(n + "th index fibonacci number from bottom up approach: " + FibonacciSolution.bottomUp(n));

        sc.close();
    }
}
