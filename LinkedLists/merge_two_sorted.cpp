/*
https://leetcode.com/problems/merge-two-sorted-lists/description/
21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing
together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 */

#include <iostream>
#include <vector>

using namespace std;

struct ListNode
{
  int val;
  ListNode* next;

  ListNode() : val(0), next(nullptr)
  {
  }
  ListNode(int x) : val(x), next(nullptr)
  {
  }
  ListNode(int x, ListNode* next) : val(x), next(next)
  {
  }
};

class Solution
{
public:
  ListNode* mergeTwoLists(ListNode* list1, ListNode* list2)
  {
    ListNode* dummy = new ListNode(-1);
    ListNode* current = dummy;
    while (list1 != nullptr && list2 != nullptr)
    {
      if (list1->val < list2->val)
      {
        current->next = list1;
        list1 = list1->next;
      }
      else
      {
        current->next = list2;
        list2 = list2->next;
      }
      current = current->next;
    }
    if (list1 != nullptr)
    {
      current->next = list1;
    }
    if (list2 != nullptr)
    {
      current->next = list2;
    }

    ListNode* mergedList = dummy->next;
    delete dummy; // Free the memory of dummy node
    return mergedList;
  }
};

int main()
{
  ListNode* list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
  ListNode* list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

  Solution solution;
  ListNode* mergedList = solution.mergeTwoLists(list1, list2);

  while (mergedList != nullptr)
  {
    cout << mergedList->val << " ";
    mergedList = mergedList->next;
  }
  cout << endl;

  return 0;
}