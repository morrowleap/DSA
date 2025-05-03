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
        System.out.println(sol.majorityElement2(nums));
    }

    /**
     * Extended Moore Algo
     * T.C: O(N)
     * S.C: O(1)
     */
    private List<Integer> majorityElement2(int[] nums) {
        int ele1 = 0, count1 = 0;
        int ele2 = 0, count2 = 0;

        for (int num : nums) {
            if (count1 == 0 && num != ele2) {
                ele1 = num;
                count1 = 1;
            } else if (count2 == 0 && num != ele1) {
                ele2 = num;
                count2 = 1;
            } else if (ele1 == num) {
                count1++;
            } else if (ele2 == num) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // Verify if moree algo produced right candidate
        count1 = 0;
        count2 = 0;
        int threshold = (int) (nums.length / 3) + 1;
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            if (num == ele1) {
                count1++;
                if (count1 == threshold) {
                    res.add(ele1);
                }
            } else if (num == ele2) {
                count2++;
                if (count2 == threshold) {
                    res.add(ele2);
                }
            }

            if (res.size() == 2) {
                break;
            }
        }

        return res;
    }

    /**
     * Optimized Hashing Approach
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
