package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class UnboundedKnapsackSol {

    public int topDown(int w, int[] val, int[] wt) {
        int n = val.length;
        int[][] memo = new int[n][w + 1];
        return topDownHelper(w, n - 1, val, wt, memo);
    }

    private int topDownHelper(int w, int n, int[] val, int[] wt, int[][] memo) {
        if (n == 0) {
            if (wt[0] <= w) {
                return ((int) (w / wt[0])) * val[0];
            } else {
                return 0;
            }
        }

        int pick = Integer.MIN_VALUE;
        if(wt[n] <= w) {
            pick = val[n] + topDownHelper(w - wt[n], n, val, wt, memo);
        }
        int notpick = topDownHelper(w, n - 1, val, wt, memo);

        return Math.max(pick, notpick);
    }

}

public class UnboundedKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        int W = sc.nextInt();

        UnboundedKnapsackSol sol = new UnboundedKnapsackSol();
        System.out.println(sol.topDown(W, val, wt));

        sc.close();
    }
}
