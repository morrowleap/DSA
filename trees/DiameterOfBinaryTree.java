/*
 * https://leetcode.com/problems/diameter-of-binary-tree/
*/

package trees;

public class DiameterOfBinaryTree {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = height(root.left);
        int r = height(root.right);

        diameter = Math.max(diameter, l + r);

        return 1 + Math.max(l, r);
    }

    public static void main(String[] args) {
        String A = "2,1";

        TreeNode At = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(A);

        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(At));
    }
}
