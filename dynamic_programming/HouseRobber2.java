package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

class Solution {
    private int topDownHelper(int n, int[] nums, int[] memo) {
        if(n < 0) {
            return 0;
        }

        if(memo[n] != -1) {
            return memo[n];
        }

        int pick = nums[n] + topDownHelper(n - 2, nums, memo);
        int notPick = topDownHelper(n - 1, nums, memo);

        memo[n] = Math.max(pick, notPick);
        return memo[n];
    }

    public int topDown(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        int[] memo = new int[n - 1];
        
        int[] nums1 = Arrays.copyOfRange(nums, 1, n);
        for(int i=0;i<n-1;i++) {memo[i] = -1;}
        int count1 = topDownHelper(nums1.length - 1, nums1, memo);

        int[] nums2 = Arrays.copyOfRange(nums, 0, n - 1);
        for(int i=0;i<n-1;i++) {memo[i] = -1;}
        int count2 = topDownHelper(nums2.length - 1, nums2, memo);

        return Math.max(count1, count2);
    }
}

public class HouseRobber2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) {
            nums[i] = scanner.nextInt();
        }

        Solution sol = new Solution();
        System.out.println(sol.topDown(nums));

        scanner.close();
    }
}