/*
 * https://leetcode.com/problems/count-good-numbers/description/
 * 
*/

package recursion;

import java.util.Scanner;

public class CountGoodNumbers {

    private static final int MOD = (int) 1e9 + 7;

    public long topDown(long x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            return topDown((x * x) % MOD, n / 2);
        } else {
            return (x * topDown(x, n - 1)) % MOD;
        }
    }

    public int countGoodNumbers(long n) {
        long oddPositions = n / 2;
        long evenPositions = n - oddPositions;

        return (int) ((topDown(4, oddPositions) * topDown(5, evenPositions)) % MOD);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();

        CountGoodNumbers sol = new CountGoodNumbers();
        System.out.println(sol.countGoodNumbers(n));

        sc.close();
    }
}
