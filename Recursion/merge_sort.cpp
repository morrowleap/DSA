/*
https://www.geeksforgeeks.org/merge-sort/
https://www.geeksforgeeks.org/problems/merge-sort/1
https://youtu.be/ogjf7ORKfd8?list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9


Given an array arr[], its starting position l and its ending position r. Sort
the array using the merge sort algorithm.

Examples:

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]

Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Input: arr[] = [1, 3 , 2]
Output: [1, 2, 3]

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
  void merge(vector<int>& nums, int left, int mid, int right)
  {
    int n = right - left + 1;
    vector<int> merged(n);

    int pt1 = left;
    int pt2 = mid + 1;
    int j = 0;

    while (pt1 <= mid && pt2 <= right)
    {
      if (nums[pt1] <= nums[pt2])
      {
        merged[j++] = nums[pt1++];
      }
      else
      {
        merged[j++] = nums[pt2++];
      }
    }
    while (pt1 <= mid)
    {
      merged[j++] = nums[pt1++];
    }
    while (pt2 <= right)
    {
      merged[j++] = nums[pt2++];
    }

    j = 0;
    for (int i = left; i <= right; i++)
    {
      nums[i] = merged[j++];
    }
  }

public:
  void mergeSort(vector<int>& nums, int left, int right)
  {
    if (left < right)
    {
      int mid = left + (right - left) / 2;
      mergeSort(nums, left, mid);
      mergeSort(nums, mid + 1, right);
      merge(nums, left, mid, right);
    }
  }
};

int main()
{
  cout << "Merge Sort Algorithm" << endl;
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
  sol.mergeSort(arr, 0, n - 1);

  cout << "Sorted array: ";
  for (int i = 0; i < n; i++)
  {
    cout << arr[i] << " ";
  }
  cout << endl;

  return 0;
}
