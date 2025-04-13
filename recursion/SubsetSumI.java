/*
 * https://takeuforward.org/data-structure/subset-sum-sum-of-all-subsets/
 * https://youtu.be/rYkfBRtMJr8
 * https://www.geeksforgeeks.org/problems/subset-sums2234/1
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
*/

package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SubsetSumI {

    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        topDown(arr, 0, 0, res);
        topDown2(arr, 0, 0, res);
        return res;
    }

    /**
     * For-loop generating subsets
     */
    private void topDown2(int[] arr, int index, int currSum, ArrayList<Integer> res) {
        // TODO: understand and write down why it is happening
        res.add(currSum);

        for (int i = index; i < arr.length; i++) {
            topDown2(arr, i + 1, currSum + arr[i], res);
        }
    }

    /**
     * Pick and not-pick
     */
    private void topDown(int[] arr, int i, int currSum, ArrayList<Integer> res) {
        if (i == arr.length) {
            res.add(currSum);
            return;
        }
        topDown(arr, i + 1, currSum + arr[i], res);
        topDown(arr, i + 1, currSum, res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        SubsetSumI sol = new SubsetSumI();
        System.out.println(sol.subsetSums(nums));

        sc.close();
    }
}

// Recursive Time complexity: O(2^N)
// Recursive Space complexity: O(N)
