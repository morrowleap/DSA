package dynamic_programming;

import java.util.Scanner;

class CountSubsetsWithSumKSolution {

    public int topDown(int[] nums, int target) {
        int n = nums.length;
        return topDownHelper(nums, n - 1, target);
    }

    private int topDownHelper(int[] nums, int n, int target) {
        if (n == 0) {
            if(target == 0 && nums[0] == 0) {return 2;}
            if(target == 0 || nums[0] == target) {return 1;}
            return 0;
        }

        int notPick = topDownHelper(nums, n - 1, target);
        int pick = 0;
        if (nums[n] <= target) {
            pick = topDownHelper(nums, n - 1, target - nums[n]);
        }

        return pick + notPick;
    }
}

public class CountSubsetsWithSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        CountSubsetsWithSumKSolution sol = new CountSubsetsWithSumKSolution();
        System.out.println(sol.topDown(nums, target));

        sc.close();
    }
}
