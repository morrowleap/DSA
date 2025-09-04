package trees;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void log(TreeNode root) {
        int h = height(root), w = (1 << h) - 1;
        String[][] a = new String[h][w];
        for (String[] row : a)
            Arrays.fill(row, " ");
        fill(root, a, 0, 0, w - 1);
        for (String[] row : a) {
            for (String s : row)
                System.out.print(s);
            System.out.println();
        }
    }

    private static int height(TreeNode n) {
        return n == null ? 0 : 1 + Math.max(height(n.left), height(n.right));
    }

    private static void fill(TreeNode n, String[][] a, int d, int l, int r) {
        if (n == null || l > r)
            return;
        int m = (l + r) / 2;
        a[d][m] = String.valueOf(n.val);
        fill(n.left, a, d + 1, l, m - 1);
        fill(n.right, a, d + 1, m + 1, r);
    }

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