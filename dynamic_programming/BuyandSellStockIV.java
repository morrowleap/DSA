/*
 * https://takeuforward.org/data-structure/buy-and-sell-stock-iv-dp-38/
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
*/

package dynamic_programming;

import java.util.Scanner;

class BuyandSellStockIVSol {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][k + 1];

        for (int cap = 1; cap <= k; cap++) {
            dp[n][0][cap] = 0;
            dp[n][1][cap] = 0;
        }
        for (int i = 0; i <= n - 1; i++) {
            dp[i][0][0] = 0;
            dp[i][1][0] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    int profit = 0;

                    if (buy == 1) {
                        int op1 = -1 * prices[i] + dp[i + 1][0][cap];
                        int op2 = dp[i + 1][1][cap];
                        profit = Math.max(op1, op2);
                    } else {
                        int op1 = prices[i] + dp[i + 1][1][cap - 1];
                        int op2 = dp[i + 1][0][cap];
                        profit = Math.max(op1, op2);
                    }

                    dp[i][buy][cap] = profit;
                }
            }
        }

        return dp[0][1][k];
    }
}

public class BuyandSellStockIV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        BuyandSellStockIVSol sol = new BuyandSellStockIVSol();
        System.out.println(sol.maxProfit(k, arr));

        sc.close();
    }
}
