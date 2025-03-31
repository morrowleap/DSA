package sorting;

import java.util.Scanner;

class QuickSortSol {

    public void sort(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot_idx = partition(nums, low, high);
        quickSort(nums, low, pivot_idx - 1);
        quickSort(nums, pivot_idx + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int start = low;
        int end = high;

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

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        QuickSortSol sol = new QuickSortSol();
        sol.sort(nums);

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
