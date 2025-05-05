/*
 * https://takeuforward.org/data-structure/count-inversions-in-an-array/
 * https://youtu.be/AseUmwVNaoY
 * 
 * https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
*/

package arrays;

public class CountInversions {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 1, 3, 5 };

        System.out.println(CountInversions.inversionCount3(arr));
    }

    /**
     * Optimal Approach: 
     */
    static int inversionCount3(int[] arr) {

        throw new UnsupportedOperationException("Unimplemented method 'inversionCount3'");
    }

    /**
     * Brute-Force: Recursive code converted to Iterative
     * T.C: O(N^2)
     * S.C: O(1)
     */
    static int inversionCount2(int[] nums) {
        int N = nums.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (nums[i] < nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Recursive approach
     * T.C: O(N^2)
     * S.C: O(N)
     */
    static int inversionCount1(int[] nums) {
        int N = nums.length;
        return recur(N, 0, nums);
    }

    private static int recur(int N, int index, int[] nums) {
        if (index == N) {
            return 0;
        }

        int count = 0;
        for (int i = index + 1; i < N; i++) {
            if (nums[i] < nums[index]) {
                count++;
            }
        }

        return count + recur(N, index + 1, nums);
    }
}
