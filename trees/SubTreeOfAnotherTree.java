/*
 * https://leetcode.com/problems/subtree-of-another-tree/
*/

package trees;

public class SubTreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        boolean l = isSubtree(root.left, subRoot);
        boolean r = isSubtree(root.right, subRoot);

        if (root.val == subRoot.val) {
            return isSameTree(root, subRoot) || l || r;
        }

        return l || r;
    }

    public boolean isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }

        if ((A == null && B != null) || (A != null && B == null)) {
            return false;
        }

        if (A.val == B.val) {
            boolean l = isSameTree(A.left, B.left);
            boolean r = isSameTree(A.right, B.right);

            return l && r;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String A = "3,4,5,1,2";
        String B = "4,1,2";

        TreeNode At = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(A);
        TreeNode Bt = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(B);

        System.out.println(new SubTreeOfAnotherTree().isSubTree(At, Bt));
    }
}
