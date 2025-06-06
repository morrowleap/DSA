/*
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * 
*/

package trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class BuildTreeSerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
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
                res.append("null").append(",");
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] serialize = data.split(",");

        if (data.isEmpty()) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        int levelOrderIdx = 0;
        int val = Integer.valueOf(serialize[levelOrderIdx++]);

        TreeNode root = new TreeNode(val);
        queue.add(root);
        while (!queue.isEmpty() && levelOrderIdx < serialize.length) {
            TreeNode node = queue.remove();
            String leftVal = serialize[levelOrderIdx++];
            if (!leftVal.equals("null")) {
                node.left = new TreeNode(Integer.valueOf(leftVal));
                queue.add(node.left);
            }
            if (levelOrderIdx < serialize.length) {
                String rightVal = serialize[levelOrderIdx++];
                if (!rightVal.equals("null")) {
                    node.right = new TreeNode(Integer.valueOf(rightVal));
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = deserialize("1,2,null,3,null,4,null,5");

        TreeNode.log(root);
    }
}
