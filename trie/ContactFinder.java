package trie;

import java.util.ArrayList;
import java.util.List;

class Node4 {
    Node4[] links;
    boolean flag;
    int pathCount;

    Node4() {
        links = new Node4[26];
        flag = true;
        pathCount = 0;
    }
}

class Trie4 {
    Node4 head;

    Trie4() {
        head = new Node4();
    }

    public void insert(String word) {
        Node4 temp = head;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (temp.links[ch - 'a'] == null) {
                temp.links[ch - 'a'] = new Node4();
            }
            temp.links[ch - 'a'].flag = true;
            temp.links[ch - 'a'].pathCount++;
            temp = temp.links[ch - 'a'];
        }
    }

}

public class ContactFinder {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {

    }

    public static void main(String[] args) {
        System.out.println(new ContactFinder().solve(new ArrayList<>(List.of(0, 0, 1, 1)),
                new ArrayList<>(List.of("hack", "hacker", "hac", "hak"))));
        System.out.println(new ContactFinder().solve(new ArrayList<>(List.of(0, 1)),
                new ArrayList<>(List.of("abcde", "abc"))));
    }
}
