/*
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * https://takeuforward.org/data-structure/level-order-traversal-of-a-binary-tree/
 * https://youtu.be/EoAsWbO7sqg
*/

package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int len = queue.size();

            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            res.add(level);
        }

        return res;
    }
}
