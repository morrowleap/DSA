/*
 * https://youtu.be/WIrA4YexLRQ?list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9
 * 
 * https://www.geeksforgeeks.org/problems/quick-sort/1
*/

package recursion;

import java.util.Scanner;

public class QuickSort {

    static void quickSort(int nums[], int low, int high) {
        if (low < high) {
            int pivot_idx = partition2(nums, low, high);
            quickSort(nums, low, pivot_idx - 1);
            quickSort(nums, pivot_idx + 1, high);
        }
    }

    static int partition(int nums[], int low, int high) {
        int pivot = nums[low];

        int start = low, end = high;
        while (start < end) {
            while (nums[start] <= pivot && start <= high - 1) {
                start++;
            }
            while (nums[end] > pivot && end >= low + 1) {
                end--;
            }
            if (start < end) {
                swap(nums, start, end);
            }
        }

        swap(nums, low, end);
        return end;
    }

    // 2 5 1 3 4
    static int partition2(int nums[], int low, int high) {
        int pivot = nums[low];
        int leftwall = low;
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] < pivot) {
                leftwall++;
                swap(nums, i, leftwall);
            }
        }
        swap(nums, low, leftwall);
        return leftwall;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void sort(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        QuickSort sol = new QuickSort();
        sol.sort(nums);

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
