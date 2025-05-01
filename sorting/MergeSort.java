package sorting;

import java.util.Scanner;

class MergeSortSol {

    private void mergeSort(int[] nums, int left, int right) { // [0, 1, 2, 3]
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int n = right - left + 1;

        int[] mergedArr = new int[n];
        int pt1 = left, pt2 = mid + 1, j = 0;

        while (pt1 <= mid && pt2 <= right && j < n) {
            if (nums[pt1] <= nums[pt2]) {
                mergedArr[j] = nums[pt1];
                j++;
                pt1++;
            } else {
                mergedArr[j] = nums[pt2];
                j++;
                pt2++;
            }
        }
        while (pt1 <= mid && j < n) {
            mergedArr[j] = nums[pt1];
            j++;
            pt1++;
        }
        while (pt2 <= right && j < n) {
            mergedArr[j] = nums[pt2];
            j++;
            pt2++;
        }

        j = 0;
        for (int i = left; i <= right; i++, j++) {
            nums[i] = mergedArr[j];
        }
    }

    public void sort(int[] nums) {
        // divide(nums) in half
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
    }
}

