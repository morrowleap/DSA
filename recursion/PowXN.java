/*
 * https://takeuforward.org/data-structure/implement-powxn-x-raised-to-the-power-n/
 * https://leetcode.com/problems/powx-n/
*/

package recursion;

import java.util.Scanner;

public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        long k = n;
        if (k < 0) {
            x = 1 / x;
            k = -k;
        }

        if (n % 2 == 0) {
            return myPow(x * x, (int) (k / 2));
        } else {
            return x * myPow(x, (int) (k - 1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x = sc.nextDouble();
        int n = sc.nextInt();

        PowXN sol = new PowXN();
        System.out.println(sol.myPow(x, n));

        sc.close();
    }
}

// Time Complexity: At each step the power n is divided by 2, O(logN)
// Space Complexity: Recursion stack depth same as time