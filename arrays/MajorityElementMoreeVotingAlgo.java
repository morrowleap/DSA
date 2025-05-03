/*
 * https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/
 * https://youtu.be/nP_ns3uSh80
 * 
 * https://leetcode.com/problems/majority-element/description/
*/

package arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementMoreeVotingAlgo {
    public static void main(String[] args) {
        int nums[] = { 3, 2, 3 };

        MajorityElementMoreeVotingAlgo sol = new MajorityElementMoreeVotingAlgo();
        System.out.println(sol.majorityElement1(nums));
    }

    /**
     * Better Approach: Hashing
     * T.C: O(N)
     * S.C: O(N)
     */
    public List<Integer> majorityElement1(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : hash.entrySet()) {

        }
        return null;
    }
}
