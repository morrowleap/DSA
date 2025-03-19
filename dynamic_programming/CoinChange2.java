/*
 * https://takeuforward.org/data-structure/coin-change-2-dp-22/
 * https://leetcode.com/problems/coin-change-ii/description/
*/

package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class CoinChange2Solution {

    public int topDown(int[] nums, int target) {
        int n = nums.length;
        
        int[][] memo = new int[n][target + 1];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }

        return topDownHelper(nums, n - 1, target, memo);
    }

    private int topDownHelper(int[] nums, int n, int target, int[][] memo) { // Number of ways to get the amount
        if(n == 0) {
            if(target == 0) {
                return 1;
            }
            if(target % nums[0] == 0) {
                return 1;
            }
            return 0;
        }

        if(memo[n][target] != -1) {
            return memo[n][target];
        }

        int notPick = topDownHelper(nums, n - 1, target, memo);
        int pick = 0;
        if(nums[n] <= target) {
            pick = topDownHelper(nums, n, target - nums[n], memo);
        }

        memo[n][target] = pick + notPick;
        return memo[n][target];
    }

}

public class CoinChange2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        CoinChange2Solution sol = new CoinChange2Solution();
        System.out.println(sol.topDown(nums, target));

        sc.close();
    }
}
