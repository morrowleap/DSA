/*
https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/

Tower of Hanoi is a mathematical puzzle where we have three rods (A, B, and C)
and N disks. Initially, all the disks are stacked in decreasing value of
diameter i.e., the smallest disk is placed on the top and they are on rod A. The
objective of the puzzle is to move the entire stack to another rod (here
considered C), obeying the following simple rules:

Only one disk can be moved at a time.
Each move consists of taking the upper disk from one of the stacks and placing
it on top of another stack i.e. a disk can only be moved if it is the uppermost
disk on a stack. No disk may be placed on top of a smaller disk.


Examples:


Input: 2
Output: Disk 1 moved from A to B
Disk 2 moved from A to C
Disk 1 moved from B to C


Input: 3
Output: Disk 1 moved from A to C
Disk 2 moved from A to B
Disk 1 moved from C to B
Disk 3 moved from A to C
Disk 1 moved from B to A
Disk 2 moved from B to C
Disk 1 moved from A to C


Follow the steps below to solve the problem:

Create a function towerOfHanoi where pass the N (current number of disk),
from_rod, to_rod, aux_rod.

Make a function call for N – 1 th disk.

Then print the current the disk along with from_rod and to_rod

Again make a function call for N – 1 th disk.
*/

#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
  void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod)
  {
  }
};

int main()
{
  cout << "Tower of Hanoi Puzzle\n";
  cout << "This puzzle involves three rods (A, B, and C) and a number of "
          "disks.\n";
  cout << "The disks are stacked in decreasing order of size from top to "
          "bottom,\n";
  cout << "where the 1st disk is the smallest (at the top) and the Nth disk is "
          "the largest (at the bottom).\n";
  cout << "Rules:\n";
  cout << "1. Only one disk can be moved at a time.\n";
  cout << "2. A disk can only be moved if it is the uppermost disk on a rod.\n";
  cout << "3. No disk may be placed on top of a smaller disk.\n\n";
  cout << "Enter the number of disks: ";
  int n;
  cin >> n;
  Solution sol;
  sol.towerOfHanoi(n, 'A', 'C', 'B');
  return 0;
}
