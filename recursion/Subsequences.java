/*
 * L6. Recursion on Subsequences | Printing Subsequences
 * https://youtu.be/AxNNVECce8c
 * 78. Subsets
 * https://leetcode.com/problems/subsets/description/
 * 
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SubsequencesSolution {
    public void topDown(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        topDownHelper(nums, n - 1, temp);
    }

    private void topDownHelper(int[] nums, int n, List<Integer> temp) {
        if(n == -1) {
            System.out.println(temp);
            return;
        }

        temp.add(nums[n]);
        topDownHelper(nums, n - 1, temp);
        temp.remove(temp.size() - 1);

        topDownHelper(nums, n - 1, temp);
    }
}

public class Subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        SubsequencesSolution sol = new SubsequencesSolution();
        sol.topDown(nums);

        sc.close();
    }
}
