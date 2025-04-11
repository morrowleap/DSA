/*
 * https://takeuforward.org/data-structure/buy-and-sell-stock-iii-dp-37/
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
*/

package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class BuyandSellStockIIISol {
    public int maxProfit(int[] prices) {
        return topDown(prices);
    }

    private int topDown(int[] prices) {
        int n = prices.length;
        int[][][] memo = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return topDownHelper(0, 1, 2, prices, memo);
    }

    private int topDownHelper(int i, int buy, int cap, int[] prices, int[][][] memo) {
        if (i == prices.length || cap == 0) {
            return 0;
        }

        if (memo[i][buy][cap] != -1) {
            return memo[i][buy][cap];
        }

        int profit = 0;

        if (buy == 1) {
            int op1 = -1 * prices[i] + topDownHelper(i + 1, 0, cap, prices, memo);
            int op2 = topDownHelper(i + 1, 1, cap, prices, memo);
            profit = Math.max(op1, op2);
        } else {
            int op1 = prices[i] + topDownHelper(i + 1, 1, cap - 1, prices, memo);
            int op2 = topDownHelper(i + 1, 0, cap, prices, memo);
            profit = Math.max(op1, op2);
        }

        memo[i][buy][cap] = profit;
        return memo[i][buy][cap];
    }
}

public class BuyandSellStockIII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        BuyandSellStockIIISol sol = new BuyandSellStockIIISol();
        System.out.println(sol.maxProfit(arr));

        sc.close();
    }
}
