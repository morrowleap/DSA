package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class CountPartitionsWithGivenDifferenceSolution {
    public int topDown(int[] nums, int diff) {
        int n = nums.length;

        int totalSum = Arrays.stream(nums).sum();

        if ((totalSum - diff) >= 0 && (totalSum - diff) % 2 == 0) {
            int target = (totalSum - diff) / 2;

            int[][] memo = new int[n][target + 1];
            for (int[] row : memo)
                Arrays.fill(row, -1);

            return topDownHelper(nums, n - 1, target, memo);
        } else {
            return 0;
        }
    }

    private int topDownHelper(int[] nums, int n, int target, int[][] memo) {
        if (n == 0) {
            if (target == 0 && nums[0] == 0) {
                return 2;
            }
            if (target == 0 || nums[0] == target) {
                return 1;
            }
            return 0;
        }

        if (memo[n][target] != -1) {
            return memo[n][target];
        }

        int notPick = topDownHelper(nums, n - 1, target, memo);
        int pick = 0;
        if (nums[n] <= target) {
            pick = topDownHelper(nums, n - 1, target - nums[n], memo);
        }

        memo[n][target] = notPick + pick;
        return memo[n][target];
    }
}

public class CountPartitionsWithGivenDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int diff = sc.nextInt();

        CountPartitionsWithGivenDifferenceSolution sol = new CountPartitionsWithGivenDifferenceSolution();
        System.out.println(sol.topDown(nums, diff));

        sc.close();
    }
}
