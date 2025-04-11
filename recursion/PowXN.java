/*
 * https://takeuforward.org/data-structure/implement-powxn-x-raised-to-the-power-n/
 * https://leetcode.com/problems/powx-n/
*/

package recursion;

import java.util.Scanner;

public class PowXN {
    public double topDown(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        if (n % 2 == 0) {
            return topDown(x * x, n / 2);
        } else {
            return x * topDown(x, n - 1);
        }
    }

    public double myPow(double x, int n) {
        return topDown(x, n);
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
