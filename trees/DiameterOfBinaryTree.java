/*
 * https://leetcode.com/problems/diameter-of-binary-tree/
*/

package trees;

public class DiameterOfBinaryTree {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int l = diameterOfBinaryTree(root.left);
        int r = diameterOfBinaryTree(root.right);

        diameter = Math.max(diameter, 1 + l + r);

        return 1 + Math.max(l, r);
    }

    public static void main(String[] args) {
        String A = "1,2,3,4,5";

        TreeNode At = BuildTreeSerializeAndDeserializeBinaryTree.deserialize(A);

        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(At));
    }
}
