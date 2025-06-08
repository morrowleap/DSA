/*
Q1. Spelling Checker
Unsolved
feature icon
Using hints except Complete Solution is Penalty free now
Use Hint
Problem Description

Given an array of words A (dictionary) and another array B (which contain some words).

You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.

Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.

Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.

NOTE: Try to do this in O(n) time complexity.


Problem Constraints

1 <= |A| <= 1000

1 <= sum of all strings in A <= 50000

1 <= |B| <= 1000

Input Format

First argument is array of strings A.

First argument is array of strings B.


Output Format

Return the binary array of integers according to the given format.

Example Input

Input 1:

A = [ "hat", "cat", "rat" ]
B = [ "cat", "ball" ]
Input 2:

A = [ "tape", "bcci" ]
B = [ "table", "cci" ]


Example Output

Output 1:
[1, 0]
Output 2:
[0, 0]

Example Explanation

Explanation 1:

Only "cat" is present in the dictionary.
Explanation 2:

None of the words are present in the dictionary.

Expected Output
Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
Arg 1: A String Array, For e.g ['hello','world']
Enter Input Here
Arg 2: A String Array, For e.g ['hello','world']
Enter Input Here

*/

package trie;

import java.util.ArrayList;
import java.util.List;

class Node {
    Node[] links;
    boolean flag;
    boolean isTerminal;

    Node() {
        links = new Node[26];
        flag = false;
        isTerminal = false;
    }
}

class Trie {
    Node head;

    Trie() {
        head = new Node();
        head.flag = true;
    }

    public void insert(String word) {
        char[] chArr = word.toCharArray();
        Node temp = head;
        for (int i = 0; i < chArr.length; i++) {
            char ch = chArr[i];
            if (temp.links[ch - 'a'] == null) {
                temp.links[ch - 'a'] = new Node();
            }
            temp.links[ch - 'a'].flag = true;
            temp = temp.links[ch - 'a'];
        }

        temp.isTerminal = true;
    }

    public boolean search(String word) {
        char[] chArr = word.toCharArray();
        Node temp = head;
        for (int i = 0; i < chArr.length; i++) {
            char ch = chArr[i];
            if (temp.links[ch - 'a'] != null && temp.links[ch - 'a'].flag == true) {
                temp = temp.links[ch - 'a'];
            } else {
                return false;
            }
        }
        return temp.isTerminal == true ? true : false;
    }
}

public class SpellingChecker {

    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        ArrayList<Integer> res = new ArrayList<>();
        Trie trie = new Trie();
        for (int i = 0; i < A.size(); i++) {
            trie.insert(A.get(i));
        }
        for (int i = 0; i < B.size(); i++) {
            res.add(trie.search(B.get(i)) ? 1 : 0);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out
                .println(new SpellingChecker().solve(new ArrayList<>(List.of("hat", "cat", "rat")),
                        new ArrayList<>(List.of("cat", "ball"))));
        System.out
                .println(new SpellingChecker().solve(new ArrayList<>(List.of("tape", "bcci")),
                        new ArrayList<>(List.of("table", "cci"))));
    }

}
