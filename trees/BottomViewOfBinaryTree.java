/*
 * https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
*/

package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;

import utils.TreeNode;

public class BottomViewOfBinaryTree {
    public ArrayList<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        TreeMap<Integer, Integer> hash = new TreeMap<>(); // delta, node
        Queue<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.remove();

            TreeNode node = p.node;
            int delta = p.delta;

            hash.put(delta, node.val);

            if (node.left != null) {
                queue.add(new Pair(node.left, delta - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, delta + 1));
            }
        }

        for (int key : hash.keySet()) {
            res.add(hash.get(key));
        }

        return res;
    }
}

class Pair {
    TreeNode node;
    int delta;

    Pair(TreeNode node, int delta) {
        this.node = node;
        this.delta = delta;
    }
}