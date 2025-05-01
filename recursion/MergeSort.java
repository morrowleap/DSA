/*
 * https://youtu.be/ogjf7ORKfd8?list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9
 * 
 * https://www.geeksforgeeks.org/problems/merge-sort/1
*/

package recursion;

import java.util.Scanner;

public class MergeSort {

    private void merge(int[] nums, int left, int mid, int right) {
        int n = right - left + 1;
        int[] curr = new int[n];

        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right && k < n) {
            if (nums[i] < nums[j]) {
                curr[k] = nums[i];
                k++;
                i++;
            } else {
                curr[k] = nums[j];
                j++;
                k++;
            }
        }
        while (i <= mid && k < n) {
            curr[k] = nums[i];
            k++;
            i++;
        }
        while (j <= right && k < n) {
            curr[k] = nums[j];
            j++;
            k++;
        }

        for (i = left, j = 0; i <= right && j < n; i++, j++) {
            nums[i] = curr[j];
        }
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void sort(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        MergeSort sol = new MergeSort();
        sol.sort(nums);

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        sc.close();

    }
}
