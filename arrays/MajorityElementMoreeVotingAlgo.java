/*
 * https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/
 * https://youtu.be/nP_ns3uSh80
 * 
 * https://leetcode.com/problems/majority-element/description/
*/

package arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementMoreeVotingAlgo {
    public static void main(String[] args) {
        int nums[] = { 3, 2, 3 };

        MajorityElementMoreeVotingAlgo sol = new MajorityElementMoreeVotingAlgo();
        System.out.println(sol.majorityElement2(nums));
    }

    /**
     * Moore Voting Algo
     * T.C: O(N)
     * S.C: O(1)
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        int ele = 0;

        for (int num : nums) {
            if (count == 0) {
                ele = num;
            }

            if (ele == num) {
                count++;
            } else {
                count--;
            }
        }

        // Verify if moree algo produced right candidate
        count = 0;
        for (int num : nums) {
            if (num == ele) {
                count++;
            }
        }
        if (count > nums.length / 2) {
            return ele;
        }
        return -1;
    }

    /**
     * Hashing Approach
     * T.C: O(N)
     * S.C: O(N)
     */
    public int majorityElement1(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : hash.entrySet()) {
            int num = e.getKey();
            int count = e.getValue();

            if (count > n / 2) {
                return num;
            }
        }
        return -1;
    }
}
