/*
 * https://leetcode.com/problems/implement-trie-prefix-tree/
*/

package trie;

class Node {
    Node[] links;
    boolean flag;
    boolean isTerminal = false;

    Node() {
        links = new Node[26];
        flag = false;
    }
}

public class Trie {
    Node head;

    public Trie() {
        head = new Node();
        head.flag = true;
    }

    public void insert(String word) {
        Node temp = head;
        char[] chArr = word.toCharArray();
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
        return search(word, false);
    }

    public boolean search(String word, boolean startsWith) {
        Node temp = head;
        char[] chArr = word.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            char ch = chArr[i];

            if (temp.links[ch - 'a'] != null && temp.links[ch - 'a'].flag == true) {
                temp = temp.links[ch - 'a'];
            } else {
                return false;
            }
        }

        if (startsWith) {
            return true;
        } else {
            return temp.isTerminal ? true : false;
        }
    }

    public boolean startsWith(String prefix) {
        return search(prefix, true);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // return True
        System.out.println(trie.search("app")); // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app")); // return True
    }
}
