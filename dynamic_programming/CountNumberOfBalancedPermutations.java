/*
 * https://leetcode.com/problems/count-number-of-balanced-permutations
 * 
 * https://leetcode.com/problems/count-number-of-balanced-permutations/submissions/1629451480/?envType=daily-question&envId=2025-05-09
*/

package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBalancedPermutations {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        String num = "05527880260514942";
        CountNumberOfBalancedPermutations sol = new CountNumberOfBalancedPermutations();
        System.out.println(sol.countBalancedPermutations(num));
    }

    public int countBalancedPermutations(String s) {
        int n = s.length();
        int[] nums = new int[n];

        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            nums[i] = chars[i] - '0';
        }

        int[] hash = new int[10];
        for (int num : nums) {
            hash[num]++;
        }

        Map<String, Integer> memo = new HashMap<>();
        return backtrack(nums, 0, 0, hash, memo);
    }

    private int backtrack(int[] nums, int index, int diff, int[] hash, Map<String, Integer> memo) {
        if (index == nums.length) {
            return diff == 0 ? 1 : 0;
        }

        String key = index + "," + diff + Arrays.toString(hash);
        if (memo.containsKey(key))
            return memo.get(key);

        long cnt = 0;

        for (int n = 0; n < 10; n++) {
            if (hash[n] > 0) {
                hash[n]--;
                diff += (index % 2 == 0) ? n : -n;
                cnt += backtrack(nums, index + 1, diff, hash, memo);
                diff += (index % 2 == 0) ? -n : n;
                hash[n]++;
            }
        }

        int res = (int) (cnt % MOD);
        memo.put(key, res);
        return res;
    }
}
