/*
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * 
*/

package trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root == null)
            return res.toString();

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.val != 1001) {
                res.append(node.val).append(",");
                if (node.left == null) {
                    node.left = new TreeNode(1001);
                }
                queue.add(node.left);
                if (node.right == null) {
                    node.right = new TreeNode(1001);
                }
                queue.add(node.right);
            } else {
                res.append("#").append(",");
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] serialize = data.split(",");

        if (data.isEmpty()) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        int levelOrderIdx = 0;
        int val = Integer.valueOf(serialize[levelOrderIdx++]);

        TreeNode root = new TreeNode(val);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            String leftVal = serialize[levelOrderIdx++];
            String rightVal = serialize[levelOrderIdx++];

            if (!leftVal.equals("#")) {
                node.left = new TreeNode(Integer.valueOf(leftVal));
            }
            if (!rightVal.equals("#")) {
                node.right = new TreeNode(Integer.valueOf(rightVal));
            }

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}
