/*
 * https://leetcode.com/problems/subtree-of-another-tree/
*/

package trees;

import utils.TreeNode;

public class SubTreeOfAnotherTree {
    // public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    // String A = serialize(root);
    // String B = serialize(subRoot);

    // if (A.contains(B)) {
    // return true;
    // }

    // return false;
    // }

    // public String serialize(TreeNode root) {
    // StringBuilder str = new StringBuilder();
    // dfs(root, str);

    // return str.toString();
    // }

    // private void dfs(TreeNode root, StringBuilder str) {
    // if (root == null) {
    // str.append(",#");
    // return;
    // }

    // str.append("," + root.val);

    // dfs(root.left, str);
    // dfs(root.right, str);
    // }

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
        String A = "12";
        String B = "2";

        TreeNode At = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(A);
        TreeNode Bt = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(B);

        System.out.println(new SubTreeOfAnotherTree().isSubtree(At, Bt));
    }
}
