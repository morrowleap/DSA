/*
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
*/

package trees;

import utils.TreeNode;

public class MaximumPathSum {
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPathSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int val = node.val;

        maxPathSum = Math.max(maxPathSum, Math.max(right + left + node.val,
                Math.max(node.val, Math.max(left + node.val, right + node.val))));

        return Math.max(val, Math.max(left + val, right + val));
    }

    public static void main(String[] args) {
        String str = "9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6";

        TreeNode root = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(str);
        TreeNode.log(root);

        System.out.println(new MaximumPathSum().maxPathSum(root));
    }
}
