/*
 * https://leetcode.com/problems/same-tree/description/
 * 
 * https://takeuforward.org/data-structure/check-if-two-trees-are-identical/
 * https://youtu.be/BhuvF_-PWS0
*/

package trees;

public class IdenticalTrees {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }
}
