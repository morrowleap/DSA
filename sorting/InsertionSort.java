package sorting;

import java.util.Scanner;

class InsertionSortSol {
    public void sort(int[] nums) {
        int n = nums.length;
        // Insertion Sort:
        // sorted part | unsorted part

        // 0 1 2 3 4 5 6 7 8
        // 8 9 7 6 5 4 3 2 1
        // pt1 = 0;

        for (int b = 1; b < n; b++) {
            int j = b;
            while (j > 0 && nums[j] < nums[j - 1]) {
                swap(nums, j, j - 1);
                j--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        InsertionSortSol sol = new InsertionSortSol();
        sol.sort(nums);

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        sc.close();
    }

}
