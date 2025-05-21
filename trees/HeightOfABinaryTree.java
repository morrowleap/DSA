/*
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * https://takeuforward.org/data-structure/maximum-depth-of-a-binary-tree/
 * https://youtu.be/eD3tmO66aBA
*/

package trees;

public class HeightOfABinaryTree {
    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left, depth + 1);
        int right = dfs(root.right, depth + 1);
        return 1 + Math.max(left, right);
    }

    public int maxDepth(TreeNode root) {
        return dfs(root, 1);
    }
}
