/*
 * Q3. Shortest Unique Prefix
Unsolved
feature icon
Using hints except Complete Solution is Penalty free now
Use Hint
Problem Description

Given a list of N words, find the shortest unique prefix to represent each word in the list.




NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible






Problem Constraints

1 <= Sum of length of all words <= 106



Input Format

First and only argument is a string array of size N.



Output Format

Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.



Example Input

Input 1:

 A = ["zebra", "dog", "duck", "dove"]
Input 2:

A = ["apple", "ball", "cat"]


Example Output

Output 1:

 ["z", "dog", "du", "dov"]
Output 2:

 ["a", "b", "c"]


Example Explanation

Explanation 1:

 Shortest unique prefix of each word is:
 For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".  
 
Explanation 2:

 "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.



Expected Output
Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
Arg 1: A String Array, For e.g ['hello','world']
Enter Input Here
Run
*/

package trie;

import java.util.ArrayList;
import java.util.List;

class Node3 {
    Node3[] links;
    boolean flag;
    boolean isTerminal;
    int count;

    Node3() {
        links = new Node3[26];
        flag = false;
        isTerminal = false;
        count = 0;
    }
}

class Trie3 {
    Node3 head;

    Trie3() {
        head = new Node3();
    }

    public void insert(String word) {
        char[] chArr = word.toCharArray();
        Node3 temp = head;
        for (int i = 0; i < chArr.length; i++) {
            char ch = chArr[i];

            if (temp.links[ch - 'a'] == null) {
                temp.links[ch - 'a'] = new Node3();
            }
            temp.links[ch - 'a'].flag = true;
            temp.links[ch - 'a'].count++;
            temp = temp.links[ch - 'a'];
        }
        temp.isTerminal = true;
    }

    public String findUniquePrefix(String word) {
        StringBuilder res = new StringBuilder();
        Node3 temp = head;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            int count = 0;
            for (int j = 0; j < 26; j++) {
                if (temp.links[j] != null) {
                    count += temp.links[j].count;
                }
            }

            if (count == 1) {
                break;
            } else {
                res.append(ch);
                temp = temp.links[ch - 'a'];
            }
        }

        return res.toString();
    }
}

public class ShortestUniquePrefix {
    public ArrayList<String> prefix(ArrayList<String> A) {
        Trie3 trie = new Trie3();
        for (String a : A) {
            trie.insert(a);
        }
        ArrayList<String> res = new ArrayList<>();
        for (String a : A) {
            res.add(trie.findUniquePrefix(a));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestUniquePrefix().prefix(new ArrayList<>(List.of("zebra", "dog", "duck", "dove"))));
        System.out.println(new ShortestUniquePrefix().prefix(new ArrayList<>(List.of("apple", "ball", "cat"))));
        System.out.println(new ShortestUniquePrefix().prefix(new ArrayList<>(List.of("bearcat", "bert"))));
    }
}
