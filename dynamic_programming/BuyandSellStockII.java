/*
 * https://takeuforward.org/data-structure/buy-and-sell-stock-ii-dp-36/
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
*/

package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class BuyandSellStockIISol {

    private int topDownHelper(int i, int buy, int[] prices, int[][] memo) {
        if (i == prices.length) {
            return 0;
        }

        if (memo[i][buy] != -1) {
            return memo[i][buy];
        }

        int profit = 0;

        if (buy == 1) {
            // There can be possibility that I buy at current index and add the buying part
            // to the profit, profit = sell - buy
            int op1 = -1 * prices[i] + topDownHelper(i + 1, 0, prices, memo);
            int op2 = topDownHelper(i + 1, 1, prices, memo);
            profit += Math.max(op1, op2);
        } else {
            // If you have buyed previosly, now you can only sell before buying again
            int op1 = prices[i] + topDownHelper(i + 1, 1, prices, memo);
            int op2 = topDownHelper(i + 1, 0, prices, memo);
            profit += Math.max(op1, op2);
        }

        memo[i][buy] = profit;
        return memo[i][buy];
    }

    private int topDown(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n][2];
        for (int[] rows : memo) {
            Arrays.fill(rows, -1);
        }
        return topDownHelper(0, 1, prices, memo);
    }

    private int bottomUp(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 1) {
                    // There can be possibility that I buy at current index and add the buying part
                    // to the profit, profit = sell - buy
                    int op1 = -1 * prices[i] + dp[i + 1][0];
                    int op2 = dp[i + 1][1];
                    profit += Math.max(op1, op2);
                } else {
                    // If you have buyed previosly, now you can only sell before buying again
                    int op1 = prices[i] + dp[i + 1][1];
                    int op2 = dp[i + 1][0];
                    profit += Math.max(op1, op2);
                }

                dp[i][buy] = profit;
            }
        }

        return dp[0][1];
    }

    public int maxProfit(int[] prices) {
        bottomUp(prices);
        return topDown(prices);
    }
}

public class BuyandSellStockII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        BuyandSellStockIISol sol = new BuyandSellStockIISol();
        System.out.println(sol.maxProfit(arr));

        sc.close();
    }
}
