/*
 * https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/
 * https://youtu.be/vwZj1K0e9U8
 * 
 * https://leetcode.com/problems/majority-element-ii/description/
*/

package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int nums[] = { 2, 1, 1, 3, 1, 4, 5, 6 };

        MajorityElement2 sol = new MajorityElement2();
        System.out.println(sol.majorityElement1(nums));
    }

    /**
     * Hashing Approach
     * T.C: O(N)
     * S.C: O(N)
     */
    public List<Integer> majorityElement1(int[] nums) {
        // Observation: How many elements can appear more than n/3 times, only 2
        // elements. So the answer list will be of size 2 max

        HashMap<Integer, Integer> hash = new HashMap<>();
        int n = nums.length;
        int threshold = (int) (n / 3) + 1;
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            int count = hash.merge(num, 1, Integer::sum);

            if (count == threshold) { // This will only add into list when the element exceeds n/3 limit, first
                                      // time
                res.add(num);

                if (res.size() == 2) { // As soon as result reaches 2, break
                    break;
                }
            }

            // Both checks help in doing it in one go
        }

        return res;
    }
}
