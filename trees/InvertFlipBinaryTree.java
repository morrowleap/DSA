/*
 * https://leetcode.com/problems/invert-binary-tree/description/
 * 
 * https://takeuforward.org/data-structure/check-for-symmetrical-binary-tree/
*/

package trees;

public class InvertFlipBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left, right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);

        return root;
    }
}
