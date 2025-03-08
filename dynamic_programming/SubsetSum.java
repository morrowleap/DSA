package dynamic_programming;

import java.util.Scanner;

class SubsetSumSolution {
    public Boolean topDown(int[] nums, int target) {
        int n = nums.length;
        return topDownHelper(nums, n - 1, target);
    }

    private Boolean topDownHelper(int[] nums, int n, int target) {
        if (n < 0 || target < 0) {
            return false;
        }

        if (target == 0) {
            return true;
        }

        boolean pick = topDownHelper(nums, n - 1, target - nums[n]);
        boolean notPick = topDownHelper(nums, n - 1, target);

        return pick || notPick;
    }
}

public class SubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        SubsetSumSolution sol = new SubsetSumSolution();
        System.out.println(sol.topDown(nums, x));

        sc.close();
    }
}
