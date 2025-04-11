/*
 * https://takeuforward.org/data-structure/stock-buy-and-sell-dp-35/
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
*/

package dynamic_programming;

import java.util.Scanner;

class StockBuyandSellSol {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int minBuy = prices[0], maxProfit = 0;
        for (int i = 1; i < n; i++) {
            int currCost = prices[i] - minBuy;
            maxProfit = Math.max(maxProfit, currCost);
            minBuy = Math.min(minBuy, prices[i]);
        }

        return maxProfit;
    }
}

public class BuyandSellStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        StockBuyandSellSol sol = new StockBuyandSellSol();
        System.out.println(sol.maxProfit(arr));

        sc.close();
    }
}
