// https://takeuforward.org/data-structure/alien-dictionary-topological-sort-g-26/
// https://youtu.be/U3N_je7tWAs
// https://leetcode.com/problems/alien-dictionary/editorial/
// https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
// https://www.geeksforgeeks.org/problems/alien-dictionary/1

package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {

    private String topoSort(Map<Character, Set<Character>> adjMap) {
        Map<Character, Integer> indegree = new HashMap<>();
        for (Character node : adjMap.keySet()) {
            indegree.put(node, 0);
        }
        for (Map.Entry<Character, Set<Character>> u : adjMap.entrySet()) {
            for (char v : u.getValue()) {
                indegree.put(v, indegree.get(v) + 1);
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (Map.Entry<Character, Integer> e : indegree.entrySet()) {
            if (e.getValue() == 0) {
                queue.add(e.getKey());
            }
        }

        StringBuilder topoSort = new StringBuilder();

        while (!queue.isEmpty()) {
            char node = queue.remove();

            topoSort.append(node);

            for (char nbr : adjMap.get(node)) {
                indegree.put(nbr, indegree.get(nbr) - 1);

                if (indegree.get(nbr) == 0) {
                    queue.add(nbr);
                }
            }
        }

        if (topoSort.length() == adjMap.size()) {
            return topoSort.toString();
        } else {
            return "";
        }
    }

    public String findOrder(String[] words) {
        Map<Character, Set<Character>> adjMap = new HashMap<>();
        for (String w : words)
            for (char c : w.toCharArray())
                adjMap.putIfAbsent(c, new HashSet<>());

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int n1 = w1.length(), n2 = w2.length(), j = 0;
            while (j < n1 && j < n2 && w1.charAt(j) == w2.charAt(j))
                j++;
            if (j == n2 && n1 > n2)
                return ""; // invalid prefix, like: abc ab
            if (j < n1 && j < n2)
                adjMap.get(w1.charAt(j)).add(w2.charAt(j));
        }

        return topoSort(adjMap);
    }

    public static void main(String[] args) {
        String words1[] = { "baa", "abcd", "abca", "cab", "cad" };
        String words2[] = { "caa", "aaa", "aab" };
        String words3[] = { "ab", "cd", "ef", "ad" };
        String words4[] = { "dddc", "a", "ad", "ab", "b", "be", "cd", "cded" };

        AlienDictionary sol = new AlienDictionary();
        System.out.println(sol.findOrder(words1));
        System.out.println(sol.findOrder(words2));
        System.out.println(sol.findOrder(words3));
        System.out.println(sol.findOrder(words4));
    }
}
