/*
 * Q2. Auto Complete
Unsolved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints except Complete Solution is Penalty free now
Use Hint
Problem Description

There is a dictionary A of N words, and ith word has a unique weight Wi.

Another string array B of size M contains the prefixes. For every prefix B[i], output atmost 5 words from the dictionary A that start with the same prefix.

Output the words in decreasing order of their weight.

NOTE: If there is no word that starts with the given prefix output -1.


Problem Constraints

1 <= T <= 5

1 <= N <= 20000
1 <= M <= 10000

1 <= Wi <= 106

1 <= length of any string either in A or B <= 30



Input Format

First line is an integer T denoting the number of test cases.
For each test case,

First line denotes two space seperated integer N and M.
Second line denotes N space seperated strings denoting the words in dictionary.
Third line denotes N space seperated integers denoting the weight of each word in the dictionary.
Fourth line denotes M space seperated integers denoting the prefixes.


Output Format

For every prefix B[i], print the space seperated output on a new line.

NOTE: After every output there should be a space.



Example Input

Input 1:

 1
 6 3
 abcd aecd abaa abef acdcc acbcc
 2 1 3 4 6 5
 ab abc a
Input 2:

 1
 5 3
 aaaa aacd abaa abaa aadcc
 3 4 1 2 6 
 aa aba abc


Example Output

Output 1:

 abef abaa abcd 
 abcd 
 acdcc acbcc abef abaa abcd 
Output 2:

 aadcc aacd aaaa 
 abaa abaa 
 -1 


Example Explanation

Explanation 1:

 For the prefix "ab" 3 words in the dictionary have same prefix: ("abcd" : 2, "abaa" : 3, "abef" : 4). Ouput them in decreasing order of weight.
 For the prefix "abc" only 1 word in the dictionary have same prefix: ("abcd" : 2).
 For the prefix "a" all 6 words in the dictionary have same prefix: ("abcd" : 2, "aecd" : 1, "abaa" : 3, "abef" : 4, "acdcc" : 6, "acbcc" : 5).
 Since we can output atmost 5 words. Output top 5 weighted words in decreasing order of weight.
Explanation 2:

 For the prefix "aa" 3 words in the dictionary have same prefix: ("aaaa" : 3, "aacd" : 4, "aadcc" : 6). Ouput them in decreasing order of weight.
 For the prefix "aba" 2 words in the dictionary have same prefix: ("abaa" : 1, "abaa" : 2).
 For the prefix "abc" there is no word in the dictionary which have same prefix. So print -1.


*/

package trie;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node2 {
    Node2[] links;
    boolean flag;
    int terminalWeight;
    int terminalCount;

    Node2() {
        links = new Node2[26];
        flag = false;
        terminalWeight = -1;
        terminalCount = 0;
    }
}

class Trie2 {
    Node2 head;

    Trie2() {
        head = new Node2();
        head.flag = true;
    }

    public void insert(String word, int weight) {
        char[] chArr = word.toCharArray();
        Node2 temp = head;
        for (int i = 0; i < chArr.length; i++) {
            char ch = chArr[i];
            if (temp.links[ch - 'a'] == null) {
                temp.links[ch - 'a'] = new Node2();
            }
            temp.links[ch - 'a'].flag = true;
            temp = temp.links[ch - 'a'];
        }

        temp.terminalWeight = weight;
        temp.terminalCount++;
    }

    public boolean search(String word) {
        char[] chArr = word.toCharArray();
        Node2 temp = head;
        for (int i = 0; i < chArr.length; i++) {
            char ch = chArr[i];
            if (temp.links[ch - 'a'] != null && temp.links[ch - 'a'].flag == true) {
                temp = temp.links[ch - 'a'];
            } else {
                return false;
            }
        }

        return true;
    }

    private class Pair {
        int weight;
        String word;

        Pair(int weight, String word) {
            this.weight = weight;
            this.word = word;
        }
    }

    public ArrayList<String> autoComplete(String prefix) {
        PriorityQueue<Pair> pairResHeap = new PriorityQueue<>((a, b) -> b.weight - a.weight);
        if (search(prefix)) {

            Node2 node = head;
            char[] chArr = prefix.toCharArray();

            for (int i = 0; i < chArr.length; i++) {
                char ch = chArr[i];
                node = node.links[ch - 'a'];
            }

            StringBuilder temp = new StringBuilder(prefix);
            backtrack(node, temp, pairResHeap);
        }

        ArrayList<String> res = new ArrayList<>();
        int cnt = 0;
        while (!pairResHeap.isEmpty() && cnt < 5) {
            res.add(pairResHeap.poll().word);
            cnt++;
        }

        return res;
    }

    private void backtrack(Node2 node, StringBuilder temp, PriorityQueue<Pair> pairResHeap) {
        if (node.terminalWeight != -1) {
            for (int i = 0; i < node.terminalCount; i++) {
                pairResHeap.add(new Pair(node.terminalWeight, temp.toString()));
            }
        }

        for (int i = 0; i < 26; i++) {
            if (node.links[i] != null && node.links[i].flag == true) {
                temp.append((char) (i + 'a'));
                backtrack(node.links[i], temp, pairResHeap);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}

public class AutoComplete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            ArrayList<String> A = new ArrayList<>();
            ArrayList<Integer> W = new ArrayList<>();
            ArrayList<String> B = new ArrayList<>();
            for (int i = 0; i < n; i++)
                A.add(sc.next());
            for (int i = 0; i < n; i++)
                W.add(sc.nextInt());
            for (int i = 0; i < m; i++)
                B.add(sc.next());

            Trie2 trie = new Trie2();
            for (int i = 0; i < A.size(); i++) {
                trie.insert(A.get(i), W.get(i));
            }
            for (String b : B) {
                ArrayList<String> res = trie.autoComplete(b);
                if (res.isEmpty()) {
                    System.out.println("-1 ");
                } else {
                    res.forEach(word -> System.out.print(word + " "));
                    System.out.println();
                }
            }
        }

        sc.close();
    }
}
