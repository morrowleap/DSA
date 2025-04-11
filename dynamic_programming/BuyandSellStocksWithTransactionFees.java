/*
 * https://takeuforward.org/data-structure/buy-and-sell-stocks-with-transaction-fees-dp-40/
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
*/

package dynamic_programming;

import java.util.Scanner;

class BuyandSellStocksWithTransactionFeesSol {

    public int maxProfit(int[] prices, int fee) {
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
                    int op1 = prices[i] - fee + dp[i + 1][1];
                    int op2 = dp[i + 1][0];
                    profit += Math.max(op1, op2);
                }

                dp[i][buy] = profit;
            }
        }

        return dp[0][1];
    }
}

public class BuyandSellStocksWithTransactionFees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        BuyandSellStocksWithTransactionFeesSol sol = new BuyandSellStocksWithTransactionFeesSol();
        System.out.println(sol.maxProfit(arr, k));

        sc.close();
    }
}
