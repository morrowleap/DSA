/*
https://www.geeksforgeeks.org/quick-sort-algorithm/
https://www.geeksforgeeks.org/problems/quick-sort/1
https://youtu.be/WIrA4YexLRQ?list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9

Implement Quick Sort, a Divide and Conquer algorithm, to sort an array, arr[] in
ascending order. Given an array, arr[], with starting index low and ending index
high, complete the functions partition() and quickSort(). Use the last element
as the pivot so that all elements less than or equal to the pivot come before
it, and elements greater than the pivot follow it.

Note: The low and high are inclusive.

Examples:

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Explanation: After sorting, all elements are arranged in ascending order.

Input: arr[] = [2, 1, 6, 10, 4, 1, 3, 9, 7]
Output: [1, 1, 2, 3, 4, 6, 7, 9, 10]
Explanation: Duplicate elements (1) are retained in sorted order.

Input: arr[] = [5, 5, 5, 5]
Output: [5, 5, 5, 5]
Explanation: All elements are identical, so the array remains unchanged.

Constraints:
1 <= arr.size() <= 105
1 <= arr[i] <= 105
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution
{
private:
  int partition(vector<int>& nums, int low, int high)
  {
    int pivot = nums[low];
    int start = low;
    int end = high;
    while (start < end)
    {
      while (nums[start] <= pivot && start <= high - 1)
      {
        start++;
      }
      while (nums[end] > pivot && end >= low + 1)
      {
        end--;
      }
      if (start < end)
      {
        swap(nums[start], nums[end]);
      }
    }
    swap(nums[low], nums[end]);
    return end;
  }

public:
  void quickSort(vector<int>& nums, int low, int high)
  {
    if (low < high)
    {
      int pivot_idx = partition(nums, low, high);
      quickSort(nums, low, pivot_idx - 1);
      quickSort(nums, pivot_idx + 1, high);
    }
  }
};

int main()
{
  cout << "Quick Sort Algorithm" << endl;
  cout << "Enter the size of the array: ";
  int n;
  cin >> n;

  vector<int> arr(n);
  cout << "Enter the elements of the array: ";
  for (int i = 0; i < n; i++)
  {
    cin >> arr[i];
  }

  Solution sol;
  sol.quickSort(arr, 0, n - 1);

  cout << "Sorted array: ";
  for (int i = 0; i < n; i++)
  {
    cout << arr[i] << " ";
  }
  cout << endl;

  return 0;
}
