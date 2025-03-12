/*
 * Striver Recursion Series
L7. All Kind of Patterns in Recursion | Print All | Print one | Count

Printing Subsequences Whose Sum Equals K.

subsequences_with_sum_k.cpp
check_subsequence_with_sum_k.cpp
count_subsequence_sum_k.cpp
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SubsequencesWithSumKSolution {
    public void topDown(int[] nums, int target) {
        int n = nums.length;
        List<Integer> curr = new ArrayList<>();
        topDownHelper(nums, n - 1, target, curr);
    }

    private void topDownHelper(int[] nums, int n, int target, List<Integer> curr) {
        if(target == 0) {
            System.out.println(curr);
            return;
        }

        if (n == 0) {
            if (target == nums[0]) {
                curr.add(nums[n]);
                System.out.println(curr);
                curr.remove(curr.size() - 1);
            }
            return;
        }

        if(target - nums[n] >= 0) {
            curr.add(nums[n]);
            topDownHelper(nums, n - 1, target - nums[n], curr);
            curr.remove(curr.size() - 1);
        }
        
        topDownHelper(nums, n - 1, target, curr);
    }
}

public class SubsequencesWithSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        SubsequencesWithSumKSolution sol = new SubsequencesWithSumKSolution();
        sol.topDown(nums, k);

        sc.close();
    }
}
